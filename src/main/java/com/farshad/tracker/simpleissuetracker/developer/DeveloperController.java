package com.farshad.tracker.simpleissuetracker.developer;

import com.farshad.tracker.simpleissuetracker.developer.Developer;
import com.farshad.tracker.simpleissuetracker.developer.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("/developer")
    public Developer save(@RequestBody Developer developer){
        return developerService.save(developer);
    }

    @GetMapping("/developer/{id}")
    public Optional<Developer> getById(@PathVariable(value = "id") Long id){
        return developerService.find(id);
    }

    @GetMapping("/developers")
    public List<Developer> getAll(){
        return developerService.findAll();
    }

    @DeleteMapping("/developer/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        developerService.delete(id);
    }

    @GetMapping("/developer/count")
    public long count(){
        return developerService.count();
    }
}