package com.qianfeng.test;

import com.qianfeng.bean.Fruits;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.Garbage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath:springmvc.xml"})
public class TestSpring {
    @Autowired
    UserService userService;

    @Test
    public void test(){
        List<Fruits> all = userService.getAll();
        for (Fruits fruits : all) {
            System.out.println(all);
        }
//        System.out.println(j);
    }
}
