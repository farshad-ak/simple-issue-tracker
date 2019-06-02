package com.farshad.tracker.simpleissuetracker.issue;

import com.farshad.tracker.simpleissuetracker.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Issue extends BaseEntity {
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Long developerId;
    @Transient
    private String developerName;


}
