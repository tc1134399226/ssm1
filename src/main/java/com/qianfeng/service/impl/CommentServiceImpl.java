package com.qianfeng.service.impl;


import com.qianfeng.bean.CommentInfo;
import com.qianfeng.dao.CommentMapper;
import com.qianfeng.service.CommentService;
import com.qianfeng.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    public List<CommentVO> allComment() {
        List<CommentVO> commentInfos = commentMapper.allComment();
        for (CommentVO c :
                commentInfos ) {
//            try {
//                c.setCreateTime((Timestamp) simpleDateFormat.parse(c.getCreateTime().toString()));
//                System.out.println(c.getCreateTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            System.out.println(c.getCreateTime());
        }


        return commentInfos;
    }

    public boolean addComment(CommentInfo commentInfo) {
       return commentMapper.addComment(commentInfo)>0;

    }

    public boolean deleteCommentByComId(long comId) {
        return commentMapper.deleteCommentByComId(comId)>0;
    }
}
