package com.farshad.tracker.simpleissuetracker.issue.bug;

import com.farshad.tracker.simpleissuetracker.issue.bug.Bug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BugService {

    Bug add(Bug bug);

    Bug save(Bug bug);

    Optional<Bug> find(Long id);

    List<Bug> findAll();

    List<Bug> findAll(Sort sort);

    Page<Bug> findAll(Pageable pageable);

    void delete(Long id);

    long count();

    HashMap<Integer, String> getBugPriorityMap();

    HashMap<Integer, String> getBugStatusMap();
}