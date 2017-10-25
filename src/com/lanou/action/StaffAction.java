package com.lanou.action;

import com.lanou.domain.Staff;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffAction extends ActionSupport implements ModelDriven<Staff>{

    private Staff staff;

    public String login(){

        return ERROR;

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
}
