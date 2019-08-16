package com.qianfeng.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MenuRoleDTO {
    int roleId;
    ArrayList<Integer> menuIds;
    int menuid;
}
