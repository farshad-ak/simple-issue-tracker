package com.farshad.tracker.simpleissuetracker.issue.story;


import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;

import java.math.BigInteger;
import java.util.*;

public interface StoryService {

     List<Story> findAll();

     Optional<Story> find(Long id);

     Story add(Story story) ;

     Story save(Story story) ;

     void delete(Long developerId);

     List<Integer> getEstimatedPointList();

     BigInteger getEstimatedStoryPoints();

     HashMap<Integer, String> getStoryStatusMap();

     Map<Long, Story> getEstimatedStories();

     Long getEstimatedPointCountForWeek(Integer weekNumber);

     Story getStoryWithClosestPointTo(Integer remainingPoint);

     DeveloperPointsDto getMostAvailableDeveloperIdForStory(Integer week);

     Map<Integer, List<Story>> getAssignmentList() ;
}
