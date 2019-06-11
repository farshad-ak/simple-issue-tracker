package com.farshad.tracker.simpleissuetracker.issue.story;

import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<Story> find(Long id) {
        return storyRepository.findById(id);
    }

    @Override
    public Story add(Story story) {
        story.setCreationDate(LocalDateTime.now());
        return storyRepository.save(story);
    }

    @Override
    public Story save(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public void delete(Long developerId) {
        storyRepository.deleteById(developerId);
        ;
    }

    @Override
    public List<Integer> getEstimatedPointList() {
        return StoryEstimatedPointEnum.getList();
    }

    @Override
    public BigInteger getEstimatedStoryPoints() {
        return storyRepository.getEstimatedStoryPoints();
    }

    @Override
    public HashMap<Integer, String> getStoryStatusMap() {
        return (HashMap<Integer, String>) StoryStatusEnum.getMap();
    }

    @Override
    public Map<Long, Story> getEstimatedStories() {
        Map<Long, Story> result = new HashMap<Long, Story>();
        for (Story story : storyRepository.getEstimatedStories()) {
            result.put(story.getId(), story);
        }
        return result;
    }

    @Override
    public Long getEstimatedPointCountForWeek(Integer weekNumber) {
        return storyRepository.getEstimatedPointCountForWeek(weekNumber);

    }

    @Override
    public Story getStoryWithClosestPointTo(Integer remainingPoint) {
        List<Story> resultList = storyRepository.getStoryWithClosestPointTo(remainingPoint);
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public DeveloperPointsDto getMostAvailableDeveloperIdForStory(Integer week) {
        DeveloperPointsDto developerPoints = null;
        List<Object[]> queryResult = storyRepository.getMostAvailableDeveloperIdForStory(week);
        if(queryResult.size() > 0) {
            Object[] tuple = queryResult.get(0);

            developerPoints = new DeveloperPointsDto();

            developerPoints.setDeveloperId(((BigInteger) tuple[0]).longValue());
            if(tuple[1] != null) {
                developerPoints.setPoints(((BigInteger) tuple[1]).intValue());
            }
            else {
                developerPoints.setPoints(0);
            }

        }
        return developerPoints;
    }

    @Override
    public Map<Integer, List<Story>> getAssignmentList() {
        Map<Integer, List<Story>> assignmentList = new HashMap<Integer, List<Story>>();
        List<Story> stories = storyRepository.getAssignmentList();
        List<Story> storyListForCurrentWeek;
        for (Story storyItem : stories) {
            if (assignmentList.containsKey(storyItem.getAssignedWeek())) {
                storyListForCurrentWeek = assignmentList.get(storyItem.getAssignedWeek());
                storyListForCurrentWeek.add(storyItem);
            } else {
                storyListForCurrentWeek = new ArrayList<Story>();
                storyListForCurrentWeek.add(storyItem);
                assignmentList.put(storyItem.getAssignedWeek(), storyListForCurrentWeek);
            }
        }
        return assignmentList;
    }
}
