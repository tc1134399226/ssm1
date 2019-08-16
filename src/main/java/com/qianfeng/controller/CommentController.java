package com.qianfeng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.bean.CommentInfo;
import com.qianfeng.bean.UserInfo;
import com.qianfeng.service.CommentService;
import com.qianfeng.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//import com.qf.pojo.UserInfo;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
//    @Autowired
//    UserService userService;


    @RequestMapping("allComment")
    public Object allComment(@RequestParam(required = true,defaultValue = "1",value = "pageNum")
                                         Integer pageNum){
        //一页有多少条数据
        int defaultPageSize=2;
        //初始化pageHelper对象
        PageHelper.startPage(pageNum,defaultPageSize);
        List<CommentVO> commentInfos = commentService.allComment();
        PageInfo<CommentVO> commentInfoPageInfo = new PageInfo<CommentVO>(commentInfos);
        return commentInfoPageInfo;
    }

    @RequestMapping("addComment")
    public Object addComment(@RequestBody CommentInfo commentInfo , HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("userInfo");
//       if (user==null){
//           return "login";
//       }
//        //保证程序健壮性
//        User userInfo = userService.checkName(user);
//        if (userInfo==null){
//            return false;
//        }
        //获得个人信息
        //添加到CommentInfo对象中
        commentInfo.setUserId(user.getUserId());
        commentInfo.setNickName(user.getNickName());
//        commentInfo.setUserId(3);
//        commentInfo.setNickName("zzg");
        System.out.println(commentInfo);
        if (commentInfo==null){
            return false;
        }
        return commentService.addComment(commentInfo);
    }
    @RequestMapping("deleteCommentByComId")
    public Object deleteCommentByComId(@RequestBody CommentInfo commentInfo,HttpSession session){
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
        if (user.getUserId()!=commentInfo.getUserId()){
            return false;
//            return "无法删除他人评论";
        }

        long comId = commentInfo.getComId();
        if (comId<0){
            return false;
        }
        System.out.println(commentInfo);

        return commentService.deleteCommentByComId(comId);
    }

}
