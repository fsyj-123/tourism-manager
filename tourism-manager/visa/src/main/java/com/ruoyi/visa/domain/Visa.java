package com.ruoyi.visa.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 签证管理对象 visa
 * 
 * @author ruoyi
 * @date 2023-08-02
 */
public class Visa extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 签证ID */
    private Long visaId;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String tourName;

    /** 旅客姓名 */
    @Excel(name = "旅客姓名")
    private String tuoristName;

    /** 旅客电话 */
    @Excel(name = "旅客电话")
    private String touristPhone;

    /** 护照号码 */
    @Excel(name = "护照号码")
    private Long passportNum;

    /** 审核 */
    @Excel(name = "审核")
    private Long audit;

    public void setVisaId(Long visaId) 
    {
        this.visaId = visaId;
    }

    public Long getVisaId() 
    {
        return visaId;
    }
    public void setTourName(String tourName) 
    {
        this.tourName = tourName;
    }

    public String getTourName() 
    {
        return tourName;
    }
    public void setTuoristName(String tuoristName) 
    {
        this.tuoristName = tuoristName;
    }

    public String getTuoristName() 
    {
        return tuoristName;
    }
    public void setTouristPhone(String touristPhone) 
    {
        this.touristPhone = touristPhone;
    }

    public String getTouristPhone() 
    {
        return touristPhone;
    }
    public void setPassportNum(Long passportNum) 
    {
        this.passportNum = passportNum;
    }

    public Long getPassportNum() 
    {
        return passportNum;
    }
    public void setAudit(Long audit) 
    {
        this.audit = audit;
    }

    public Long getAudit() 
    {
        return audit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("visaId", getVisaId())
            .append("tourName", getTourName())
            .append("tuoristName", getTuoristName())
            .append("touristPhone", getTouristPhone())
            .append("passportNum", getPassportNum())
            .append("audit", getAudit())
            .toString();
    }
}
