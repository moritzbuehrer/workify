package com.workify.Workify.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TimePiece {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String comment;
    private Date date;
    private Long duration;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TimePiece(){

    }

    public TimePiece(String comment, Date date, Long duration, Project project) {
        this.comment = comment;
        this.date = date;
        this.duration = duration;
        this.project = project;
    }
}
