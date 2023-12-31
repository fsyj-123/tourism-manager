package com.ruoyi.person.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.IdNamePair;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hotel.domain.HotelInfo;
import com.ruoyi.hotel.mapper.HotelInfoMapper;
import com.ruoyi.person.dto.InstitutionComplains;
import com.ruoyi.scenic.domain.ScenicAreaInfo;
import com.ruoyi.scenic.mapper.ScenicAreaInfoMapper;
import com.ruoyi.travel_agency.domain.TravelAgencyInfo;
import com.ruoyi.travel_agency.mapper.TravelAgencyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.person.mapper.PersonInfoMapper;
import com.ruoyi.person.domain.PersonInfo;
import com.ruoyi.person.service.IPersonInfoService;

import javax.annotation.Resource;

/**
 * 人员管理Service业务层处理
 *
 * @author ycf
 * @date 2023-07-30
 */
@Service
public class PersonInfoServiceImpl implements IPersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;


    @Resource
    private TravelAgencyInfoMapper travelAgencyInfoMapper;

    @Resource
    private HotelInfoMapper hotelInfoMapper;

    @Resource
    private ScenicAreaInfoMapper scenicAreaInfoMapper;

    /**
     * 查询人员管理
     *
     * @param personId 人员管理主键
     * @return 人员管理
     */
    @Override
    public PersonInfo selectPersonInfoByPersonId(Long personId) {
        return personInfoMapper.selectPersonInfoByPersonId(personId);
    }

    /**
     * 查询人员管理列表
     *
     * @param personInfo 人员管理
     * @return 人员管理
     */
    @Override
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo) {
        List<PersonInfo> list = personInfoMapper.selectPersonInfoList(personInfo);
        String name = "";
        for (PersonInfo info : list) {
            Long menuId = info.getMenuId();
            if (menuId == null || info.getRelatedId() == null) {
                continue;
            }
            Long id = Long.valueOf(info.getRelatedId());
            switch (menuId.intValue()) {
                case 0:
                    name = hotelInfoMapper.selectHotelInfoById(id).getName();
                    break;
                case 1:
                    name = scenicAreaInfoMapper.selectScenicAreaInfoById(id).getName();
                    break;
                default:
                    break;
            }
            info.setRelatedId(name);
        }
        return list;
    }

    /**
     * 新增人员管理
     *
     * @param personInfo 人员管理
     * @return 结果
     */
    @Override
    public int insertPersonInfo(PersonInfo personInfo) {
        return personInfoMapper.insertPersonInfo(personInfo);
    }

    /**
     * 修改人员管理
     *
     * @param personInfo 人员管理
     * @return 结果
     */
    @Override
    public int updatePersonInfo(PersonInfo personInfo) {
        return personInfoMapper.updatePersonInfo(personInfo);
    }

    /**
     * 批量删除人员管理
     *
     * @param personIds 需要删除的人员管理主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByPersonIds(Long[] personIds) {
        return personInfoMapper.deletePersonInfoByPersonIds(personIds);
    }

    /**
     * 删除人员管理信息
     *
     * @param personId 人员管理主键
     * @return 结果
     */
    @Override
    public int deletePersonInfoByPersonId(Long personId) {
        return personInfoMapper.deletePersonInfoByPersonId(personId);
    }

    @Override
    public List<IdNamePair> getInstitutions(Integer institutionType) {
        if (institutionType == null) {
            return null;
        }
        List<IdNamePair> result = null;
        switch (institutionType) {
            case 0:
                result = hotelInfoMapper.selectList();
                break;
            case 1:
                result = scenicAreaInfoMapper.selectList();
                break;
            case 2:
                result = travelAgencyInfoMapper.selectList();
            default:
                break;
        }
        return result;
    }


    @Override
    public List<InstitutionComplains> getComplains() {
        List<TravelAgencyInfo> agencyInfos = travelAgencyInfoMapper.list();
        List<HotelInfo> hotelInfoList = hotelInfoMapper.list();
        List<ScenicAreaInfo> areaInfos = scenicAreaInfoMapper.list();
// 处理 TravelAgencyInfo 列表
        List<InstitutionComplains> complainsList = new ArrayList<>();

        for (TravelAgencyInfo agencyInfo : agencyInfos) {
            InstitutionComplains complain = new InstitutionComplains();
            complain.setName(agencyInfo.getName());
            complain.setScore(String.valueOf(agencyInfo.getScore()));
            complain.setType("旅行社");
            complainsList.add(complain);
        }

        // 处理 HotelInfo 列表
        for (HotelInfo hotelInfo : hotelInfoList) {
            InstitutionComplains complain = new InstitutionComplains();
            complain.setName(hotelInfo.getName());
            complain.setScore(String.valueOf(hotelInfo.getScore()));
            complain.setType("星级酒店");
            complainsList.add(complain);
        }

        // 处理 ScenicAreaInfo 列表
        for (ScenicAreaInfo areaInfo : areaInfos) {
            InstitutionComplains complain = new InstitutionComplains();
            complain.setName(areaInfo.getName());
            complain.setScore(String.valueOf(areaInfo.getScore()));
            complain.setType("旅游景区");
            complainsList.add(complain);
        }
        return complainsList;
    }
}
