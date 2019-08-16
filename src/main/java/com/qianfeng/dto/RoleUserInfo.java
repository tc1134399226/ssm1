package com.qianfeng.dto;

public class RoleUserInfo {
    private Integer userid;
    private Integer roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "RoleUserInfo{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}
