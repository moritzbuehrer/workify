package com.workify.Workify.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TimePiece {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String comment;
    private Date date;
    private double duration;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String userName;

    public TimePiece(){

    }

    public TimePiece(String comment, Date date, double duration, Project project, String userName) {
        this.comment = comment;
        this.date = date;
        this.duration = duration;
        this.project = project;
        this.userName = userName;
    }

}
