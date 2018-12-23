package com.workify.Workify.Entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class TrackerStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date startDate;

    private String username;

    public TrackerStatus() {

    }
}
