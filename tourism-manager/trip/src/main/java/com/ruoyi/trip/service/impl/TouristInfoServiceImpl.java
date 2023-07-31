package com.ruoyi.trip.service.impl;

import com.ruoyi.trip.dto.TripDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ruoyi.trip.mapper.TouristInfoMapper;
import com.ruoyi.trip.entity.TouristInfo;
import com.ruoyi.trip.service.TouristInfoService;
@Service
public class TouristInfoServiceImpl implements TouristInfoService{

    @Resource
    private TouristInfoMapper touristInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return touristInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TouristInfo record) {
        return touristInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(TouristInfo record) {
        return touristInfoMapper.insertSelective(record);
    }

    @Override
    public TouristInfo selectByPrimaryKey(Integer id) {
        return touristInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TouristInfo record) {
        return touristInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TouristInfo record) {
        return touristInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<TouristInfo> list) {
        return touristInfoMapper.batchInsert(list);
    }

    @Override
    public List<TripDto> getList() {
        List<TripDto> list = touristInfoMapper.list();
        for (TripDto tripDto : list) {
            tripDto.setTeamMembers(touristInfoMapper.getByItieraryId(tripDto.getItineraryId()));
        }
        return list;
    }
}
