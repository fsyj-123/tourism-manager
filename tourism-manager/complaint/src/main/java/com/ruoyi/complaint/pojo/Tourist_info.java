package com.ruoyi.complaint.pojo;

public class Tourist_info {
    private int userId;
    private String userName;
    private String tele;

    public Tourist_info(int userId, String userName, String tele) {
        this.userId = userId;
        this.userName = userName;
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "Tourist_info{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }

    public Tourist_info() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}
