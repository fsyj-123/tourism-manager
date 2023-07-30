package com.ruoyi.warming.mapper;

import java.util.List;
import com.ruoyi.warming.domain.TourismWarming;

/**
 * 告警信息管理Mapper接口
 * 
 * @author llp
 * @date 2023-07-30
 */
public interface TourismWarmingMapper 
{
    /**
     * 查询告警信息管理
     * 
     * @param warmId 告警信息管理主键
     * @return 告警信息管理
     */
    public TourismWarming selectTourismWarmingByWarmId(Long warmId);

    /**
     * 查询告警信息管理列表
     * 
     * @param tourismWarming 告警信息管理
     * @return 告警信息管理集合
     */
    public List<TourismWarming> selectTourismWarmingList(TourismWarming tourismWarming);

    /**
     * 新增告警信息管理
     * 
     * @param tourismWarming 告警信息管理
     * @return 结果
     */
    public int insertTourismWarming(TourismWarming tourismWarming);

    /**
     * 修改告警信息管理
     * 
     * @param tourismWarming 告警信息管理
     * @return 结果
     */
    public int updateTourismWarming(TourismWarming tourismWarming);

    /**
     * 删除告警信息管理
     * 
     * @param warmId 告警信息管理主键
     * @return 结果
     */
    public int deleteTourismWarmingByWarmId(Long warmId);

    /**
     * 批量删除告警信息管理
     * 
     * @param warmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTourismWarmingByWarmIds(Long[] warmIds);
}
