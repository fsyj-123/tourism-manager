package com.ruoyi.hotel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 饭店管理对象 hotel_info
 *
 * @author fsyj
 * @date 2023-07-29
 */
public class HotelInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 饭店ID，主键自增 */
    private Long id;

    /** 饭店名称 */
    @Excel(name = "饭店名称")
    private String name;

    /** 饭店最大接待量 */
    @Excel(name = "饭店最大接待量")
    private Long maxCapacity;

    /** 饭店停车位数量 */
    @Excel(name = "饭店停车位数量")
    private Long parkingLots;

    /** 是否营业 */
    @Excel(name = "是否营业")
    private Long status;

    /** 诚信管理得分 */
    @Excel(name = "诚信管理得分")
    private Long score;

    /** 创建用户 */
    private String createUser;

    /** 修改时间 */
    private Long modifyTime;

    /** 修改用户 */
    private String modifyUser;

    /** 删除 */
    private Long deleted;

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
    public void setMaxCapacity(Long maxCapacity)
    {
        this.maxCapacity = maxCapacity;
    }

    public Long getMaxCapacity()
    {
        return maxCapacity;
    }
    public void setParkingLots(Long parkingLots)
    {
        this.parkingLots = parkingLots;
    }

    public Long getParkingLots()
    {
        return parkingLots;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setScore(Long score)
    {
        this.score = score;
    }

    public Long getScore()
    {
        return score;
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
            .append("id", getId())
            .append("name", getName())
            .append("maxCapacity", getMaxCapacity())
            .append("parkingLots", getParkingLots())
            .append("status", getStatus())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("modifyTime", getModifyTime())
            .append("modifyUser", getModifyUser())
            .append("deleted", getDeleted())
            .toString();
    }
}
