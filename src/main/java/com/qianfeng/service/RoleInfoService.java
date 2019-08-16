package com.qianfeng.service;

import com.qianfeng.bean.RoleInfo;
import com.qianfeng.dto.RoleUserInfo;
import com.qianfeng.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoService {
    public List<RoleInfoVO> listRoleByUserId(Integer id);

    public boolean addRoleAnd(RoleUserInfo roleUserInfo);

    public boolean delRoleAnd(RoleUserInfo roleUserInfo);

    public List<RoleInfo> listAllRoleInfo();
}
