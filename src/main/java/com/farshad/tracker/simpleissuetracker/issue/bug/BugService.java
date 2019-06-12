package com.farshad.tracker.simpleissuetracker.issue.bug;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BugService {

    /**
     * add new Bug
     *
     * @param bug Bug Entity
     * @return created Bug object
     */
    Bug add(Bug bug);

    /**
     * save and update new Bug
     *
     * @param bug Bug Entity
     * @return saved Bug object
     */
    Bug save(Bug bug);


    /**
     * find a bug by id
     *
     * @param id Bug Id
     * @return found Bug Object
     */
    Optional<Bug> find(Long id);


    /**
     *find a bugs List
     *
     * @return found Bug List
     */
    List<Bug> findAll();


    /**
     * delete a Bug By Id
     *
     * @param id bud Id
     */
    void delete(Long id);

    /**
     * get count of Bugs
     *
     * @return count of Bugs
     */
    long count();


    /**
     * get bug priority enum value
     *
     * @return bug priorities
     */
    HashMap<Integer, String> getBugPriorityMap();

    /**
     * get bug status enum value
     *
     * @return bug statuses
     */
    HashMap<Integer, String> getBugStatusMap();
}