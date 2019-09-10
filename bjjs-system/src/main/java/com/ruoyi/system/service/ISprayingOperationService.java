package com.ruoyi.system.service;

import com.ruoyi.system.domain.SprayingOperation;

import java.util.List;

/**
 * 装车喷洒作业 服务层
 * 
 * @author lyb
 * @date 2019-08-16
 */
public interface ISprayingOperationService 
{
	/**
     * 查询装车喷洒作业信息
     * 
     * @param sprayId 装车喷洒作业ID
     * @return 装车喷洒作业信息
     */
	public SprayingOperation selectSprayingOperationById(Integer sprayId);
	
	/**
     * 查询装车喷洒作业列表
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 装车喷洒作业集合
     */
	public List<SprayingOperation> selectSprayingOperationList(SprayingOperation sprayingOperation);
	/**
	 * 测试查询装车喷洒作业列表
	 * @param sprayingOperation 装车喷洒作业信息
	 * @return装车喷洒作业集合
	 */
	public List<SprayingOperation>selectSprayingOperationLists(SprayingOperation sprayingOperation);
	/**
     * 新增装车喷洒作业
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 结果
     */
	public int insertSprayingOperation(SprayingOperation sprayingOperation);
	/**
	 * 测试查询装车喷洒作业(冻车数)
	 * @param freezerId 冻车id(喷洒表)
	 * @return装车喷洒作业集合
	 */
	public List<SprayingOperation>selectBySprayingOperationCount(Integer freezerId);
	/**
	 * 1，煤，2，矿粉
	 * @param sprayType 喷洒类型
	 * @return
	 */
	public List<SprayingOperation>selectByCoalCars(Integer sprayType);
	/***
	 *根据货运中心查询喷洒总量
	 */
	public List<SprayingOperation>selectByHyZx(Integer sprayDeptPId);
	/**
	 *
	 * @return喷洒作业集合
	 */
	public List<SprayingOperation>selectByTypeCarS();
	/**
	/**
     * 修改装车喷洒作业
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 结果
     */
	public int updateSprayingOperation(SprayingOperation sprayingOperation);

	/**
	 * 验证数据是否存在
	 * @param sprayDeptPId
	 * @param sprayType
	 * @return
	 */
	public SprayingOperation selectByVerify(Integer sprayDeptPId, Integer sprayType);
	/**
     * 删除装车喷洒作业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSprayingOperationByIds(String ids);
	
}
