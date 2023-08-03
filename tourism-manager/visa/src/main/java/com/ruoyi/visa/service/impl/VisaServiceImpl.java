package com.ruoyi.visa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.visa.mapper.VisaMapper;
import com.ruoyi.visa.domain.Visa;
import com.ruoyi.visa.service.IVisaService;

/**
 * 签证管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-02
 */
@Service
public class VisaServiceImpl implements IVisaService 
{
    @Autowired
    private VisaMapper visaMapper;

    /**
     * 查询签证管理
     * 
     * @param visaId 签证管理主键
     * @return 签证管理
     */
    @Override
    public Visa selectVisaByVisaId(Long visaId)
    {
        return visaMapper.selectVisaByVisaId(visaId);
    }

    /**
     * 查询签证管理列表
     * 
     * @param visa 签证管理
     * @return 签证管理
     */
    @Override
    public List<Visa> selectVisaList(Visa visa)
    {
        return visaMapper.selectVisaList(visa);
    }

    /**
     * 新增签证管理
     * 
     * @param visa 签证管理
     * @return 结果
     */
    @Override
    public int insertVisa(Visa visa)
    {
        return visaMapper.insertVisa(visa);
    }

    /**
     * 修改签证管理
     * 
     * @param visa 签证管理
     * @return 结果
     */
    @Override
    public int updateVisa(Visa visa)
    {
        return visaMapper.updateVisa(visa);
    }

    /**
     * 批量删除签证管理
     * 
     * @param visaIds 需要删除的签证管理主键
     * @return 结果
     */
    @Override
    public int deleteVisaByVisaIds(Long[] visaIds)
    {
        return visaMapper.deleteVisaByVisaIds(visaIds);
    }

    /**
     * 删除签证管理信息
     * 
     * @param visaId 签证管理主键
     * @return 结果
     */
    @Override
    public int deleteVisaByVisaId(Long visaId)
    {
        return visaMapper.deleteVisaByVisaId(visaId);
    }
}
