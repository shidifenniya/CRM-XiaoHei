package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departService;

    private Department department;

    private List<Department> departmentList;

    public String findAllDepart(){

        departmentList = departService.findAllDepart();

        return SUCCESS;

    }

    public String addOrEditDepart(){

        if(StringUtils.isBlank(department.getDepName())){

            addActionError("部门名称不能为空");

            return INPUT;

        }

        departService.addOrEditDepart(department);

        departmentList = departService.findAllDepart();

        return SUCCESS;

    }

    @Override
    public Department getModel() {

        department = new Department();

        return department;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
