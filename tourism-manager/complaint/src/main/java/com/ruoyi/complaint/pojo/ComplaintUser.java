package com.ruoyi.complaint.pojo;

public class ComplaintUser {
    private int complaintId;
    private String complaintContent;
    private String handlingStatus;
    private String handlingMsg;
    private Tourist_info tourist_info;

    public ComplaintUser(int complaintId, String complaintContent, String handlingStatus, String handlingMsg, Tourist_info tourist_info) {
        this.complaintId = complaintId;
        this.complaintContent = complaintContent;
        this.handlingStatus = handlingStatus;
        this.handlingMsg = handlingMsg;
        this.tourist_info = tourist_info;
    }

    public ComplaintUser() {
    }

    @Override
    public String toString() {
        return "ComplaintUser{" +
                "complaintId=" + complaintId +
                ", complaintContent='" + complaintContent + '\'' +
                ", handlingStatus='" + handlingStatus + '\'' +
                ", handlingMsg='" + handlingMsg + '\'' +
                ", tourist_info=" + tourist_info +
                '}';
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent;
    }

    public String getHandlingStatus() {
        return handlingStatus;
    }

    public void setHandlingStatus(String handlingStatus) {
        this.handlingStatus = handlingStatus;
    }

    public String getHandlingMsg() {
        return handlingMsg;
    }

    public void setHandlingMsg(String handlingMsg) {
        this.handlingMsg = handlingMsg;
    }

    public Tourist_info getTourist_info() {
        return tourist_info;
    }

    public void setTourist_info(Tourist_info tourist_info) {
        this.tourist_info = tourist_info;
    }
}
