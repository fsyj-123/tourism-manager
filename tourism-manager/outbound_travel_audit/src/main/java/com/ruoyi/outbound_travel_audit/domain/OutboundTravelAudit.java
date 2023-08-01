package com.ruoyi.outbound_travel_audit.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出境管理对象 outbound_travel_audit
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public class OutboundTravelAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请出境ID */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 资质信息 */
    @Excel(name = "资质信息")
    private String qualification;

    /** 诚信得分 */
    @Excel(name = "诚信得分")
    private Long score;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** $column.columnComment */
    private String createUser;

    /** $column.columnComment */
    private Date modifyTime;

    /** $column.columnComment */
    private String modifyUser;

    /** $column.columnComment */
    private Long deleted;

    /** 申请理由 */
    @Excel(name = "申请理由")
    private String reason;

    /** 审核 */
    @Excel(name = "审核")
    private Long auditStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setQualification(String qualification) 
    {
        this.qualification = qualification;
    }

    public String getQualification() 
    {
        return qualification;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
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
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setAuditStatus(Long auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Long getAuditStatus() 
    {
        return auditStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("qualification", getQualification())
            .append("score", getScore())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("modifyTime", getModifyTime())
            .append("modifyUser", getModifyUser())
            .append("deleted", getDeleted())
            .append("reason", getReason())
            .append("auditStatus", getAuditStatus())
            .toString();
    }
}
