package com.qianfeng.controller;


import com.qianfeng.bean.ReplyInfo;
import com.qianfeng.bean.UserInfo;
import com.qianfeng.service.ReplyService;
import com.qianfeng.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    ReplyService replyService;
//    @Autowired
//    UserService userService;


    @RequestMapping("getReplyByComId")
    public Object getReplyByComId(@RequestBody ReplyVO replyVO){

        List<ReplyVO> replyByComId = replyService.getReplyByComId(replyVO.getComId());
        System.out.println(replyByComId);
        return replyByComId;
    }


    @RequestMapping("addReplyByReplyInfo")
    public Object addReplyByReplyInfo(@RequestBody ReplyInfo replyInfo , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
        if (user==null){
            return "login";
        }
        //保证程序健壮性
//        UserInfo userInfo = userService.checkName(user);
//        if (userInfo==null){
//            return false;
//        }
//        replyInfo.setUserId(3);
//        replyInfo.setNickName("zzg");
////        replyInfo.setUserId(user.getUserId());
////        replyInfo.setNickName(user.getNickName());
        //获得个人信息
       //添加到ReplyInfo对象中
       if (replyInfo==null){
           return  false;
       }
        return replyService.addReplyByReplyInfo(replyInfo);
    }
    @RequestMapping("deleteReplyByRepId")
    public Object deleteReplyByRepId(@RequestBody ReplyInfo replyInfo, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
        if (user==null){
            return "login";
        }
        //保证程序健壮性
//        UserInfo userInfo = userService.checkName(user);
//        if (userInfo==null){
//            return false;
//        }
        //获得个人信息
        //判断是不是本人,不是本人不可以删除
        if (user.getUserId()!=replyInfo.getUserId()){
            return false;
//            return "无法删除他人评论";
        }
        System.out.println(replyInfo.getUserId());

        long repId = replyInfo.getRepId();
        System.out.println(repId);
        if (repId<=0){
            return  false;
        }
        return replyService.deleteReplyByRepId(repId);
    }
}
