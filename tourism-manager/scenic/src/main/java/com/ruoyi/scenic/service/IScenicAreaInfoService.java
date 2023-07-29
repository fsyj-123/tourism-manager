package com.ruoyi.scenic.service;

import java.util.List;
import com.ruoyi.scenic.domain.ScenicAreaInfo;

/**
 * 景区管理Service接口
 * 
 * @author ruoyi
 * @date 2023-07-29
 */
public interface IScenicAreaInfoService 
{
    /**
     * 查询景区管理
     * 
     * @param id 景区管理主键
     * @return 景区管理
     */
    public ScenicAreaInfo selectScenicAreaInfoById(Long id);

    /**
     * 查询景区管理列表
     * 
     * @param scenicAreaInfo 景区管理
     * @return 景区管理集合
     */
    public List<ScenicAreaInfo> selectScenicAreaInfoList(ScenicAreaInfo scenicAreaInfo);

    /**
     * 新增景区管理
     * 
     * @param scenicAreaInfo 景区管理
     * @return 结果
     */
    public int insertScenicAreaInfo(ScenicAreaInfo scenicAreaInfo);

    /**
     * 修改景区管理
     * 
     * @param scenicAreaInfo 景区管理
     * @return 结果
     */
    public int updateScenicAreaInfo(ScenicAreaInfo scenicAreaInfo);

    /**
     * 批量删除景区管理
     * 
     * @param ids 需要删除的景区管理主键集合
     * @return 结果
     */
    public int deleteScenicAreaInfoByIds(Long[] ids);

    /**
     * 删除景区管理信息
     * 
     * @param id 景区管理主键
     * @return 结果
     */
    public int deleteScenicAreaInfoById(Long id);
}
