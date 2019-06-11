package com.farshad.tracker.simpleissuetracker.issue.assign;

import com.farshad.tracker.simpleissuetracker.issue.story.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value="/assignment", method = RequestMethod.GET)
    public void makeAssignment() {
        assignmentService.makeAssignment();
    }

    @RequestMapping(value="/assignment/summary", method = RequestMethod.GET)
    public List<String> viewAssignment() {
        return assignmentService.getAssignmentSummary();
    }

    @RequestMapping(value="/assignments", method = RequestMethod.GET)
    public Map<Integer, List<Story>> getAssignmentList() {
        return assignmentService.getAssignmentList();
    }
}
