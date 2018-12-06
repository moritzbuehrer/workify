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
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TimePiece(){

    }

    public TimePiece(String comment, Date date, Double duration, Project project) {
        this.comment = comment;
        this.date = date;
        this.duration = duration;
        this.project = project;
    }
}
