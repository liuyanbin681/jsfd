package com.ruoyi.system.service;

import com.ruoyi.system.domain.Summary;

import java.util.List;

/**
 * 总结上报 服务层
 * 
 * @author lyb
 * @date 2019-08-15
 */
public interface ISummaryService 
{
	/**
     * 查询总结上报信息
     * 
     * @param sId 总结上报ID
     * @return 总结上报信息
     */
	public Summary selectSummaryById(Integer sId);
	
	/**
     * 查询总结上报列表
     * 
     * @param summary 总结上报信息
     * @return 总结上报集合
     */
	public List<Summary> selectSummaryList(Summary summary);
	
	/**
     * 新增总结上报
     * 
     * @param summary 总结上报信息
     * @return 结果
     */
	public int insertSummary(Summary summary);
	
	/**
     * 修改总结上报
     * 
     * @param summary 总结上报信息
     * @return 结果
     */
	public int updateSummary(Summary summary);
		
	/**
     * 删除总结上报信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSummaryByIds(String ids);
	
}
