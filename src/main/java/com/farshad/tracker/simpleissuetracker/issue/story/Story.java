package com.farshad.tracker.simpleissuetracker.issue.story;

import com.farshad.tracker.simpleissuetracker.developer.Developer;
import com.farshad.tracker.simpleissuetracker.issue.Issue;
import com.farshad.tracker.simpleissuetracker.issue.IssueTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ISSUES")
@Where(clause = " TYPE = 2")
public class Story extends Issue {
    @Column(name = "TYPE")
    private Integer issueType = IssueTypeEnum.Story.getValue();

    private Integer status;

    private Integer point;

    private Integer assignedWeek;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "developer_id",
//            foreignKey = @ForeignKey(name = "developer_ID_FK")
//    )
//    private Developer developer;
}
