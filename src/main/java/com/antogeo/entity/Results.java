package com.antogeo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "results")
public class Results {

    private long resultId;
    private int grade;
    private Student student;
    private Course course;
    private Date creationDate;


    public Results() {
    }

    @Id
    @GeneratedValue
    @Column(name="result_id")
    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    @Column(name="grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @ManyToOne
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @ManyToOne
    @JoinColumn(name="class_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Column(name="creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
