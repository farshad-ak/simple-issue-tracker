package com.farshad.tracker.simpleissuetracker.issue.story;

import java.util.ArrayList;
import java.util.List;

public enum StoryEstimatedPointEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    EIGHT(8),
    THIRTEEN(13),
    TWENTY_ONE(21);

    private Integer value;

    private StoryEstimatedPointEnum(Integer val) {
        this.value = val;
    }

    public Integer getValue() {
        return value;
    }

    public static List<Integer> getList() {
        List<Integer> storyEstimatedPointList = new ArrayList<Integer>();
        for (StoryEstimatedPointEnum item : StoryEstimatedPointEnum.values()) {
            // points will be displayed in UI, not the names, values will be shown in list
            storyEstimatedPointList.add(item.getValue());
        }
        return storyEstimatedPointList;
    }

    public static StoryEstimatedPointEnum getByValue(Integer value) {
        StoryEstimatedPointEnum result = StoryEstimatedPointEnum.ONE;
        for (StoryEstimatedPointEnum item : StoryEstimatedPointEnum.values()) {
            if(item.getValue().equals(value)) {
                result = item;
                break;
            }
        }
        return result;
    }

}

