package com.farshad.tracker.simpleissuetracker.issue.story;

import com.farshad.tracker.simpleissuetracker.base.dto.DeveloperPointsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class StoryServiceImpl implements StoryService {


    @Autowired
    private StoryRepository storyRepository;


    /**
     * @return
     * @inheritDoc
     */
    @Override
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    /**
     * @inheritDoc
     *
     * @param id story Id
     * @return
     */
    @Override
    public Optional<Story> find(Long id) {
        return storyRepository.findById(id);
    }

    /**
     * @inheritDoc
     *
     * @param story Story Object
     * @return
     */
    @Override
    public Story add(Story story) {
        story.setCreationDate(LocalDateTime.now());
        story.setVersion(1l);
        return storyRepository.save(story);
    }

    /**
     * @inheritDoc
     *
     * @param story Story Object
     * @return
     */
    @Override
    public Story update(Story story) {
        return storyRepository.save(story);
    }


    /**
     * @inheritDoc
     *
     * @param developerId story id
     */
    @Override
    public void delete(Long developerId) {
        storyRepository.deleteById(developerId);
    }


    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public List<Integer> getEstimatedPointList() {
        return StoryEstimatedPointEnum.getList();
    }


    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public BigInteger getEstimatedStoryPoints() {
        return storyRepository.getEstimatedStoryPoints();
    }


    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public HashMap<Integer, String> getStoryStatusMap() {
        return (HashMap<Integer, String>) StoryStatusEnum.getMap();
    }


    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public Map<Long, Story> getEstimatedStories() {
        Map<Long, Story> result = new HashMap<Long, Story>();
        for (Story story : storyRepository.getEstimatedStories()) {
            result.put(story.getId(), story);
        }
        return result;
    }


    /**
     * @inheritDoc
     *
     * @param weekNumber week Number
     * @return
     */
    @Override
    public Long getEstimatedPointCountForWeek(Integer weekNumber) {
        return storyRepository.getEstimatedPointCountForWeek(weekNumber);

    }

    /**
     * @inheritDoc
     *
     * @param remainingPoint remaining Point
     * @return
     */
    @Override
    public Story getStoryWithClosestPointTo(Integer remainingPoint) {
        List<Story> resultList = storyRepository.getStoryWithClosestPointTo(remainingPoint);
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }


    /**
     * @inheritDoc
     *
     * @param week week number
     * @return
     */
    @Override
    public DeveloperPointsDto getMostAvailableDeveloperIdForStory(Integer week) {
        DeveloperPointsDto developerPoints = null;
        List<Object[]> queryResult = storyRepository.getMostAvailableDeveloperIdForStory(week);
        if (queryResult.size() > 0) {
            Object[] tuple = queryResult.get(0);

            developerPoints = new DeveloperPointsDto();

            developerPoints.setDeveloperId(((BigInteger) tuple[0]).longValue());
            if (tuple[1] != null) {
                developerPoints.setPoints(Long.parseLong(tuple[1].toString()));
            } else {
                developerPoints.setPoints(0l);
            }

        }
        return developerPoints;
    }


    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public Map<Integer, List<Story>> getAssignmentList() {
        Map<Integer, List<Story>> assignmentList = new HashMap<Integer, List<Story>>();
        List<Story> stories = storyRepository.getAssignmentList();
        List<Story> storyListForCurrentWeek;
        for (Story storyItem : stories) {
            if (assignmentList.containsKey(storyItem.getAssignedWeek())) {
                storyListForCurrentWeek = assignmentList.get(storyItem.getAssignedWeek());
                storyListForCurrentWeek.add(storyItem);
            } else {
                storyListForCurrentWeek = new ArrayList<Story>();
                storyListForCurrentWeek.add(storyItem);
                assignmentList.put(storyItem.getAssignedWeek(), storyListForCurrentWeek);
            }
        }
        return assignmentList;
    }
}
