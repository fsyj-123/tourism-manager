package com.ruoyi.warming.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 告警信息管理对象 tourism_warming
 * 
 * @author llp
 * @date 2023-07-30
 */
public class TourismWarming extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 告警ID */
    @Excel(name = "告警ID")
    private Long warmId;

    /** 告警类型 */
    @Excel(name = "告警类型")
    private String warmType;

    /** 数量 */
    @Excel(name = "数量")
    private Long warmNum;

    /** 是否告警状态 */
    @Excel(name = "是否告警状态")
    private Long status;

    /** 是否删除标志 */
    @Excel(name = "是否删除标志")
    private Long deleted;

    public void setWarmId(Long warmId) 
    {
        this.warmId = warmId;
    }

    public Long getWarmId() 
    {
        return warmId;
    }
    public void setWarmType(String warmType) 
    {
        this.warmType = warmType;
    }

    public String getWarmType() 
    {
        return warmType;
    }
    public void setWarmNum(Long warmNum) 
    {
        this.warmNum = warmNum;
    }

    public Long getWarmNum() 
    {
        return warmNum;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
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
            .append("warmId", getWarmId())
            .append("warmType", getWarmType())
            .append("warmNum", getWarmNum())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deleted", getDeleted())
            .toString();
    }
}
