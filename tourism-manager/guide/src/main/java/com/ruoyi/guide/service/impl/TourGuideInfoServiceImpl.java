package com.ruoyi.guide.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guide.mapper.TourGuideInfoMapper;
import com.ruoyi.guide.domain.TourGuideInfo;
import com.ruoyi.guide.service.ITourGuideInfoService;

/**
 * 登记注册Service业务层处理
 *
 * @author wyx
 * @date 2023-07-30
 */
@Service
public class TourGuideInfoServiceImpl implements ITourGuideInfoService
{
    @Autowired
    private TourGuideInfoMapper tourGuideInfoMapper;

    /**
     * 查询登记注册
     *
     * @param id 登记注册主键
     * @return 登记注册
     */
    @Override
    public TourGuideInfo selectTourGuideInfoById(Long id)
    {
        return tourGuideInfoMapper.selectTourGuideInfoById(id);
    }

    /**
     * 查询登记注册列表
     *
     * @param tourGuideInfo 登记注册
     * @return 登记注册
     */
    @Override
    public List<TourGuideInfo> selectTourGuideInfoList(TourGuideInfo tourGuideInfo)
    {
//        TODO: 将前端的data日期（licenseStartTime、licenseEndTime）转换为string
        return tourGuideInfoMapper.selectTourGuideInfoList(tourGuideInfo);
    }

    /**
     * 新增登记注册
     *
     * @param tourGuideInfo 登记注册
     * @return 结果
     */
    @Override
    public int insertTourGuideInfo(TourGuideInfo tourGuideInfo)
    {
//        tourGuideInfo.setCreateTime(DateUtils.getNowDate());
//        TODO: 将前端的string日期（licenseStartTime、licenseEndTime）转换为data

        return tourGuideInfoMapper.insertTourGuideInfo(tourGuideInfo);
    }

    /**
     * 修改登记注册
     *
     * @param tourGuideInfo 登记注册
     * @return 结果
     */
    @Override
    public int updateTourGuideInfo(TourGuideInfo tourGuideInfo)
    {
        return tourGuideInfoMapper.updateTourGuideInfo(tourGuideInfo);
    }

    /**
     * 批量删除登记注册
     *
     * @param ids 需要删除的登记注册主键
     * @return 结果
     */
    @Override
    public int deleteTourGuideInfoByIds(Long[] ids)
    {
        return tourGuideInfoMapper.deleteTourGuideInfoByIds(ids);
    }

    /**
     * 删除登记注册信息
     *
     * @param id 登记注册主键
     * @return 结果
     */
    @Override
    public int deleteTourGuideInfoById(Long id)
    {
        return tourGuideInfoMapper.deleteTourGuideInfoById(id);
    }

    @Override
    public TourGuideInfo selectByPhone(String userName) {
        return tourGuideInfoMapper.selectByPhone(userName);
    }
}
