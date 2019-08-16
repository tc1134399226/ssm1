package com.qianfeng.dao;

import com.qianfeng.bean.Fruits;
import com.qianfeng.bean.MenuInfo;
import com.qianfeng.bean.User;
import com.qianfeng.dto.UserIdsDTO;
import com.qianfeng.vo.Garbage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<User> getAllUser();

    public User getUserByuserNameAndPassword(User user);

    public User getUserById(User user);

    public int saveUser(User user);

    public User getUserByuserName(User user);

    public int deleteUser(Integer userid);

    public int updateUser(User user);

    public List<User> selectData(User user);

    public int deleteCheckUser(UserIdsDTO userIdsDTO);

    public int insertUser(User user);

    public List<MenuInfo> userLoginInit(User user);

    public Garbage getgarbageType(Garbage garbage);

    public List<Fruits> getAll();
}
