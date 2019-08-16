package com.qianfeng.service;

import com.qianfeng.bean.MenuInfo;
import com.qianfeng.dto.MenuRoleDTO;
import com.qianfeng.vo.RoleMenuVO;

import java.util.List;

public interface MenuInfoService {
    public List<RoleMenuVO> listMenuInfoByroleId(Integer id);
    public boolean updateRoleMenu(MenuRoleDTO menuRoleDTO);

    public List<MenuInfo> listAllMenuInfo();

}
