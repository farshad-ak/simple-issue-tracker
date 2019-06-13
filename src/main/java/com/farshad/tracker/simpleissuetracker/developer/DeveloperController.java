package com.farshad.tracker.simpleissuetracker.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    /**
     * create a new Developer
     *
     * @param developer Devloper Entity ojject
     * @return created developer
     */
    @PostMapping("/developer")
    public Developer save(@RequestBody Developer developer){
        return developerService.save(developer);
    }


    /**
     * find a developer by id
     *
     * @param id developer ID
     * @return found developer
     */
    @GetMapping("/developer/{id}")
    public Optional<Developer> getById(@PathVariable(value = "id") Long id){
        return developerService.find(id);
    }

    /**
     * get all developers list
     *
     * @return all developers list
     */
    @GetMapping("/developers")
    public List<Developer> getAll(){
        return developerService.findAll();
    }

    /**
     * Delete a developer by id
     *
     * @param id developer id
     */
    @DeleteMapping("/developer/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        developerService.delete(id);
    }

    /**
     * Get count of developer
     *
     * @return developer count
     */
    @GetMapping("/developer/count")
    public long count(){
        return developerService.count();
    }
}
