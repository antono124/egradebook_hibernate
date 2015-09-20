package com.antogeo.dao;


import com.antogeo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao extends AbstractDao {

    @Autowired
    private HibernateUtil hu;

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student insert(Object o) {
        return (Student) hu.insert(o);
    }

    @Override
    public Student update(Object o) {
        return (Student) hu.update(o);
    }

    @Override
    public List<Student> getObjectsByStudentId(long studentId) {
        return null;
    }

    @Override
    public Student getObjectById(long objectId) {
        return (Student) hu.selectById("Student", "studentId", objectId);
    }

    @Override
    public boolean deleteObjectById(long objectId) {
        return hu.deleteById(Student.class, objectId);
    }
}
