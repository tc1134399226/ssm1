package com.qianfeng.vo;

import lombok.Data;

import java.util.List;
@Data
public class RoleMenuVO {
//    "id": 1,
//    "pid": 0,
//    "seqno": 0,
//    "name": "系统权限菜单",
//    "url": null,
//    "icon": "fa fa-sitemap",
//    "open": true,
//    "checked": false,
//    "children":
    private int id;
    private int pid;
    private int seqno;
    private String name;
    private String url;
    private String icon;
    private boolean open = true;
    private boolean checked =true;
    private List<RoleMenuVO> children;


    //xiugai    11


}
