package com.farshad.tracker.simpleissuetracker.issue.bug;

import com.farshad.tracker.simpleissuetracker.issue.bug.Bug;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BugRepository extends JpaRepository<Bug, Long> {
}