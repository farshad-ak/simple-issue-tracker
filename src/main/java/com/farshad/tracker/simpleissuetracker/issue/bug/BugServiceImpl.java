package com.farshad.tracker.simpleissuetracker.issue.bug;

import com.farshad.tracker.simpleissuetracker.issue.bug.Bug;
import com.farshad.tracker.simpleissuetracker.issue.bug.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Override
    public Bug add(Bug bug) {
        bug.setCreationDate(LocalDateTime.now());
        return bugRepository.save(bug);
    }

    @Override
    public Bug save(Bug bug) {
        bug.setCreationDate(LocalDateTime.now());
        return bugRepository.save(bug);
    }

    @Override
    public Optional<Bug> find(Long id) {
        return bugRepository.findById(id);
    }

    @Override
    public List<Bug> findAll() {
        return bugRepository.findAll();
    }

    @Override
    public List<Bug> findAll(Sort sort) {
        return bugRepository.findAll(sort);
    }

    @Override
    public Page<Bug> findAll(Pageable pageable) {
        return bugRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        bugRepository.deleteById(id);
    }


    @Override
    public long count() {
        return bugRepository.count();
    }

    @Override
    public HashMap<Integer, String> getBugPriorityMap() {
        return (HashMap<Integer, String>) BugPriorityEnum.getMap();
    }

    @Override
    public HashMap<Integer, String> getBugStatusMap() {
        return (HashMap<Integer, String>) BugStatusEnum.getMap();
    }

}