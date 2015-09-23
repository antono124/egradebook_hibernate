package com.antogeo.service;

import com.antogeo.dao.StudentDao;
import com.antogeo.entity.Course;
import com.antogeo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@EnableTransactionManagement
public class StudentService extends AbstractService {

    @Autowired
    private StudentDao  studentDao;

    @Autowired
    private CourseService courseService;

    @Override
    @Transactional
    public Student insert(Object o) {

        return studentDao.insert(o);
    }

    @Override
    @Transactional
    public Student update(Object o) {

        return studentDao.update(o);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getObjectsByStudentId(long studentId) {

        return studentDao.getObjectsByStudentId(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getObjectById(long objectId) {

        return studentDao.getObjectById(objectId);
    }

    @Override
    @Transactional
    public boolean deleteObjectById(long objectId)
    {
        return studentDao.deleteObjectById(objectId);
    }
}
