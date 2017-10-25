package com.lanou.service;

import com.lanou.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {

    List<Department> findAllDepart();

    void addOrEditDepart(Department department);

}
