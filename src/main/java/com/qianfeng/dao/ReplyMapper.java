package com.qianfeng.dao;

import com.qianfeng.bean.ReplyInfo;
import com.qianfeng.vo.ReplyVO;

import java.util.List;

public interface ReplyMapper {
   public List<ReplyVO> getReplyByComId(long comId);
   public Integer addReplyByReplyInfo(ReplyInfo replyInfo);
   public Integer deleteReplyByRepId(long repId);
}
