package com.farshad.tracker.simpleissuetracker.issue.bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BugController {

    @Autowired
    private BugService bugService;

    /**
     * create a New Bug
     *
     * @param bug Bug object
     * @return created Object - 200 - ok
     */
    @PostMapping("/bug")
    public Bug save(@RequestBody Bug bug){
        return bugService.save(bug);
    }


    /**
     * fing a bug by id
     *
     * @param id bug Id
     * @return found Bug Object
     */
    @GetMapping("/bug/{id}")
    public Optional<Bug> getById(@PathVariable(value = "id") Long id){
        return bugService.find(id);
    }


    /**
     * list of Bugs
     *
     * @return list of Bugs
     */
    @GetMapping("/bugs")
    public List<Bug> getAll(){
        return bugService.findAll();
    }

    /**
     * delete a bug by Id
     *
     * @param id bug Id
     */
    @DeleteMapping("/bug/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        bugService.delete(id);
    }

    /**
     * count of bug
     *
     * @return count of bug
     */
    @GetMapping("/bug/count")
    public long count(){
        return bugService.count();
    }


    /**
     * get bug Status Map
     *
     * @return bug Status Map
     */
    @RequestMapping(value="/bugs/status", method = RequestMethod.GET)
    public HashMap<Integer, String> getStatusMap() {
        return bugService.getBugStatusMap();
    }

    /**
     * get bug Priority Map
     *
     * @return bug Priority Map
     */
    @RequestMapping(value="/bugs/priorities", method = RequestMethod.GET)
    public HashMap<Integer, String> getPriorityMap() {
        return bugService.getBugPriorityMap();
    }
}