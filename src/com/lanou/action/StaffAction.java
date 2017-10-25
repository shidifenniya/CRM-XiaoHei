package com.lanou.action;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;
import com.lanou.service.StaffService;
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

@Controller("StaffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff>{

    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;

    private Staff staff;

    private List<Staff> staffs;

    public String login(){

        Staff staffInfo = staffService.login(this.staff.getLoginName(), this.staff.getLoginPwd());

        if(staffInfo != null){

            this.staff = staffInfo;

            return SUCCESS;

        } else {

            addActionError("用户名或密码错误!");

        }

        return INPUT;

    }

    public String findAll(){

        this.staffs = staffService.findAllStaff();

        System.out.println(staffs);

        return SUCCESS;

    }

    public void validateLogin(){

        if(StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())){

            addActionError("用户名或密码不能为空,请重新输入!");

        }

    }

    @Override
    public Staff getModel() {

        staff = new Staff();

        return staff;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
