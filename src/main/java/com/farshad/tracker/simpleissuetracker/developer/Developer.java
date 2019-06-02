package com.farshad.tracker.simpleissuetracker.developer;

import com.farshad.tracker.simpleissuetracker.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DEVELOPERS")
public class Developer   extends BaseEntity {
    private String name;
}
