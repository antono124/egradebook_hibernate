package com.antogeo.dao;

import java.util.List;


public abstract class AbstractDao<T> {

    public abstract T insert(Object o);

    public abstract T update(Object o);

    public abstract List<T> getObjectsByStudentId(long studentId);

    public abstract T getObjectById(long objectId);

    public abstract boolean deleteObjectById(long objectId);

}
