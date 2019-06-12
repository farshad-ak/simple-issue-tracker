package com.farshad.tracker.simpleissuetracker.issue.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

    /**
     * getStories with  Estimated status
     *
     * @return List of Estimated Story
     */
    @Query(value = "from Story story where story.status=2 and assignedWeek is null order by story.point desc")
    List<Story> getEstimatedStories();


    /**
     * get sum of Estimated Story Points which assignedWeek is null
     *
     * @return sum of Estimated Story Points
     */
    @Query(value = "select sum(story.point) from Story story where story.status=2 and assignedWeek is null")
    BigInteger getEstimatedStoryPoints();

    /**
     * get Count of Estimated Point  For a Week
     *
     * @param weekNumber a Week
     * @return Count of Estimated Point
     */
    @Query(value = "select sum(story.point) from Story story where story.status=2 and assignedWeek=:weekNumber")
    Long getEstimatedPointCountForWeek(@Param(value = "weekNumber") Integer weekNumber);


    /**
     * get Story With Closest Point to remainingPoint
     *
     * @param remainingPoint remaining Point
     * @return List of Story
     */
    @Query(value = "from Story story where story.status=2 and (story.point < :remainingValue or story.point=:remainingValue) and assignedWeek is null order by story.point desc")
    List<Story> getStoryWithClosestPointTo(@Param(value = "remainingValue") Integer remainingPoint);


    /**
     * get Most Available Developer Id ForStory
     *
     * @param weekId week id
     * @return list of Developer/point Object
     */
    @Query(value="SELECT d.ID as DEVELOPER, sum(i.POINT) as point from issuetrackerdb.developers d LEFT OUTER JOIN issuetrackerdb.issues i on i.DEVELOPER_ID=d.ID and i.ASSIGNED_WEEK=:weekId GROUP BY d.ID ORDER by sum(i.POINT) ASC", nativeQuery = true)
    List<Object[]> getMostAvailableDeveloperIdForStory(@Param("weekId") Integer weekId);


    /**
     * get Assignment List
     *
     * @return
     */
    @Query(value = "from Story story where story.status=2 and assignedWeek is not null and story.developerId is not null order by story.assignedWeek")
    List<Story> getAssignmentList();


}
