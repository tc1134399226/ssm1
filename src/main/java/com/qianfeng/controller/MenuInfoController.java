package com.qianfeng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.bean.MenuInfo;
import com.qianfeng.dto.MenuRoleDTO;
import com.qianfeng.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("/menuinfo")
@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping("listMenuInfoByroleId")
    @ResponseBody
    public Object listMenuInfoByroleId(Integer roleid){
        return menuInfoService.listMenuInfoByroleId(roleid);
    }

    @RequestMapping("updateRoleMenu")
    @ResponseBody
    public boolean updateRoleMenu(@RequestBody MenuRoleDTO menuRoleDTO){
        return menuInfoService.updateRoleMenu(menuRoleDTO);
    }

    @RequestMapping("listAllMenuInfo")
    @ResponseBody
    public Object listAllMenuInfo(Integer pageNo){
        Integer pageSize=4;//每页显示记录数
        //分页查询
        System.out.println(pageNo);
        PageHelper.startPage(pageNo, pageSize);
        List<MenuInfo> menuList = menuInfoService.listAllMenuInfo();;//获取所有用户信息
        PageInfo<MenuInfo> pageInfo=new PageInfo<MenuInfo>(menuList);
        return pageInfo;
    }

}
