package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;
import com.lanou.service.StaffService;

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

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
