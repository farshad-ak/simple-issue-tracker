package com.farshad.tracker.simpleissuetracker.issue.bug;

import com.farshad.tracker.simpleissuetracker.issue.Issue;
import com.farshad.tracker.simpleissuetracker.issue.IssueTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ISSUES")
@Where(clause = " TYPE = 1")
public class Bug extends Issue {
    @Column(name = "TYPE")
    private Integer issueType = IssueTypeEnum.Bug.getValue();

    private Integer status;


    private Integer priority;
}
