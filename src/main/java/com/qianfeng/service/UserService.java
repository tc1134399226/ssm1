package com.qianfeng.service;

import com.qianfeng.bean.Fruits;
import com.qianfeng.bean.MenuInfo;
import com.qianfeng.bean.User;
import com.qianfeng.dto.UserIdsDTO;
import com.qianfeng.vo.Garbage;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public boolean registerUser(User user);
    public boolean getUserByuserNameAndPassword(User user);
    public User getUserById(User user);
    public boolean deleteUser(Integer userid);
    public boolean updateUser(User user);

    public List<User> selectData(User user);

    public boolean deleteUser(UserIdsDTO userIdsDTO);
    public boolean insertUser(User user);

    public List<MenuInfo> userLoginInit(User user);

    public Garbage getgarbageType(Garbage garbage);

    public List<Fruits> getAll();
}
