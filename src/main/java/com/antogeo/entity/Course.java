package com.antogeo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class")
public class Course {

    private long courseId;
    private String name;
    private String description;
    private String semester;
    private Set<Student> students = new HashSet<>();
    private Set<Results> results = new HashSet<>();

    public Course() {
    }

    @Id
    @GeneratedValue
    @Column(name="class_id")
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="student_class",
                joinColumns = {@JoinColumn(name="class_id")},
                inverseJoinColumns = {@JoinColumn(name="student_id")})
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "class")
    public Set<Results> getResults() {
        return results;
    }

    public void setResults(Set<Results> results) {
        this.results = results;
    }
}
