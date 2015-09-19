package com.antogeo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

    private long classId;
    private String name;
    private String description;
    private String semester;

    public Class() {
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
