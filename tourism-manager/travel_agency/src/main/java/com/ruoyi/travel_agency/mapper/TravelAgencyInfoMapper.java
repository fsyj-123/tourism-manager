package com.ruoyi.travel_agency.mapper;

import java.util.List;
import com.ruoyi.travel_agency.domain.TravelAgencyInfo;
import org.springframework.stereotype.Repository;

/**
 * 旅行社基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Repository
public interface TravelAgencyInfoMapper 
{
    /**
     * 查询旅行社基础信息
     * 
     * @param id 旅行社基础信息主键
     * @return 旅行社基础信息
     */
    public TravelAgencyInfo selectTravelAgencyInfoById(Long id);

    /**
     * 查询旅行社基础信息列表
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 旅行社基础信息集合
     */
    public List<TravelAgencyInfo> selectTravelAgencyInfoList(TravelAgencyInfo travelAgencyInfo);

    /**
     * 新增旅行社基础信息
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 结果
     */
    public int insertTravelAgencyInfo(TravelAgencyInfo travelAgencyInfo);

    /**
     * 修改旅行社基础信息
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 结果
     */
    public int updateTravelAgencyInfo(TravelAgencyInfo travelAgencyInfo);

    /**
     * 删除旅行社基础信息
     * 
     * @param id 旅行社基础信息主键
     * @return 结果
     */
    public int deleteTravelAgencyInfoById(Long id);

    /**
     * 批量删除旅行社基础信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTravelAgencyInfoByIds(Long[] ids);
}
