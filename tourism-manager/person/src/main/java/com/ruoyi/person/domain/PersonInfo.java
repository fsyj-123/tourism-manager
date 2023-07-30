package com.ruoyi.person.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员管理对象 person_info
 * 
 * @author ycf
 * @date 2023-07-30
 */
public class PersonInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long personId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInfo;

    /** 机构类型 */
    @Excel(name = "机构类型")
    private Long menuId;

    /** 所属机构 */
    @Excel(name = "所属机构")
    private String relatedId;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private String personType;

    /** $column.columnComment */
    private String createUser;

    /** $column.columnComment */
    private Long modifyTime;

    /** $column.columnComment */
    private String modifyUser;

    /** $column.columnComment */
    private Long deleted;

    public void setPersonId(Long personId) 
    {
        this.personId = personId;
    }

    public Long getPersonId() 
    {
        return personId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContactInfo(String contactInfo) 
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() 
    {
        return contactInfo;
    }
    public void setMenuId(Long menuId) 
    {
        this.menuId = menuId;
    }

    public Long getMenuId() 
    {
        return menuId;
    }
    public void setRelatedId(String relatedId) 
    {
        this.relatedId = relatedId;
    }

    public String getRelatedId() 
    {
        return relatedId;
    }
    public void setPersonType(String personType) 
    {
        this.personType = personType;
    }

    public String getPersonType() 
    {
        return personType;
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
            .append("personId", getPersonId())
            .append("name", getName())
            .append("contactInfo", getContactInfo())
            .append("menuId", getMenuId())
            .append("relatedId", getRelatedId())
            .append("personType", getPersonType())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("modifyTime", getModifyTime())
            .append("modifyUser", getModifyUser())
            .append("deleted", getDeleted())
            .toString();
    }
}
