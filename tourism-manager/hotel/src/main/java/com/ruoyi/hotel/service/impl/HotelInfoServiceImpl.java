package com.ruoyi.hotel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hotel.domain.HotelInfo;
import com.ruoyi.hotel.mapper.HotelInfoMapper;
import com.ruoyi.hotel.service.IHotelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 饭店管理Service业务层处理
 *
 * @author fsyj
 * @date 2023-07-29
 */
@Service
public class HotelInfoServiceImpl implements IHotelInfoService
{
    @Autowired
    private HotelInfoMapper hotelInfoMapper;

    /**
     * 查询饭店管理
     *
     * @param id 饭店管理主键
     * @return 饭店管理
     */
    @Override
    public HotelInfo selectHotelInfoById(Long id)
    {
        return hotelInfoMapper.selectHotelInfoById(id);
    }

    /**
     * 查询饭店管理列表
     *
     * @param hotelInfo 饭店管理
     * @return 饭店管理
     */
    @Override
    public List<HotelInfo> selectHotelInfoList(HotelInfo hotelInfo)
    {
        return hotelInfoMapper.selectHotelInfoList(hotelInfo);
    }

    /**
     * 新增饭店管理
     *
     * @param hotelInfo 饭店管理
     * @return 结果
     */
    @Override
    public int insertHotelInfo(HotelInfo hotelInfo)
    {
        return hotelInfoMapper.insertHotelInfo(hotelInfo);
    }

    /**
     * 修改饭店管理
     *
     * @param hotelInfo 饭店管理
     * @return 结果
     */
    @Override
    public int updateHotelInfo(HotelInfo hotelInfo)
    {
        return hotelInfoMapper.updateHotelInfo(hotelInfo);
    }

    /**
     * 批量删除饭店管理
     *
     * @param ids 需要删除的饭店管理主键
     * @return 结果
     */
    @Override
    public int deleteHotelInfoByIds(Long[] ids)
    {
        return hotelInfoMapper.deleteHotelInfoByIds(ids);
    }

    /**
     * 删除饭店管理信息
     *
     * @param id 饭店管理主键
     * @return 结果
     */
    @Override
    public int deleteHotelInfoById(Long id)
    {
        return hotelInfoMapper.deleteHotelInfoById(id);
    }
}
