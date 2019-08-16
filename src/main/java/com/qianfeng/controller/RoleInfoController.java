package com.qianfeng.controller;


import com.qianfeng.bean.User;
import com.qianfeng.dto.RoleUserInfo;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("roleinfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    @RequestMapping("getRoleInfoById")
    @ResponseBody
    public List<RoleInfoVO> getRoleInfoById(Integer userid){
        return roleInfoService.listRoleByUserId(userid);
    }

    @RequestMapping("addRoleUser")
    @ResponseBody
    public boolean addRoleUser(@RequestBody RoleUserInfo roleUserInfo){
        return roleInfoService.addRoleAnd(roleUserInfo);
    }

    @RequestMapping("delRoleUser")
    @ResponseBody
    public boolean delRoleUser(@RequestBody RoleUserInfo roleUserInfo){
        return roleInfoService.delRoleAnd(roleUserInfo);
    }

    @RequestMapping("/listAllRoleInfo")
    @ResponseBody
    public Object listAllUserInfo(){
        return roleInfoService.listAllRoleInfo();
    }
}
