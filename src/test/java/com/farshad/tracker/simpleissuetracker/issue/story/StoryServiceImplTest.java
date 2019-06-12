package com.farshad.tracker.simpleissuetracker.issue.story;

import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;
import com.farshad.tracker.simpleissuetracker.issue.IssueTypeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StoryServiceImplTest {

    @Autowired
    private StoryService service;

    @MockBean
    private StoryRepository repository;

    @Test
    @DisplayName("test add Success")
    void testAdd() {
        LocalDateTime now = LocalDateTime.now();
        Story mockStory = new Story();
        mockStory.setCreationDate(now);

        Story newStory = new Story();
        newStory.setCreationDate(now);


        doReturn(mockStory).when(repository).save(any());

        Story returnStory = service.add(mockStory);
        assertNotNull(returnStory, "The saved Story should not be null");
        assertEquals(1, returnStory.getVersion().intValue());
    }

    @Test
    @DisplayName("test Get Estimated Point List")
    void testGetEstimatedPointList() {
        List<Integer> estimatedPointList = service.getEstimatedPointList();

        assertFalse(estimatedPointList.isEmpty());
        assertEquals(7, estimatedPointList.size());
    }

    @Test
    @DisplayName("test Get Estimated Story Points")
    void testGetEstimatedStoryPoints() {
        String value = "10";
        BigInteger mockSum = new BigInteger(value);
        doReturn(mockSum).when(repository).getEstimatedStoryPoints();

        BigInteger estimatedStoryPoints = service.getEstimatedStoryPoints();

        assertNotNull(estimatedStoryPoints, "estimatedStoryPoints should not be null");
        assertEquals(10, estimatedStoryPoints.intValue());
    }

    @Test
    @DisplayName("test Get Story Status Map")
    void testGetStoryStatusMap() {
        HashMap<Integer, String> storyStatusMap = service.getStoryStatusMap();
        assertFalse(storyStatusMap.isEmpty());
        assertEquals("New", storyStatusMap.get(1));
    }

    @Test
    @DisplayName("test Get Estimated Stories")
    void testGetEstimatedStories() {
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());

        List<Story> mockStoryList = new ArrayList<>();

        mockStoryList.add(story);
        doReturn(mockStoryList).when(repository).getEstimatedStories();

        Map<Long, Story> returnEstimatedStories = service.getEstimatedStories();

        assertNull(returnEstimatedStories.get(1L).getAssignedWeek(), "Assign week should be null");
        assertEquals(3, returnEstimatedStories.get(1L).getPoint().longValue(), "the  point is 3");

    }

    @Test
    @DisplayName("Test Get Estimated Point Count For Week")
    void testGetEstimatedPointCountForWeek() {
        Long mockSum = 5L;

        doReturn(mockSum).when(repository).getEstimatedPointCountForWeek(any());

        Long estimatedPointCountForWeek = service.getEstimatedPointCountForWeek(5);

        assertEquals(mockSum, estimatedPointCountForWeek);
    }

    @Test
    @DisplayName("Test Get Story With Closest Point To")
    void testGetStoryWithClosestPointTo() {
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
        mockStories.add(story1);
        mockStories.add(story2);

        doReturn(mockStories).when(repository).getStoryWithClosestPointTo(any());

        Story storyWithClosestPointTo = service.getStoryWithClosestPointTo(3);
        assertNotNull(storyWithClosestPointTo);
        assertEquals(story1, storyWithClosestPointTo);


    }

    @Test
    @DisplayName("test Get Most Available Developer Id For Story")
    void testGetMostAvailableDeveloperIdForStory() {
        List<Object[]> mockDeveloperPointsList = new ArrayList<>();
        Object[] objects1 = {new BigInteger("3"), new BigInteger("10")};
        Object[] objects2 = {new BigInteger("2"), new BigInteger("8")};
        mockDeveloperPointsList.add(objects1);
        mockDeveloperPointsList.add(objects2);
        doReturn(mockDeveloperPointsList).when(repository).getMostAvailableDeveloperIdForStory(any());

        DeveloperPointsDto mostAvailableDeveloperIdForStory = service.getMostAvailableDeveloperIdForStory(1);

        assertNotNull(mockDeveloperPointsList);

        assertEquals((mockDeveloperPointsList.get(0)[0]), new BigInteger(mostAvailableDeveloperIdForStory.getDeveloperId().toString()));
    }

    @Test
    @DisplayName("Test Get Assignment List")
    void testGetAssignmentList() {
        Story story = new Story();
        story.setId(1L);
        story.setPoint(StoryEstimatedPointEnum.THREE.getValue());
        story.setIssueType(IssueTypeEnum.Story.getValue());
        story.setDeveloperId(1L);
        story.setAssignedWeek(1);

        List<Story> mockStoryList = new ArrayList<>();
        mockStoryList.add(story);

        doReturn(mockStoryList).when(repository).getAssignmentList();

        Map<Integer, List<Story>> returnAssignmentList = service.getAssignmentList();

        assertNotNull(returnAssignmentList.get(1).get(0).getAssignedWeek(), "Assign week should Not  be null");
        assertEquals(3, returnAssignmentList.get(1).get(0).getPoint().longValue(), "the  point is 3");
        assertEquals(1, returnAssignmentList.get(1).get(0).getDeveloperId().longValue(), "the  point is 3");
    }
}