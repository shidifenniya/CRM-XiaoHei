package com.lanou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/23.
 */
public interface BaseDao<T> {

    List<T> findAll(String hql);

    List<T> find(String hql, Object[] params);

    List<T> find(String hql, List<String> params);

    T findSingle(String hql, Object[] params);

    T findById(Serializable id, Class<T> tClass);

    void add(T t);

    void update(T t);

}
