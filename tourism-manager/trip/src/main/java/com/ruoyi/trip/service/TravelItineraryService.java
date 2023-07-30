package com.ruoyi.trip.service;

import com.ruoyi.trip.entity.TravelItinerary;
public interface TravelItineraryService{


    int deleteByPrimaryKey(Integer itineraryId);

    int insert(TravelItinerary record);

    int insertSelective(TravelItinerary record);

    TravelItinerary selectByPrimaryKey(Integer itineraryId);

    int updateByPrimaryKeySelective(TravelItinerary record);

    int updateByPrimaryKey(TravelItinerary record);

}
