package com.farshad.tracker.simpleissuetracker.issue.bug;

import com.farshad.tracker.simpleissuetracker.issue.bug.Bug;
import com.farshad.tracker.simpleissuetracker.issue.bug.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/bug")
    public Bug save(@RequestBody Bug bug){
        return bugService.save(bug);
    }

    @GetMapping("/bug/{id}")
    public Optional<Bug> getById(@PathVariable(value = "id") Long id){
        return bugService.find(id);
    }

    @GetMapping("/bugs")
    public List<Bug> getAll(){
        return bugService.findAll();
    }

    @DeleteMapping("/bug/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        bugService.delete(id);
    }

    @GetMapping("/bug/count")
    public long count(){
        return bugService.count();
    }

    @RequestMapping(value="/bugs/status", method = RequestMethod.GET)
    public HashMap<Integer, String> getStatusMap() {
        return bugService.getBugStatusMap();
    }

    @RequestMapping(value="/bugs/priorities", method = RequestMethod.GET)
    public HashMap<Integer, String> getPriorityMap() {
        return bugService.getBugPriorityMap();
    }
}