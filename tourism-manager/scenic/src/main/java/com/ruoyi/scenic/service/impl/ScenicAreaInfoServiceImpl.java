package com.ruoyi.scenic.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.scenic.mapper.ScenicAreaInfoMapper;
import com.ruoyi.scenic.domain.ScenicAreaInfo;
import com.ruoyi.scenic.service.IScenicAreaInfoService;

/**
 * 景区管理Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-29
 */
@Service
public class ScenicAreaInfoServiceImpl implements IScenicAreaInfoService
{
    @Autowired
    private ScenicAreaInfoMapper scenicAreaInfoMapper;

    /**
     * 查询景区管理
     *
     * @param id 景区管理主键
     * @return 景区管理
     */
    @Override
    public ScenicAreaInfo selectScenicAreaInfoById(Long id)
    {
        return scenicAreaInfoMapper.selectScenicAreaInfoById(id);
    }

    /**
     * 查询景区管理列表
     *
     * @param scenicAreaInfo 景区管理
     * @return 景区管理
     */
    @Override
    public List<ScenicAreaInfo> selectScenicAreaInfoList(ScenicAreaInfo scenicAreaInfo)
    {
        return scenicAreaInfoMapper.selectScenicAreaInfoList(scenicAreaInfo);
    }

    /**
     * 新增景区管理
     *
     * @param scenicAreaInfo 景区管理
     * @return 结果
     */
    @Override
    public int insertScenicAreaInfo(ScenicAreaInfo scenicAreaInfo)
    {
//        scenicAreaInfo.setCreateTime(DateUtils.getNowDate());
        return scenicAreaInfoMapper.insertScenicAreaInfo(scenicAreaInfo);
    }

    /**
     * 修改景区管理
     *
     * @param scenicAreaInfo 景区管理
     * @return 结果
     */
    @Override
    public int updateScenicAreaInfo(ScenicAreaInfo scenicAreaInfo)
    {
        return scenicAreaInfoMapper.updateScenicAreaInfo(scenicAreaInfo);
    }

    /**
     * 批量删除景区管理
     *
     * @param ids 需要删除的景区管理主键
     * @return 结果
     */
    @Override
    public int deleteScenicAreaInfoByIds(Long[] ids)
    {
        return scenicAreaInfoMapper.deleteScenicAreaInfoByIds(ids);
    }

    /**
     * 删除景区管理信息
     *
     * @param id 景区管理主键
     * @return 结果
     */
    @Override
    public int deleteScenicAreaInfoById(Long id)
    {
        return scenicAreaInfoMapper.deleteScenicAreaInfoById(id);
    }
}
