package com.ruoyi.guide.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登记注册对象 tour_guide_info
 * 
 * @author wyx
 * @date 2023-07-30
 */
public class TourGuideInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 导游ID */
    private Long id;

    /** 导游姓名 */
    @Excel(name = "导游姓名")
    private String name;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identityId;

    /** 旅行社ID */
    @Excel(name = "旅行社ID")
    private Long agencyId;

    /** 导游资质 */
    @Excel(name = "导游资质")
    private String qualify;

    /** 导游证号 */
    @Excel(name = "导游证号")
    private String licenseNumber;

    /** 导游证截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "导游证截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date licenseEndTime;

    /** 导游证开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "导游证开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date licenseStartTime;

    /** $column.columnComment */
    private String createUser;

    /** $column.columnComment */
    private Date modifyTime;

    /** $column.columnComment */
    private String modifyUser;

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
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setIdentityId(String identityId) 
    {
        this.identityId = identityId;
    }

    public String getIdentityId() 
    {
        return identityId;
    }
    public void setAgencyId(Long agencyId) 
    {
        this.agencyId = agencyId;
    }

    public Long getAgencyId() 
    {
        return agencyId;
    }
    public void setQualify(String qualify) 
    {
        this.qualify = qualify;
    }

    public String getQualify() 
    {
        return qualify;
    }
    public void setLicenseNumber(String licenseNumber) 
    {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() 
    {
        return licenseNumber;
    }
    public void setLicenseEndTime(Date licenseEndTime) 
    {
        this.licenseEndTime = licenseEndTime;
    }

    public Date getLicenseEndTime() 
    {
        return licenseEndTime;
    }
    public void setLicenseStartTime(Date licenseStartTime) 
    {
        this.licenseStartTime = licenseStartTime;
    }

    public Date getLicenseStartTime() 
    {
        return licenseStartTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("identityId", getIdentityId())
            .append("agencyId", getAgencyId())
            .append("qualify", getQualify())
            .append("licenseNumber", getLicenseNumber())
            .append("licenseEndTime", getLicenseEndTime())
            .append("licenseStartTime", getLicenseStartTime())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("modifyTime", getModifyTime())
            .append("modifyUser", getModifyUser())
            .toString();
    }
}
