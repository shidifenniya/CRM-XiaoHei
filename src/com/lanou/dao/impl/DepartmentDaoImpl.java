package com.lanou.dao.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.Department;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    @Override
    public void addDepart(Department department) {

        getHibernateTemplate().save(department);

    }

    @Override
    public void updateDepart(Department department) {

        getHibernateTemplate().update(department);

    }
}
