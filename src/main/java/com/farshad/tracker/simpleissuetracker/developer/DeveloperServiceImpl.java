package com.farshad.tracker.simpleissuetracker.developer;

import com.farshad.tracker.simpleissuetracker.developer.Developer;
import com.farshad.tracker.simpleissuetracker.developer.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Optional<Developer> find(Long id) {
        return developerRepository.findById(id);
    }

    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public List<Developer> findAll(Sort sort){
        return developerRepository.findAll(sort);
    }

    @Override
    public Page<Developer> findAll(Pageable pageable){
        return developerRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    developerRepository.deleteById(id);
    }

    @Override
    public void delete(Developer developer) {
        developerRepository.delete(developer);
    }

    @Override
    public void deleteAll() {
        developerRepository.deleteAll();
    }

    @Override
    public long count() {
        return developerRepository.count();
    }

}