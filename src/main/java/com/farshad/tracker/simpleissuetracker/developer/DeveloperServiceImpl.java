package com.farshad.tracker.simpleissuetracker.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    /**
     * @param name developer name
     * @return
     * @inheritDoc
     */
    @Override
    public Developer add(String name) {
        Developer developer = new Developer(name);
        return developerRepository.save(developer);
    }

    /**
     * @inheritDoc
     *
     * @param developer developer Entity
     * @return
     */
    @Override
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    /**
     * @inheritDoc
     *
     * @param id developer id
     * @return
     */
    @Override
    public Optional<Developer> find(Long id) {
        return developerRepository.findById(id);
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }


    /**
     * @inheritDoc
     *
     * @param id  Developer  id
     */
    @Override
    public void delete(Long id) {
    developerRepository.deleteById(id);
    }

    /**
     * @inheritDoc
     *
     * @return
     */
    @Override
    public long count() {
        return developerRepository.count();
    }

}