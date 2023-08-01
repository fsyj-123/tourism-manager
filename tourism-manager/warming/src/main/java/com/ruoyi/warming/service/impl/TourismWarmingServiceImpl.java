package com.ruoyi.warming.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warming.mapper.TourismWarmingMapper;
import com.ruoyi.warming.domain.TourismWarming;
import com.ruoyi.warming.service.ITourismWarmingService;

/**
 * 告警信息管理Service业务层处理
 * 
 * @author llp
 * @date 2023-07-30
 */
@Service
public class TourismWarmingServiceImpl implements ITourismWarmingService 
{
    @Autowired
    private TourismWarmingMapper tourismWarmingMapper;

    /**
     * 查询告警信息管理
     * 
     * @param warmId 告警信息管理主键
     * @return 告警信息管理
     */
    @Override
    public TourismWarming selectTourismWarmingByWarmId(Long warmId)
    {
        return tourismWarmingMapper.selectTourismWarmingByWarmId(warmId);
    }

    /**
     * 查询告警信息管理列表
     * 
     * @param tourismWarming 告警信息管理
     * @return 告警信息管理
     */
    @Override
    public List<TourismWarming> selectTourismWarmingList(TourismWarming tourismWarming)
    {
        return tourismWarmingMapper.selectTourismWarmingList(tourismWarming);
    }

    /**
     * 新增告警信息管理
     * 
     * @param tourismWarming 告警信息管理
     * @return 结果
     */
    @Override
    public int insertTourismWarming(TourismWarming tourismWarming)
    {
        tourismWarming.setCreateTime(DateUtils.getNowDate());
        return tourismWarmingMapper.insertTourismWarming(tourismWarming);
    }

    /**
     * 修改告警信息管理
     * 
     * @param tourismWarming 告警信息管理
     * @return 结果
     */
    @Override
    public int updateTourismWarming(TourismWarming tourismWarming)
    {
        tourismWarming.setUpdateTime(DateUtils.getNowDate());
        return tourismWarmingMapper.updateTourismWarming(tourismWarming);
    }

    /**
     * 批量删除告警信息管理
     * 
     * @param warmIds 需要删除的告警信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTourismWarmingByWarmIds(Long[] warmIds)
    {
        return tourismWarmingMapper.deleteTourismWarmingByWarmIds(warmIds);
    }

    /**
     * 删除告警信息管理信息
     * 
     * @param warmId 告警信息管理主键
     * @return 结果
     */
    @Override
    public int deleteTourismWarmingByWarmId(Long warmId)
    {
        return tourismWarmingMapper.deleteTourismWarmingByWarmId(warmId);
    }
}
