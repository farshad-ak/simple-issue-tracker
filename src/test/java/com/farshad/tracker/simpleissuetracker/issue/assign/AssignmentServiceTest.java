package com.farshad.tracker.simpleissuetracker.issue.assign;

import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;
import com.farshad.tracker.simpleissuetracker.developer.DeveloperService;
import com.farshad.tracker.simpleissuetracker.issue.IssueTypeEnum;
import com.farshad.tracker.simpleissuetracker.issue.story.Story;
import com.farshad.tracker.simpleissuetracker.issue.story.StoryEstimatedPointEnum;
import com.farshad.tracker.simpleissuetracker.issue.story.StoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AssignmentServiceTest {

    @MockBean
    private StoryService storyService;

    @MockBean
    private DeveloperService developerService;

    @Autowired
    private AssignmentService assignmentService;


    @Test
    @DisplayName("Test Make Assignment")
    void TestMakeAssignment() {
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());

        Map<Long, Story> mockStoryList = new HashMap<>();
        mockStoryList.put(story.getId(), story);
        doReturn(mockStoryList).when(storyService).getEstimatedStories();
        doReturn(2L).when(developerService).count();
        doReturn(story).when(storyService).getStoryWithClosestPointTo(any());
        DeveloperPointsDto mostAvailableDeveloperandAvailablePoint = new DeveloperPointsDto(2L, 8L);
        doReturn(mostAvailableDeveloperandAvailablePoint).when(storyService).getMostAvailableDeveloperIdForStory(any());
        doReturn(story).when(storyService).update(any());


        Map<Integer, List<Story>> integerListMap = assignmentService.makeAssignment();
        assertNotNull(integerListMap);
    }

    @Test
    @DisplayName("Test Get Assignment Summary")
    void testGetAssignmentSummary() {
        doReturn(2L).when(developerService).count();
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());

        Map<Long, Story> mockStoryList = new HashMap<>();
        mockStoryList.put(story.getId(), story);
        doReturn(mockStoryList).when(storyService).getEstimatedStories();
        doReturn(new BigInteger("10")).when(storyService).getEstimatedStoryPoints();

        List<String> assignmentSummary = assignmentService.getAssignmentSummary();
        assertNotNull(assignmentSummary);
        assertEquals(4, assignmentSummary.size());
    }

    @Test
    @DisplayName("Test Get Remaning Points In Week")
    void testGetRemainingPointsInWeek() {
        Integer mockRemainingPointsInWeek = 20;
        doReturn(5L).when(storyService).getEstimatedPointCountForWeek(1);
        Integer remainingPointsInWeek = assignmentService.getRemainingPointsInWeek(WeeksEnum.WEEK_ONE, 2);
        assertEquals(15, remainingPointsInWeek.intValue());

    }

    @Test
    @DisplayName("Test Get Assignment List")
    void testGetAssignmentList() {
        Map<Integer, List<Story>> mockAssignListMap = new HashMap<>();
        Story story1 = new Story();
        story1.setId(1L);
        story1.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story1.setIssueType(IssueTypeEnum.Story.getValue());
        story1.setDeveloperId(1L);
        story1.setAssignedWeek(1);

        Story story2 = new Story();
        story2.setId(2L);
        story2.setPoint(StoryEstimatedPointEnum.FIVE.getValue());
        story2.setIssueType(IssueTypeEnum.Story.getValue());
        story2.setDeveloperId(2L);
        story2.setAssignedWeek(1);
        List<Story> mockStories = new ArrayList<>();
        mockAssignListMap.put(1, mockStories);
        doReturn(mockAssignListMap).when(storyService).getAssignmentList();

        Map<Integer, List<Story>> assignmentList = assignmentService.getAssignmentList();
        assertNotNull(assignmentList);
        assertEquals(1, assignmentList.size());
    }
}