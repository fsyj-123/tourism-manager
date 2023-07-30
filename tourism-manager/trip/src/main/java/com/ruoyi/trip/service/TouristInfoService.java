package com.ruoyi.trip.service;

import java.util.List;
import com.ruoyi.trip.entity.TouristInfo;
public interface TouristInfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(TouristInfo record);

    int insertSelective(TouristInfo record);

    TouristInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TouristInfo record);

    int updateByPrimaryKey(TouristInfo record);

    int batchInsert(List<TouristInfo> list);

}
