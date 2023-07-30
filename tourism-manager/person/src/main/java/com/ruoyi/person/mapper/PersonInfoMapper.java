package com.ruoyi.person.mapper;

import java.util.List;
import com.ruoyi.person.domain.PersonInfo;

/**
 * 人员管理Mapper接口
 * 
 * @author ycf
 * @date 2023-07-30
 */
public interface PersonInfoMapper 
{
    /**
     * 查询人员管理
     * 
     * @param personId 人员管理主键
     * @return 人员管理
     */
    public PersonInfo selectPersonInfoByPersonId(Long personId);

    /**
     * 查询人员管理列表
     * 
     * @param personInfo 人员管理
     * @return 人员管理集合
     */
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo);

    /**
     * 新增人员管理
     * 
     * @param personInfo 人员管理
     * @return 结果
     */
    public int insertPersonInfo(PersonInfo personInfo);

    /**
     * 修改人员管理
     * 
     * @param personInfo 人员管理
     * @return 结果
     */
    public int updatePersonInfo(PersonInfo personInfo);

    /**
     * 删除人员管理
     * 
     * @param personId 人员管理主键
     * @return 结果
     */
    public int deletePersonInfoByPersonId(Long personId);

    /**
     * 批量删除人员管理
     * 
     * @param personIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonInfoByPersonIds(Long[] personIds);
}
