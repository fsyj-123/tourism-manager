package com.ruoyi.guide.mapper;

import java.util.List;
import com.ruoyi.guide.domain.TourGuideInfo;

/**
 * 登记注册Mapper接口
 *
 * @author wyx
 * @date 2023-07-30
 */
public interface TourGuideInfoMapper
{
    /**
     * 查询登记注册
     *
     * @param id 登记注册主键
     * @return 登记注册
     */
    public TourGuideInfo selectTourGuideInfoById(Long id);

    /**
     * 查询登记注册列表
     *
     * @param tourGuideInfo 登记注册
     * @return 登记注册集合
     */
    public List<TourGuideInfo> selectTourGuideInfoList(TourGuideInfo tourGuideInfo);

    /**
     * 新增登记注册
     *
     * @param tourGuideInfo 登记注册
     * @return 结果
     */
    public int insertTourGuideInfo(TourGuideInfo tourGuideInfo);

    /**
     * 修改登记注册
     *
     * @param tourGuideInfo 登记注册
     * @return 结果
     */
    public int updateTourGuideInfo(TourGuideInfo tourGuideInfo);

    /**
     * 删除登记注册
     *
     * @param id 登记注册主键
     * @return 结果
     */
    public int deleteTourGuideInfoById(Long id);

    /**
     * 批量删除登记注册
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTourGuideInfoByIds(Long[] ids);

    TourGuideInfo selectByPhone(String phone);
}
