package com.workify.Workify.FormObjects;

import lombok.Data;

@Data
public class TimeForm {

    private String projectId;
    private String comment;
    private String date;
    private String fromTime;
    private String toTime;

}
