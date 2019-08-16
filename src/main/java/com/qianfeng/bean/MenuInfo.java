package com.qianfeng.bean;

import lombok.Data;

import java.util.List;

@Data
public class MenuInfo {
    int mid;
    String menuName;
    String menuIcon;
    String menuUrl = "";
    int parentId;
    List<MenuInfo> childMenus;
    List<RoleInfo> roleInfoList;

}
