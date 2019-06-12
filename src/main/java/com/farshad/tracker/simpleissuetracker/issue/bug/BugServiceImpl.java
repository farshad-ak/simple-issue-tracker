package com.farshad.tracker.simpleissuetracker.issue.bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;


    /**
     * @param bug Bug Entity
     * @return
     * @inheritDoc
     */
    @Override
    public Bug add(Bug bug) {
        bug.setCreationDate(LocalDateTime.now());
        return bugRepository.save(bug);
    }


    /**
     * @inheritDoc
     *
     * @param bug Bug Entity
     * @return
     */
    @Override
    public Bug save(Bug bug) {
        bug.setCreationDate(LocalDateTime.now());
        return bugRepository.save(bug);
    }


    /**
     * @inheritDoc
     *
     * @param id Bug Id
     * @return
     */
    @Override
    public Optional<Bug> find(Long id) {
        return bugRepository.findById(id);
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public List<Bug> findAll() {
        return bugRepository.findAll();
    }


    /**
     * @inheritDoc
     *
     * @param id bud Id
     */
    @Override
    public void delete(Long id) {
        bugRepository.deleteById(id);
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public long count() {
        return bugRepository.count();
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public HashMap<Integer, String> getBugPriorityMap() {
        return (HashMap<Integer, String>) BugPriorityEnum.getMap();
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public HashMap<Integer, String> getBugStatusMap() {
        return (HashMap<Integer, String>) BugStatusEnum.getMap();
    }

}