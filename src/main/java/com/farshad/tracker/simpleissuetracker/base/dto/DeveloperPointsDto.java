package com.farshad.tracker.simpleissuetracker.base.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperPointsDto {
    private Integer developerId;
    private Integer points;
}
