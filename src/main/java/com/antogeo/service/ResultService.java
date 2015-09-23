package com.antogeo.service;


import com.antogeo.dao.ResultDao;
import com.antogeo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("resultService")
@EnableTransactionManagement
public class ResultService extends AbstractService {

    @Autowired
    private ResultDao resultDao;

    @Override
    @Transactional
    public Result insert(Object o) {

        return resultDao.insert(o);
    }

    @Override
    @Transactional
    public Result update(Object o) {

        return resultDao.update(o);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Result> getObjectsByStudentId(long studentId) {

        return resultDao.getObjectsByStudentId(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Result getObjectById(long objectId) {

        return resultDao.getObjectById(objectId);
    }

    @Override
    @Transactional
    public boolean deleteObjectById(long objectId) {

        return resultDao.deleteObjectById(objectId);
    }
}
