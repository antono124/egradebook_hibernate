package com.antogeo.dao;


import com.antogeo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultDao extends AbstractDao {


    @Autowired
    private HibernateUtil hu;

    @Override
    public Result insert(Object o) {
        return (Result) hu.insert(o);
    }

    @Override
    public Result update(Object o) {
        return (Result) hu.update(o);
    }

    @Override
    public List<Result> getObjectsByStudentId(long studentId) {
        return (List<Result>) hu.selectListById("Result", "student", studentId);
    }

    @Override
    public Result getObjectById(long objectId) {
        return (Result) hu.selectById("Result", "resultId", objectId);
    }

    @Override
    public boolean deleteObjectById(long objectId) {
        return hu.deleteById(Result.class, objectId);
    }
}
