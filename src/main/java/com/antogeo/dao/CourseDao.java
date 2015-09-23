package com.antogeo.dao;

import com.antogeo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao extends AbstractDao {

    @Autowired
    private HibernateUtil hu;

    @Override
    public Course insert(Object o) {
        return (Course) hu.insert(o);
    }

    @Override
    public Course update(Object o) {
        return (Course) hu.update(o);
    }

    @Override
    public List<Course> getObjectsByStudentId(long studentId) {
        return (List<Course>) hu.selectListById("Course", "students", studentId);
    }

    @Override
    public Course getObjectById(long objectId) {
        return (Course) hu.selectById("Course", "courseId", objectId);
    }

    @Override
    public boolean deleteObjectById(long objectId) {
        return hu.deleteById(Course.class, objectId);
    }
}
