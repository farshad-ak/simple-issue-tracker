package com.farshad.tracker.simpleissuetracker.issue.story;


import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StoryService {

     /**
      * find all story
      *
      * @return Listof all Story
      */
     List<Story> findAll();


     /**
      * find a story by Id
      *
      * @param id story Id
      * @return a Found Story
      */
     Optional<Story> find(Long id);

     /**
      * add a new story
      *
      * @param story Story Object
      * @return created Story
      */
     Story add(Story story) ;


     /**
      * save and update a story
      *
      * @param story Story Object
      * @return created Story
      */
     Story update(Story story) ;

     /**
      * delete a story buy story id
      *
      * @param developerId story id
      */
     void delete(Long developerId);


     /**
      * get Estimated Point List
      *
      * @return Estimated Point List - List<Integer>
      */
     List<Integer> getEstimatedPointList();

     /**
      * get Estimated Story Points
      *
      * @return Estimated Story Points List
      */
     BigInteger getEstimatedStoryPoints();

     /**
      * get Story Status Map
      *
      * @return Story Status Map
      */
     HashMap<Integer, String> getStoryStatusMap();

     /**
      * get Estimated Stories
      *
      * @return Estimated Stories with   Map<StoryId, Story>
      */
     Map<Long, Story> getEstimatedStories();

     /**
      * get Estimated Point Count For Week
      *
      * @param weekNumber week Number
      * @return Estimated Point Count
      */
     Long getEstimatedPointCountForWeek(Integer weekNumber);

     /**
      * get Story With Closest Point To
      *
      * @param remainingPoint remaining Point
      * @return Story With Closest Point To remaining Point
      */
     Story getStoryWithClosestPointTo(Integer remainingPoint);

     /**
      * get Most Available Developer Id ForStory
      *
      * @param week week number
      * @return DeveloperPointsDto
      */
     DeveloperPointsDto getMostAvailableDeveloperIdForStory(Integer week);


     /**
      * get Assignment List
      *
      * @return Assignment List
      */
     Map<Integer, List<Story>> getAssignmentList() ;
}
