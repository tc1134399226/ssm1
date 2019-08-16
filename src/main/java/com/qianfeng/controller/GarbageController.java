package com.qianfeng.controller;

import com.qianfeng.service.UserService;
import com.qianfeng.vo.Garbage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("garbage")
@Controller
public class GarbageController {

    @Autowired
    private UserService userService;

    @RequestMapping("getgarbageType")
    @ResponseBody
    public Garbage getgarbageType(@RequestBody Garbage garbage){
        return userService.getgarbageType(garbage);
    }
}
