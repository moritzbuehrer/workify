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
    private double duration;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TimePiece(){

    }

    public TimePiece(String comment, Date date, double duration, Project project) {
        this.comment = comment;
        this.date = date;
        this.duration = duration;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
