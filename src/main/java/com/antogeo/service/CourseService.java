package com.antogeo.service;


import com.antogeo.dao.CourseDao;
import com.antogeo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
@EnableTransactionManagement
public class CourseService extends AbstractService{

    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional
    public Course insert(Object o) {
        return courseDao.insert(o);
    }

    @Override
    @Transactional
    public Course update(Object o) {

        return courseDao.update(o);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getObjectsByStudentId(long studentId) {

        return courseDao.getObjectsByStudentId(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Course getObjectById(long objectId){

        return courseDao.getObjectById(objectId);
    }

    @Override
    @Transactional
    public boolean deleteObjectById(long objectId) {

        return courseDao.deleteObjectById(objectId);
    }
}
