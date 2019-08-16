package com.qianfeng.vo;

import com.qianfeng.bean.MenuInfo;
import lombok.Data;

import java.util.ArrayList;


@Data
public class RoleIdMenuId {
    int roleid;
    ArrayList<MenuInfo> menuInfos;
}
