package com.qianfeng.service.impl;

import com.qianfeng.bean.MenuInfo;
import com.qianfeng.dao.MenuInfoDao;
import com.qianfeng.dto.MenuRoleDTO;
import com.qianfeng.service.MenuInfoService;
import com.qianfeng.vo.RoleIdMenuId;
import com.qianfeng.vo.RoleMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<RoleMenuVO> listMenuInfoByroleId(Integer id){
        List<RoleMenuVO> roleMenuVOS = menuInfoDao.listMenuInfoByroleId(id);
        for (RoleMenuVO roleMenuVO : roleMenuVOS) {
            List<RoleMenuVO> children = roleMenuVO.getChildren();
            Iterator it = children.iterator();
            for (RoleMenuVO vo : children) {
                List<RoleMenuVO> childrenVO = vo.getChildren();
                Iterator<RoleMenuVO> iterator = childrenVO.iterator();
                while (iterator.hasNext()){
                    RoleMenuVO next = iterator.next();
                    if (next.getId()==0){
                        iterator.remove();
                    }
                }
            }
        }
        return roleMenuVOS;
    }

    public boolean updateRoleMenu(MenuRoleDTO menuRoleDTO){
        RoleIdMenuId menuRoleDTOS = menuInfoDao.listRoleMenuByRoleId(menuRoleDTO);
        ArrayList<Integer> deleteMenuIds = new ArrayList<>();
        for (MenuInfo menuInfo : menuRoleDTOS.getMenuInfos()) {
            deleteMenuIds.add(menuInfo.getMid());
        }
//        for (Integer integer : menuid) {
////            if (!menuid2.contains(integer)){
////                MenuRoleDTO menuRoleDTO1 = new MenuRoleDTO();
////                menuRoleDTO1.setMenuid(integer);
////                menuRoleDTO1.setRoleId(menuRoleDTO.getRoleId());
////                //删除
////                int i = menuInfoDao.deleteRoleMenuById(menuRoleDTO1);
////                if (i==0){
////                    return false;
////                }
////            }
////        }
////        for (Integer integer : menuid2) {
////            if (!menuid.contains(integer)){
////                MenuRoleDTO menuRoleDTO1 = new MenuRoleDTO();
////                menuRoleDTO1.setMenuid(integer);
////                menuRoleDTO1.setRoleId(menuRoleDTO.getRoleId());
////                //添加
////                if (integer==1||integer==5){
////                }else {
////                    int i = menuInfoDao.addRoleMenuByID(menuRoleDTO1);
////                    if (i==0){
////                        return false;
////                    }
////                }
////
////            }
////        }
        List<Integer> tempList = new ArrayList<>();
        List<Integer> addMenuIds = menuRoleDTO.getMenuIds();
        tempList.addAll(addMenuIds);
        addMenuIds.removeAll(deleteMenuIds);
        deleteMenuIds.removeAll(tempList);

        if (addMenuIds.size() != 0) {
            for (Integer addMenuId : addMenuIds) {
                menuRoleDTO.setMenuid(addMenuId);
                int i = menuInfoDao.addRoleMenuByID(menuRoleDTO);
                if (i==0){
                    return false;
                }
            }
        }
        if (deleteMenuIds.size() != 0) {
            for (Integer deleteMenuId : deleteMenuIds) {
                menuRoleDTO.setMenuid(deleteMenuId);
                int i = menuInfoDao.deleteRoleMenuById(menuRoleDTO);
                if (i==0){
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public List<MenuInfo> listAllMenuInfo() {
        return menuInfoDao.listAllMenuInfo();
    }
}
