package com.qianfeng.service.impl;


import com.qianfeng.bean.ReplyInfo;
import com.qianfeng.dao.ReplyMapper;
import com.qianfeng.service.ReplyService;
import com.qianfeng.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    public List<ReplyVO> getReplyByComId(long comId) {
        return replyMapper.getReplyByComId(comId);
    }

    public boolean addReplyByReplyInfo(ReplyInfo replyInfo) {
        return replyMapper.addReplyByReplyInfo(replyInfo)>0;
    }

    public boolean deleteReplyByRepId(long repId) {
        return replyMapper.deleteReplyByRepId(repId)>0;
    }
}
