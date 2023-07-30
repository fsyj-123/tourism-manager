package com.ruoyi.hotel.mapper;

import com.ruoyi.common.core.domain.IdNamePair;
import com.ruoyi.hotel.domain.HotelInfo;

import java.util.List;
import java.util.Map;

/**
 * 饭店管理Mapper接口
 *
 * @author fsyj
 * @date 2023-07-29
 */
public interface HotelInfoMapper
{
    /**
     * 查询饭店管理
     *
     * @param id 饭店管理主键
     * @return 饭店管理
     */
    public HotelInfo selectHotelInfoById(Long id);

    /**
     * 查询饭店管理列表
     *
     * @param hotelInfo 饭店管理
     * @return 饭店管理集合
     */
    public List<HotelInfo> selectHotelInfoList(HotelInfo hotelInfo);

    /**
     * 新增饭店管理
     *
     * @param hotelInfo 饭店管理
     * @return 结果
     */
    public int insertHotelInfo(HotelInfo hotelInfo);

    /**
     * 修改饭店管理
     *
     * @param hotelInfo 饭店管理
     * @return 结果
     */
    public int updateHotelInfo(HotelInfo hotelInfo);

    /**
     * 删除饭店管理
     *
     * @param id 饭店管理主键
     * @return 结果
     */
    public int deleteHotelInfoById(Long id);

    /**
     * 批量删除饭店管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHotelInfoByIds(Long[] ids);


    List<IdNamePair> selectList();
}
