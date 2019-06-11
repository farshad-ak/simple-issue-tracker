package com.farshad.tracker.simpleissuetracker.developer;

import com.farshad.tracker.simpleissuetracker.developer.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {

    Developer add(String name);

    Developer save(Developer developer);

    Optional<Developer> find(Long id);

    List<Developer> findAll();

    List<Developer> findAll(Sort sort);

    Page<Developer> findAll(Pageable pageable);

    void delete(Long id);

   long count();

}