package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.Department;
import com.lanou.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAllDepart() {

        String hql = "from Department";

        return departmentDao.findAll(hql);
    }

    @Override
    public void addOrEditDepart(Department department) {

        if (department.getDepID().equals("")) {

            departmentDao.addDepart(department);

        } else {

            departmentDao.updateDepart(department);

        }
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
