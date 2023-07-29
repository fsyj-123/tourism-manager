package com.ruoyi.hotel.service;

import com.ruoyi.hotel.domain.HotelInfo;

import java.util.List;

/**
 * 饭店管理Service接口
 *
 * @author fsyj
 * @date 2023-07-29
 */
public interface IHotelInfoService
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
     * 批量删除饭店管理
     *
     * @param ids 需要删除的饭店管理主键集合
     * @return 结果
     */
    public int deleteHotelInfoByIds(Long[] ids);

    /**
     * 删除饭店管理信息
     *
     * @param id 饭店管理主键
     * @return 结果
     */
    public int deleteHotelInfoById(Long id);
}
