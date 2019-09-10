package com.ruoyi.system.service;

import com.ruoyi.system.domain.FrozenCarReport;

import java.util.List;

/**
 * 到站冻车上报 服务层
 * 
 * @author lyb
 * @date 2019-08-17
 */
public interface IFrozenCarReportService 
{
	/**
     * 查询到站冻车上报信息
     * 
     * @param fdReportId 到站冻车上报ID
     * @return 到站冻车上报信息
     */
	public FrozenCarReport selectFrozenCarReportById(Integer fdReportId);
	/**
	 * 返回集合
	 * @param fdReportId
	 * @return
	 */
	public List<FrozenCarReport>selectFrozenCarReportListById(Integer fdReportId);

	/**
	 * 通过冻车id进行查询
	 * @param freezerId
	 * @return
	 */
	public List<FrozenCarReport>selectBySprayingOperationCounts(Integer freezerId);
	/**
     * 查询到站冻车上报列表
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 到站冻车上报集合
     */
	public List<FrozenCarReport> selectFrozenCarReportList(FrozenCarReport frozenCarReport);
	/**
	 * 查询发站核实列表
	 *
	 * @param frozenCarReport 发站核实信息
	 * @return 发站集合
	 */
	public List<FrozenCarReport> selectVerifyCarReportList(FrozenCarReport frozenCarReport);
	/**
     * 新增到站冻车上报
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 结果
     */
	public int insertFrozenCarReport(FrozenCarReport frozenCarReport);
	
	/**
     * 修改到站冻车上报
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 结果
     */
	public int updateFrozenCarReport(FrozenCarReport frozenCarReport);
		
	/**
     * 删除到站冻车上报信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFrozenCarReportByIds(String ids);
	
}
