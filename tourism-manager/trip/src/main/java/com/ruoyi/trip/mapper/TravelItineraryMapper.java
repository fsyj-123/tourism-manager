package com.ruoyi.trip.mapper;

import com.ruoyi.trip.entity.TravelItinerary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelItineraryMapper {
    /**
     * delete by primary key
     * @param itineraryId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer itineraryId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TravelItinerary record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TravelItinerary record);

    /**
     * select by primary key
     * @param itineraryId primary key
     * @return object by primary key
     */
    TravelItinerary selectByPrimaryKey(Integer itineraryId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TravelItinerary record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TravelItinerary record);
}