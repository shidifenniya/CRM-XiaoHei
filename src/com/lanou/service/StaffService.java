package com.lanou.service;

import com.lanou.domain.Staff;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffService {

    Staff login(String loginName, String loginPwd);

}
