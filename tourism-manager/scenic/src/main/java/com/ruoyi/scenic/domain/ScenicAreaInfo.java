package com.ruoyi.scenic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区管理对象 scenic_area_info
 * 
 * @author ruoyi
 * @date 2023-07-29
 */
public class ScenicAreaInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 景区ID，主键自增 */
    private Long id;

    /** 景区名称 */
    @Excel(name = "景区名称")
    private String name;

    /** 景区最大容客量 */
    @Excel(name = "景区最大容客量")
    private Long maxCapacity;

    /** 景区停车位数量 */
    @Excel(name = "景区停车位数量")
    private Long parkingLots;

    /** 景区位置 */
    @Excel(name = "景区位置")
    private String scenicSite;

    /** 景区状态  0-开放  -1关闭 */
    @Excel(name = "景区状态  0-开放  -1关闭")
    private Long status;

    /** 诚信管理得分 */
    @Excel(name = "诚信管理得分")
    private Long score;

    /**  */
    @Excel(name = "")
    private String createUser;

    /**  */
    @Excel(name = "")
    private Long modifyTime;

    /**  */
    @Excel(name = "")
    private String modifyUser;

    /** 0-删除  */
    @Excel(name = "0-删除 ")
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
    public void setScenicSite(String scenicSite) 
    {
        this.scenicSite = scenicSite;
    }

    public String getScenicSite() 
    {
        return scenicSite;
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
            .append("scenicSite", getScenicSite())
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
