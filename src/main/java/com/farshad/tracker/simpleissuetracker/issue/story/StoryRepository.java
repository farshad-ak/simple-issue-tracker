package com.farshad.tracker.simpleissuetracker.issue.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

    @Query(value = "from Story story where story.status=2 and assignedWeek is null order by story.point desc")
    List<Story> getEstimatedStories();


    @Query(value = "select sum(story.point) from Story story where story.status=2 and assignedWeek is null")
    BigInteger getEstimatedStoryPoints();

    @Query(value = "select sum(story.point) from Story story where story.status=2 and assignedWeek=:weekNumber")
    Long getEstimatedPointCountForWeek(@Param(value = "weekNumber") Integer weekNumber);

    @Query(value = "from Story story where story.status=2 and (story.point < :remainingValue or story.point=:remainingValue) and assignedWeek is null order by story.point desc")
    List<Story> getStoryWithClosestPointTo(@Param(value = "remainingValue") Integer remainingPoint);

    @Query(value="SELECT d.ID as DEVELOPER, sum(i.POINT) as point from issuetrackerdb.developers d LEFT OUTER JOIN issuetrackerdb.issues i on i.DEVELOPER_ID=d.ID and i.ASSIGNED_WEEK=:weekId GROUP BY d.ID ORDER by sum(i.POINT) ASC", nativeQuery = true)
    List<Object[]> getMostAvailableDeveloperIdForStory(@Param("weekId") Integer weekId);

    @Query(value = "from Story story where story.status=2 and assignedWeek is not null and story.developerId is not null order by story.assignedWeek")
    List<Story> getAssignmentList();


}
