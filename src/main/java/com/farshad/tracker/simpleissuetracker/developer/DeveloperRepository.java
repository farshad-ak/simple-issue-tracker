package com.farshad.tracker.simpleissuetracker.developer;

import com.farshad.tracker.simpleissuetracker.developer.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}