package com.farshad.tracker.simpleissuetracker.developer;

import java.util.List;
import java.util.Optional;

/**
 * @author Farshad Akbari
 */
public interface DeveloperService {

    /**
     * add new developer by name
     *
     * @param name developer name
     * @return created developer
     */
    Developer add(String name);

    /**
     * save  and update new Developer
     *
     * @param developer developer Entity
     * @return created developer
     */
    Developer save(Developer developer);

    /**
     * find a developer by id
     *
     * @param id developer id
     * @return finded Developer
     */
    Optional<Developer> find(Long id);

    /**
     * Get list of Of Developer
     *
     * @return List of Developer
     */
    List<Developer> findAll();

    /**
     * delete a Developer by id
     *
     * @param id Developer  id
     */
    void delete(Long id);


    /**
     * count up developer
     *
     * @return count of developer
     */
    long count();

}