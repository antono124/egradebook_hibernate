package com.antogeo.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    private long studentId;
    private String username;
    private String password;
    private Date creationDate;
    private StudentInfo studentInfo;
    private Set<Result> resultSet = new HashSet<>();
    private Set<Course> courseSet = new HashSet<>();


    public Student() {
    }

    public Student(String username,
                   String password,
                   Date creationDate) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue
    @Column(name="student_id")
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    public Set<Result> getResultSet() {
        return resultSet;
    }

    public void setResultSet(Set<Result> resultSet) {
        this.resultSet = resultSet;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
}
