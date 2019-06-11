package com.farshad.tracker.simpleissuetracker.issue.story;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class StoryController {

    private static final Logger logger = LogManager.getLogger(StoryController.class);

    @Autowired
    private StoryService storyService;

    @GetMapping(value = "/stories")
    public List<Story> getStories() {
        return storyService.findAll();
    }

    @PostMapping(value = "/story")
    public ResponseEntity<?> create(@RequestBody Story story) {

        Story newStory = storyService.add(story);

        try {
            // Build a created response
            return ResponseEntity
                    .created(new URI("/story/" + newStory.getId()))
                    .eTag(newStory.getVersion().toString())
                    .body(newStory);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @PutMapping(value = "/story/{id}")
    public ResponseEntity<?> update(@RequestBody Story story, @PathVariable Long id,
                                    @RequestHeader("If-Match") Integer ifMatch) {

        // Get the existing product
        Optional<Story> existingProduct = storyService.find(id);

        return existingProduct.map(p -> {
            // Compare the etags
            logger.info("Product with ID: " + id + " has a version of " + p.getVersion()
                    + ". Update is for If-Match: " + ifMatch);
            if (!p.getVersion().equals(ifMatch)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            // Update the product
            p.setAssignedWeek(story.getAssignedWeek());
            p.setIssueType(story.getIssueType());
            p.setPoint(story.getPoint());
            p.setStatus(story.getStatus());
            p.setDescription(story.getDescription());
            p.setVersion(p.getVersion() + 1);


            try {
                // Update the product and return an ok response
                if (storyService.update(p) != null) {
                    return ResponseEntity.ok()
                            .location(new URI("/product/" + p.getId()))
                            .eTag(p.getVersion().toString())
                            .body(p);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (URISyntaxException e) {
                // An error occurred trying to create the location URI, return an error
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        }).orElse(ResponseEntity.notFound().build());

//        return storyService.save(story);
    }

    @DeleteMapping(value = "/story/{id}")
    public void delete(@PathVariable(value = "id") Long storyId) {
        storyService.delete(storyId);
    }

    @GetMapping(value = "/story/{id}")
    public ResponseEntity<?> getStory(@PathVariable(value = "id") Long storyId) {

        return storyService.find(storyId)
                .map(story -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/story/" + story.getId()))
                                .eTag(story.getVersion().toString())
                                .body(story);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping(value = "/story/status")
    public HashMap<Integer, String> getStatusMap() {
        return storyService.getStoryStatusMap();
    }

    @GetMapping(value = "/story/point")
    public List<Integer> getEstimatedPointMap() {
        return storyService.getEstimatedPointList();
    }

}