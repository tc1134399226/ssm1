package com.qianfeng.service;



import com.qianfeng.bean.ReplyInfo;
import com.qianfeng.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
    public List<ReplyVO> getReplyByComId(long comId);
    public boolean addReplyByReplyInfo(ReplyInfo replyInfo);
    public boolean deleteReplyByRepId(long repId);
}
