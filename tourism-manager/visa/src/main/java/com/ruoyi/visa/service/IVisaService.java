package com.ruoyi.visa.service;

import java.util.List;
import com.ruoyi.visa.domain.Visa;

/**
 * 签证管理Service接口
 * 
 * @author ruoyi
 * @date 2023-08-02
 */
public interface IVisaService 
{
    /**
     * 查询签证管理
     * 
     * @param visaId 签证管理主键
     * @return 签证管理
     */
    public Visa selectVisaByVisaId(Long visaId);

    /**
     * 查询签证管理列表
     * 
     * @param visa 签证管理
     * @return 签证管理集合
     */
    public List<Visa> selectVisaList(Visa visa);

    /**
     * 新增签证管理
     * 
     * @param visa 签证管理
     * @return 结果
     */
    public int insertVisa(Visa visa);

    /**
     * 修改签证管理
     * 
     * @param visa 签证管理
     * @return 结果
     */
    public int updateVisa(Visa visa);

    /**
     * 批量删除签证管理
     * 
     * @param visaIds 需要删除的签证管理主键集合
     * @return 结果
     */
    public int deleteVisaByVisaIds(Long[] visaIds);

    /**
     * 删除签证管理信息
     * 
     * @param visaId 签证管理主键
     * @return 结果
     */
    public int deleteVisaByVisaId(Long visaId);
}
