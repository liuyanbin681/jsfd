package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.QualificationAudit;
import com.ruoyi.system.mapper.QualificationAuditMapper;
import com.ruoyi.system.service.IQualificationAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资质审核 服务层实现
 * 
 * @author lyb
 * @date 2019-08-14
 */
@Service
public class QualificationAuditServiceImpl implements IQualificationAuditService
{
	@Autowired
	private QualificationAuditMapper qualificationAuditMapper;

	/**
     * 查询资质审核信息
     * 
     * @param zzId 资质审核ID
     * @return 资质审核信息
     */
    @Override
	public QualificationAudit selectQualificationAuditById(Integer zzId)
	{
	    return qualificationAuditMapper.selectQualificationAuditById(zzId);
	}
	
	/**
     * 查询资质审核列表
     * 
     * @param qualificationAudit 资质审核信息
     * @return 资质审核集合
     */
	@Override
	public List<QualificationAudit> selectQualificationAuditList(QualificationAudit qualificationAudit)
	{
	    return qualificationAuditMapper.selectQualificationAuditList(qualificationAudit);
	}
	
    /**
     * 新增资质审核
     * 
     * @param qualificationAudit 资质审核信息
     * @return 结果
     */
	@Override
	public int insertQualificationAudit(QualificationAudit qualificationAudit)
	{
	    return qualificationAuditMapper.insertQualificationAudit(qualificationAudit);
	}
	
	/**
     * 修改资质审核
     * 
     * @param qualificationAudit 资质审核信息
     * @return 结果
     */
	@Override
	public int updateQualificationAudit(QualificationAudit qualificationAudit)
	{
	    return qualificationAuditMapper.updateQualificationAudit(qualificationAudit);
	}

	/**
     * 删除资质审核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteQualificationAuditByIds(String ids)
	{
		return qualificationAuditMapper.deleteQualificationAuditByIds(Convert.toStrArray(ids));
	}
	
}
