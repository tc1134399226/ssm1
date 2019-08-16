package com.qianfeng.dao;

import com.qianfeng.bean.MenuInfo;
import com.qianfeng.dto.MenuRoleDTO;
import com.qianfeng.vo.RoleIdMenuId;
import com.qianfeng.vo.RoleMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuInfoDao {
    public List<RoleMenuVO> listMenuInfoByroleId(Integer roleid);
    public RoleIdMenuId listRoleMenuByRoleId(MenuRoleDTO menuRoleDTO);


    public int deleteRoleMenuById(MenuRoleDTO menuRoleDTO);
    public int addRoleMenuByID(MenuRoleDTO menuRoleDTO);

    public List<MenuInfo> listAllMenuInfo();
}
