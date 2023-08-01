package com.ruoyi.complaint.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游客投诉管理对象 complaint_records
 * 
 * @author fs
 * @date 2023-08-01
 */
public class ComplaintRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long complaintId;

    /** 投诉内容 */
    @Excel(name = "投诉内容")
    private String complaintContent;

    /** 是否处理 */
    @Excel(name = "是否处理")
    private String handlingStatus;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String handlingMsg;

    /** 主体类型 */
    @Excel(name = "主体类型")
    private Long entityType;

    /** 投诉主体 */
    @Excel(name = "投诉主体")
    private Long entityId;

    /** 投诉人姓名 */
    @Excel(name = "投诉人姓名")
    private String username;

    /** 投诉人电话 */
    @Excel(name = "投诉人电话")
    private String phone;

    public void setComplaintId(Long complaintId) 
    {
        this.complaintId = complaintId;
    }

    public Long getComplaintId() 
    {
        return complaintId;
    }
    public void setComplaintContent(String complaintContent) 
    {
        this.complaintContent = complaintContent;
    }

    public String getComplaintContent() 
    {
        return complaintContent;
    }
    public void setHandlingStatus(String handlingStatus) 
    {
        this.handlingStatus = handlingStatus;
    }

    public String getHandlingStatus() 
    {
        return handlingStatus;
    }
    public void setHandlingMsg(String handlingMsg) 
    {
        this.handlingMsg = handlingMsg;
    }

    public String getHandlingMsg() 
    {
        return handlingMsg;
    }
    public void setEntityType(Long entityType) 
    {
        this.entityType = entityType;
    }

    public Long getEntityType() 
    {
        return entityType;
    }
    public void setEntityId(Long entityId) 
    {
        this.entityId = entityId;
    }

    public Long getEntityId() 
    {
        return entityId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("complaintId", getComplaintId())
            .append("complaintContent", getComplaintContent())
            .append("handlingStatus", getHandlingStatus())
            .append("handlingMsg", getHandlingMsg())
            .append("entityType", getEntityType())
            .append("entityId", getEntityId())
            .append("username", getUsername())
            .append("phone", getPhone())
            .toString();
    }
}
