package com.ruoyi.itinerary.service;

import java.util.List;
import com.ruoyi.itinerary.domain.TravelItinerary;

/**
 * 行程单Service接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface ITravelItineraryService 
{
    /**
     * 查询行程单
     * 
     * @param itineraryId 行程单主键
     * @return 行程单
     */
    public TravelItinerary selectTravelItineraryByItineraryId(Long itineraryId);

    /**
     * 查询行程单列表
     * 
     * @param travelItinerary 行程单
     * @return 行程单集合
     */
    public List<TravelItinerary> selectTravelItineraryList(TravelItinerary travelItinerary);

    /**
     * 新增行程单
     * 
     * @param travelItinerary 行程单
     * @return 结果
     */
    public int insertTravelItinerary(TravelItinerary travelItinerary);

    /**
     * 修改行程单
     * 
     * @param travelItinerary 行程单
     * @return 结果
     */
    public int updateTravelItinerary(TravelItinerary travelItinerary);

    /**
     * 批量删除行程单
     * 
     * @param itineraryIds 需要删除的行程单主键集合
     * @return 结果
     */
    public int deleteTravelItineraryByItineraryIds(Long[] itineraryIds);

    /**
     * 删除行程单信息
     * 
     * @param itineraryId 行程单主键
     * @return 结果
     */
    public int deleteTravelItineraryByItineraryId(Long itineraryId);
}
