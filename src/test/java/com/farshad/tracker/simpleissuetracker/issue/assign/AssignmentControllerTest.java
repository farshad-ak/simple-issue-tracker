package com.farshad.tracker.simpleissuetracker.issue.assign;

import com.farshad.tracker.simpleissuetracker.issue.IssueTypeEnum;
import com.farshad.tracker.simpleissuetracker.issue.story.Story;
import com.farshad.tracker.simpleissuetracker.issue.story.StoryEstimatedPointEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AssignmentControllerTest {

    @MockBean
    private AssignmentService assignmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void makeAssignment() throws Exception {
        Map<Integer, List<Story>> mockListMapStory = new HashMap<>();
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());
        story.setDeveloperId(1L);
        story.setAssignedWeek(1);
        List<Story> mockStoryList = new ArrayList<>();
        mockStoryList.add(story);
        mockListMapStory.put(1, mockStoryList);
        doReturn(mockListMapStory).when(assignmentService).makeAssignment();
        mockMvc.perform(get("/assignment"))
                .andExpect(status().isOk());

    }

    @Test
    void viewAssignment() throws Exception {
        List<String> assignmentSummary = new ArrayList<>();
        assignmentSummary.add("String 1");
        assignmentSummary.add("String 2");
        assignmentSummary.add("String 3");
        assignmentSummary.add("String 4");
        doReturn(assignmentSummary).when(assignmentService).getAssignmentSummary();
        mockMvc.perform(get("/assignment/summary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(4)));

//                assignmentService.getAssignmentSummary();
    }

    @Test
    void getAssignmentList() throws Exception {
        Map<Integer, List<Story>> mockListMapStory = new HashMap<>();
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());
        story.setDeveloperId(1L);
        story.setAssignedWeek(1);
        List<Story> mockStoryList = new ArrayList<>();
        mockStoryList.add(story);
        mockListMapStory.put(1, mockStoryList);
        doReturn(mockListMapStory).when(assignmentService).getAssignmentList();
        mockMvc.perform(get("/assignments"))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.1.[0].id", is(1)))
                .andExpect(jsonPath("$.1.[0].developerId", is(1)))
                .andExpect(jsonPath("$.1.[0].point", is(3)))
                .andExpect(jsonPath("$.1.[0].assignedWeek", is(1)));

    }
}