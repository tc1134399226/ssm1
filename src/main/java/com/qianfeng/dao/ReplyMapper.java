package com.qianfeng.dao;

import com.qf.pojo.ReplyInfo;
import com.qf.vo.ReplyVO;

import java.util.List;

public interface ReplyMapper {
   public List<ReplyVO> getReplyByComId(long comId);
   public Integer addReplyByReplyInfo(ReplyInfo replyInfo);
   public Integer deleteReplyByRepId(long repId);
}
