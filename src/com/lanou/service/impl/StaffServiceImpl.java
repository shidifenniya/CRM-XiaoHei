package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;
import com.lanou.service.StaffService;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public Staff login(String loginName, String loginPwd) {

        String hql = "from Staff where loginName=? and loginPwd=?";

        Object[] params = {loginName, loginPwd};

        return staffDao.findSingle(hql, params);

    }

    @Override
    public List<Staff> findAllStaff() {

        String hql = "from Staff";

        return staffDao.findAll(hql);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
