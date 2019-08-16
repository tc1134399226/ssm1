package com.qianfeng.service.impl;

import com.qianfeng.bean.RoleInfo;
import com.qianfeng.dao.RoleInfoDao;
import com.qianfeng.dto.RoleUserInfo;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoDao roleInfoDao;

    public List<RoleInfoVO> listRoleByUserId(Integer id) {
         return roleInfoDao.listRoleByUserId(id);
    }

    @Transactional
    public boolean addRoleAnd(RoleUserInfo roleUserInfo){
        int i = roleInfoDao.addRoleAnd(roleUserInfo);
        return i > 0;
    }

    public boolean delRoleAnd(RoleUserInfo roleUserInfo){
        int i = roleInfoDao.delRoleAnd(roleUserInfo);
        return i > 0;
    }

    public List<RoleInfo> listAllRoleInfo(){
        return roleInfoDao.listAllRoleInfo();
    }
}
