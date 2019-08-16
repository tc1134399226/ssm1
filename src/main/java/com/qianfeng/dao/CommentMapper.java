package com.qianfeng.dao;


import com.qianfeng.bean.CommentInfo;
import com.qianfeng.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    public List<CommentVO> allComment();
    public Integer addComment(CommentInfo commentInfo);
    public Integer deleteCommentByComId(long comId);

}
