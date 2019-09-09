package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Regulations;

import java.util.List;

/**
 * 规章文电 数据层
 * 
 * @author lyb
 * @date 2019-08-15
 */
public interface RegulationsMapper 
{
	/**
     * 查询规章文电信息
     * 
     * @param rulesId 规章文电ID
     * @return 规章文电信息
     */
	public Regulations selectRegulationsById(Integer rulesId);
	
	/**
     * 查询规章文电列表
     * 
     * @param regulations 规章文电信息
     * @return 规章文电集合
     */
	public List<Regulations> selectRegulationsList(Regulations regulations);
	
	/**
     * 新增规章文电
     * 
     * @param regulations 规章文电信息
     * @return 结果
     */
	public int insertRegulations(Regulations regulations);
	
	/**
     * 修改规章文电
     * 
     * @param regulations 规章文电信息
     * @return 结果
     */
	public int updateRegulations(Regulations regulations);
	
	/**
     * 删除规章文电
     * 
     * @param rulesId 规章文电ID
     * @return 结果
     */
	public int deleteRegulationsById(Integer rulesId);
	
	/**
     * 批量删除规章文电
     * 
     * @param rulesIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRegulationsByIds(String[] rulesIds);
	
}