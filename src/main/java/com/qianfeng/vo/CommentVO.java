package com.qianfeng.vo;

import java.sql.Timestamp;

public class CommentVO {
    private long comId;
    private long userId;
    private String nickName;
    private String content;
    private Integer status;
    private String icon;
    private Timestamp createTime;

    public String getCreateTime() {
        return createTime.toString();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getComId() {
        return comId;
    }

    public void setComId(long comId) {
        this.comId = comId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "comId=" + comId +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", icon='" + icon + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}