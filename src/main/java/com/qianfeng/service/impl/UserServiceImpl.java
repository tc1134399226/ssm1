package com.qianfeng.service.impl;

import com.qianfeng.bean.Fruits;
import com.qianfeng.bean.MenuInfo;
import com.qianfeng.bean.User;
import com.qianfeng.dao.UserDao;
import com.qianfeng.dto.UserIdsDTO;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.Garbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean getUserByuserNameAndPassword(User user) {
        User user1 = userDao.getUserByuserNameAndPassword(user);
        if (user1!=null){
            return true;
        }else {
            return false;
        }
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public boolean deleteUser(Integer userid) {
        int i = userDao.deleteUser(userid);
        return i > 0;
    }

    public boolean registerUser(User user) {
        if (user.getUsername()==null||"".equals(user.getUsername())||user.getAccount()==null
        ||"".equals(user.getAccount())){
            return false;
        }
        User user1 = userDao.getUserByuserName(user);
        if (user1!=null){
            return false;
        }else {
            int i = userDao.saveUser(user);
            return i > 0;
        }
    }

    public User getUserById(User user) {
        return userDao.getUserById(user);
    }

    public boolean updateUser(User user) {
        int i = userDao.updateUser(user);
        return i > 0;
    }

    public List<User> selectData(User user) {
        return  userDao.selectData(user);
    }

//    @Override
//    public List<User> selectData(User user) {
//        return userDao.selectData(user);
//    }

    public boolean deleteUser(UserIdsDTO userIdsDTO){
        for (Integer userid : userIdsDTO.getUserids()) {
            System.out.println(userid);
        }
        int i = userDao.deleteCheckUser(userIdsDTO);
        return i > 0;
    }
    public boolean insertUser(User user){
        int i = userDao.insertUser(user);
        return i > 0;
    }


    public List<MenuInfo> userLoginInit(User user) {
        return userDao.userLoginInit(user);
    }

    public Garbage getgarbageType(Garbage garbage){

        return userDao.getgarbageType(garbage);
    }

    public List<Fruits> getAll(){
        return userDao.getAll();
    }
}
