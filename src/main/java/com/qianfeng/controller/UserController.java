package com.qianfeng.controller;


import com.qianfeng.bean.MenuInfo;
import com.qianfeng.bean.User;
import com.qianfeng.dto.UserIdsDTO;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.Garbage;
import com.qianfeng.vo.UserTest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginCheck")
    @ResponseBody
    public boolean loginCheck(@RequestBody User user, HttpSession session ){
        List<MenuInfo> menuInfoList = userService.userLoginInit(user);
        if (menuInfoList!=null){
            session.setAttribute("menuInfoList",menuInfoList);
            session.setAttribute("userinfo",user);
        }
        return userService.getUserByuserNameAndPassword(user);
    }

    @RequestMapping("/registerUser")
    @ResponseBody
    public Object saveUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @RequestMapping("/listAllUserInfo")
    @ResponseBody
    public Object listAllUserInfo(){
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestBody User user){
       return userService.deleteUser(user.getUserid());
    }


    @RequestMapping("deleteCheckUser")
    @ResponseBody
    public boolean deleteCheckUser(@RequestBody UserIdsDTO userIdsDTO){
        return userService.deleteUser(userIdsDTO);
    }

    @RequestMapping("getUserById")
    @ResponseBody
    public User getUserById(@RequestBody User user){
        User userById = userService.getUserById(user);
        return userById;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody User user){
        boolean flg = userService.updateUser(user);
        return flg;
    }

    @RequestMapping("selectData")
    @ResponseBody
    public List<User> selectData(@RequestBody User user){
        return userService.selectData(user);
    }


    @RequestMapping("insertUser")
    @ResponseBody
    public boolean insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @RequestMapping("initMenuList")
    @ResponseBody
    public Object initMenuList(@RequestBody(required = false) User userInfo,HttpSession session){
        if(session.getAttribute("menuInfoList")==null){
            if(userInfo!=null){
                return userService.userLoginInit(userInfo);
            }else {
                return null;
            }
        }else{
            return session.getAttribute("menuInfoList");
        }
    }
    @RequestMapping("fileshow")
    @ResponseBody
    public void showload(String filename,HttpServletResponse response) throws Exception{
        File file = new File("G:/img",filename);
        byte[] bs = null;
        FileInputStream is = new FileInputStream(file);
        bs = new byte[is.available()];
        int read = is.read(bs);
        response.getOutputStream().write(bs,0,read);
        is.close();
    }

    @RequestMapping("filedown")
    @ResponseBody
    public ResponseEntity download(String filename) throws Exception{
        File file = new File("G:/img",filename);
        byte[] bs = null;
        FileInputStream is = new FileInputStream(file);
        bs = new byte[is.available()];
        is.read(bs);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(bs, headers, statusCode);
        return entity;
    }
    //验证 正则表达式
    @ResponseBody
    @RequestMapping(value="doRegister",method = RequestMethod.POST)
    public String doRegister(@Valid @RequestBody UserTest user, BindingResult result, ModelMap map){
        // 如果入参有问题，返回注册页面
        System.out.println(user);
        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println(error.getField() + "*" + error.getDefaultMessage());
                map.put("ERR_" + error.getField(), error.getDefaultMessage());
            }
            return "register_error";
        }
        // 这里省略注册代码...
        return "register_success";
    }

    @RequestMapping("getgarbageType")
    @ResponseBody
    public Garbage getgarbageType(@RequestBody Garbage garbage){
        Garbage garbage1 = userService.getgarbageType(garbage);
        return garbage1;
    }
}
