package com.ruoyi.trip.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ruoyi.trip.entity.TravelItinerary;
import com.ruoyi.trip.mapper.TravelItineraryMapper;
import com.ruoyi.trip.service.TravelItineraryService;
@Service
public class TravelItineraryServiceImpl implements TravelItineraryService{

    @Resource
    private TravelItineraryMapper travelItineraryMapper;

    @Override
    public int deleteByPrimaryKey(Integer itineraryId) {
        return travelItineraryMapper.deleteByPrimaryKey(itineraryId);
    }

    @Override
    public int insert(TravelItinerary record) {
        return travelItineraryMapper.insert(record);
    }

    @Override
    public int insertSelective(TravelItinerary record) {
        return travelItineraryMapper.insertSelective(record);
    }

    @Override
    public TravelItinerary selectByPrimaryKey(Integer itineraryId) {
        return travelItineraryMapper.selectByPrimaryKey(itineraryId);
    }

    @Override
    public int updateByPrimaryKeySelective(TravelItinerary record) {
        return travelItineraryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TravelItinerary record) {
        return travelItineraryMapper.updateByPrimaryKey(record);
    }

}
