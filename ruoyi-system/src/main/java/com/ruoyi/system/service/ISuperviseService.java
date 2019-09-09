package com.ruoyi.system.service;

import com.ruoyi.system.domain.Supervise;

import java.util.List;

/**
 * 督办事项 服务层
 * 
 * @author lyb
 * @date 2019-08-15
 */
public interface ISuperviseService 
{
	/**
     * 查询督办事项信息
     * 
     * @param suId 督办事项ID
     * @return 督办事项信息
     */
	public Supervise selectSuperviseById(Integer suId);
	
	/**
     * 查询督办事项列表
     * 
     * @param supervise 督办事项信息
     * @return 督办事项集合
     */
	public List<Supervise> selectSuperviseList(Supervise supervise);
	
	/**
     * 新增督办事项
     * 
     * @param supervise 督办事项信息
     * @return 结果
     */
	public int insertSupervise(Supervise supervise);
	
	/**
     * 修改督办事项
     * 
     * @param supervise 督办事项信息
     * @return 结果
     */
	public int updateSupervise(Supervise supervise);
		
	/**
     * 删除督办事项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSuperviseByIds(String ids);
	
}
