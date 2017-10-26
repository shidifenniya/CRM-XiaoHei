package com.lanou.action;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.domain.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import com.lanou.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */

@Controller("StaffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff>{

    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departService;

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    private Staff staff;

    private List<Staff> staffs;

    private List<Department> departmentList;

    private String depID;

    private String postId;

    private Set<Post> posts;

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

//        System.out.println(staffs);

        return SUCCESS;

    }

    public void validateLogin(){

        if(StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())){

            addActionError("用户名或密码不能为空,请重新输入!");

        }

    }

    public String findAllDepartAjax(){

        this.departmentList = departService.findAllDepart();

//        System.out.println(departmentList);

        return SUCCESS;

    }

    public String findPostByDepatId(){

        if(depID.equals("-1")){

            posts = new HashSet<>();

            return SUCCESS;

        }

        posts = departService.findDepartById(depID).getPosts();

        System.out.println(posts);

        return SUCCESS;
    }

    /* 修改与添加共用方法 */
    public String addStaff(){

        List<String> msgs = passForm();

        if(!msgs.isEmpty()){

            for (String msg : msgs) {

                addActionError(msg);

            }

            return INPUT;
        }

        Post post = postService.findPostById(postId);

        staffService.addStaff(post,staff);

        this.staffs = staffService.findAllStaff();

        return SUCCESS;

    }

    /* 进入修改员工页面方法,进行表单回显 */
    public String intoEditStaff(){

//        System.out.println("员工id:" + staff.getStaffId());

        this.staff = staffService.findStaffById(staff.getStaffId());

        this.departmentList = departService.findAllDepart();

        posts = staff.getPost().getDepartment().getPosts();

        return SUCCESS;

    }

    /* 高级查询 */
    public String advancedQuery(){

//        System.out.println(staff.getStaffName());

        staffs = staffService.advancedQuery(depID, postId, staff.getStaffName());

        return SUCCESS;

    }


    @Override
    public Staff getModel() {

        staff = new Staff();

        return staff;
    }


    /* 表单判空方法 */
    private List<String> passForm(){

        List<String> msgs = new ArrayList<>();

        if(postId.equals("-1")) msgs.add("难道这个员工不属于这个单位?");

        if(StringUtils.isBlank(staff.getLoginName())) msgs.add("你拿什么登录啊?亲!");

        if(StringUtils.isBlank(staff.getLoginPwd())) msgs.add("密码怎么不见了?");

        if(StringUtils.isBlank(staff.getStaffName())) msgs.add("可能这个人是个没名字的黑户");

        if(staff.getOnDutyDate() == null) msgs.add("难到这个人的入职时间超过了N个世纪");

        return msgs;

    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
