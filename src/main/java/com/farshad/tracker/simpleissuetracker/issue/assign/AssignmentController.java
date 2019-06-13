package com.farshad.tracker.simpleissuetracker.issue.assign;

import com.farshad.tracker.simpleissuetracker.issue.story.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    /**
     * make assignment action
     * assign story to developer and week
     */
    @RequestMapping(value="/assignment", method = RequestMethod.GET)
    public void makeAssignment() {
        assignmentService.makeAssignment();
    }


    /**
     * get assignment summary
     *
     * @return list of string
     */
    @RequestMapping(value="/assignment/summary", method = RequestMethod.GET)
    public List<String> viewAssignment() {
        return assignmentService.getAssignmentSummary();
    }


    /**
     * get Assignment List
     *
     * @return Map<WeekNumber, List < Story of Each week>>
     */
    @RequestMapping(value="/assignments", method = RequestMethod.GET)
    public Map<Integer, List<Story>> getAssignmentList() {
        return assignmentService.getAssignmentList();
    }
}
