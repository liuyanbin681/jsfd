package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.QualificationAudit;

import java.util.List;

/**
 * 资质审核 数据层
 * 
 * @author lyb
 * @date 2019-08-14
 */
public interface QualificationAuditMapper 
{
	/**
     * 查询资质审核信息
     * 
     * @param zzId 资质审核ID
     * @return 资质审核信息
     */
	public QualificationAudit selectQualificationAuditById(Integer zzId);
	
	/**
     * 查询资质审核列表
     * 
     * @param qualificationAudit 资质审核信息
     * @return 资质审核集合
     */
	public List<QualificationAudit> selectQualificationAuditList(QualificationAudit qualificationAudit);
	
	/**
     * 新增资质审核
     * 
     * @param qualificationAudit 资质审核信息
     * @return 结果
     */
	public int insertQualificationAudit(QualificationAudit qualificationAudit);
	
	/**
     * 修改资质审核
     * 
     * @param qualificationAudit 资质审核信息
     * @return 结果
     */
	public int updateQualificationAudit(QualificationAudit qualificationAudit);
	
	/**
     * 删除资质审核
     * 
     * @param zzId 资质审核ID
     * @return 结果
     */
	public int deleteQualificationAuditById(Integer zzId);
	
	/**
     * 批量删除资质审核
     * 
     * @param zzIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteQualificationAuditByIds(String[] zzIds);
	
}