package com.ruoyi.travel_agency.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel_agency.mapper.TravelAgencyInfoMapper;
import com.ruoyi.travel_agency.domain.TravelAgencyInfo;
import com.ruoyi.travel_agency.service.ITravelAgencyInfoService;

/**
 * 旅行社基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class TravelAgencyInfoServiceImpl implements ITravelAgencyInfoService 
{
    @Autowired
    private TravelAgencyInfoMapper travelAgencyInfoMapper;

    /**
     * 查询旅行社基础信息
     * 
     * @param id 旅行社基础信息主键
     * @return 旅行社基础信息
     */
    @Override
    public TravelAgencyInfo selectTravelAgencyInfoById(Long id)
    {
        return travelAgencyInfoMapper.selectTravelAgencyInfoById(id);
    }

    /**
     * 查询旅行社基础信息列表
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 旅行社基础信息
     */
    @Override
    public List<TravelAgencyInfo> selectTravelAgencyInfoList(TravelAgencyInfo travelAgencyInfo)
    {
        return travelAgencyInfoMapper.selectTravelAgencyInfoList(travelAgencyInfo);
    }

    /**
     * 新增旅行社基础信息
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 结果
     */
    @Override
    public int insertTravelAgencyInfo(TravelAgencyInfo travelAgencyInfo)
    {
        travelAgencyInfo.setCreateTime(DateUtils.getNowDate());
        return travelAgencyInfoMapper.insertTravelAgencyInfo(travelAgencyInfo);
    }

    /**
     * 修改旅行社基础信息
     * 
     * @param travelAgencyInfo 旅行社基础信息
     * @return 结果
     */
    @Override
    public int updateTravelAgencyInfo(TravelAgencyInfo travelAgencyInfo)
    {
        return travelAgencyInfoMapper.updateTravelAgencyInfo(travelAgencyInfo);
    }

    /**
     * 批量删除旅行社基础信息
     * 
     * @param ids 需要删除的旅行社基础信息主键
     * @return 结果
     */
    @Override
    public int deleteTravelAgencyInfoByIds(Long[] ids)
    {
        return travelAgencyInfoMapper.deleteTravelAgencyInfoByIds(ids);
    }

    /**
     * 删除旅行社基础信息信息
     * 
     * @param id 旅行社基础信息主键
     * @return 结果
     */
    @Override
    public int deleteTravelAgencyInfoById(Long id)
    {
        return travelAgencyInfoMapper.deleteTravelAgencyInfoById(id);
    }
}
