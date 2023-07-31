package com.ruoyi.complaint.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游客投诉管理对象 complaint_records
 * 
 * @author ruoyi
 * @date 2023-07-31
 */
public class ComplaintRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 投诉ID，主键自增 */
    private Long complaintId;

    /** 投诉内容 */
    @Excel(name = "投诉内容")
    private String complaintContent;

    /** 投诉主体是否处理该投诉 */
    @Excel(name = "投诉主体是否处理该投诉")
    private String handlingStatus;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String handlingMsg;

    /** 用于表示投诉关联的企业或个人 */
    @Excel(name = "用于表示投诉关联的企业或个人")
    private Long entityId;

    /**  */
    private String createUser;

    /**  */
    private Long modifyTime;

    /**  */
    private String modifyUser;

    /**  */
    private Long deleted;

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
    public void setEntityId(Long entityId) 
    {
        this.entityId = entityId;
    }

    public Long getEntityId() 
    {
        return entityId;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setModifyTime(Long modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Long getModifyTime() 
    {
        return modifyTime;
    }
    public void setModifyUser(String modifyUser) 
    {
        this.modifyUser = modifyUser;
    }

    public String getModifyUser() 
    {
        return modifyUser;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("complaintId", getComplaintId())
            .append("complaintContent", getComplaintContent())
            .append("handlingStatus", getHandlingStatus())
            .append("handlingMsg", getHandlingMsg())
            .append("entityId", getEntityId())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("modifyTime", getModifyTime())
            .append("modifyUser", getModifyUser())
            .append("deleted", getDeleted())
            .toString();
    }
}
