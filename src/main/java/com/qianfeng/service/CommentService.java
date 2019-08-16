package com.qianfeng.service;

import com.qianfeng.bean.CommentInfo;
import com.qianfeng.vo.CommentVO;

import java.util.List;

public interface CommentService {
    public List<CommentVO> allComment();
    public boolean addComment(CommentInfo commentInfo);
    public boolean deleteCommentByComId(long comId);
}
