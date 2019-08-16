package com.qianfeng.dao;

import com.qianfeng.bean.RoleInfo;
import com.qianfeng.dto.RoleUserInfo;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface RoleInfoDao {
    public List<RoleInfoVO> listRoleByUserId(Integer id);

    public int addRoleAnd(RoleUserInfo roleUserInfo);

    public int delRoleAnd(RoleUserInfo roleUserInfo);

    public List<RoleInfo> listAllRoleInfo();
}
