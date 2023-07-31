package com.ruoyi.itinerary.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itinerary.mapper.TravelItineraryMapper;
import com.ruoyi.itinerary.domain.TravelItinerary;
import com.ruoyi.itinerary.service.ITravelItineraryService;

/**
 * 行程单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class TravelItineraryServiceImpl implements ITravelItineraryService 
{
    @Autowired
    private TravelItineraryMapper travelItineraryMapper;

    /**
     * 查询行程单
     * 
     * @param itineraryId 行程单主键
     * @return 行程单
     */
    @Override
    public TravelItinerary selectTravelItineraryByItineraryId(Long itineraryId)
    {
        return travelItineraryMapper.selectTravelItineraryByItineraryId(itineraryId);
    }

    /**
     * 查询行程单列表
     * 
     * @param travelItinerary 行程单
     * @return 行程单
     */
    @Override
    public List<TravelItinerary> selectTravelItineraryList(TravelItinerary travelItinerary)
    {
        return travelItineraryMapper.selectTravelItineraryList(travelItinerary);
    }

    /**
     * 新增行程单
     * 
     * @param travelItinerary 行程单
     * @return 结果
     */
    @Override
    public int insertTravelItinerary(TravelItinerary travelItinerary)
    {
        return travelItineraryMapper.insertTravelItinerary(travelItinerary);
    }

    /**
     * 修改行程单
     * 
     * @param travelItinerary 行程单
     * @return 结果
     */
    @Override
    public int updateTravelItinerary(TravelItinerary travelItinerary)
    {
        return travelItineraryMapper.updateTravelItinerary(travelItinerary);
    }

    /**
     * 批量删除行程单
     * 
     * @param itineraryIds 需要删除的行程单主键
     * @return 结果
     */
    @Override
    public int deleteTravelItineraryByItineraryIds(Long[] itineraryIds)
    {
        return travelItineraryMapper.deleteTravelItineraryByItineraryIds(itineraryIds);
    }

    /**
     * 删除行程单信息
     * 
     * @param itineraryId 行程单主键
     * @return 结果
     */
    @Override
    public int deleteTravelItineraryByItineraryId(Long itineraryId)
    {
        return travelItineraryMapper.deleteTravelItineraryByItineraryId(itineraryId);
    }
}
