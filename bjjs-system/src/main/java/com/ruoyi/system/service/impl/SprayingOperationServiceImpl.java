package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.CStock;
import com.ruoyi.system.domain.SprayingOperation;
import com.ruoyi.system.mapper.CStockMapper;
import com.ruoyi.system.mapper.SprayingOperationMapper;
import com.ruoyi.system.service.ISprayingOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 装车喷洒作业 服务层实现
 * 
 * @author lyb
 * @date 2019-08-16
 */
@Service
public class SprayingOperationServiceImpl implements ISprayingOperationService
{
	@Autowired
	private SprayingOperationMapper sprayingOperationMapper;
    @Autowired
    private CStockMapper cStockMapper;//销售库存表
	/**
     * 查询装车喷洒作业信息
     * 
     * @param sprayId 装车喷洒作业ID
     * @return 装车喷洒作业信息
     */
    @Override
	public SprayingOperation selectSprayingOperationById(Integer sprayId)
	{
	    return sprayingOperationMapper.selectSprayingOperationById(sprayId);
	}
	
	/**
     * 查询装车喷洒作业列表
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 装车喷洒作业集合
     */
	@Override
	public List<SprayingOperation> selectSprayingOperationList(SprayingOperation sprayingOperation)
	{
	    return sprayingOperationMapper.selectSprayingOperationList(sprayingOperation);
	}
	/**
	 * 测试查询装车喷洒作业列表
	 * @param sprayingOperation 装车喷洒作业信息
	 * @return装车喷洒作业集合
	 */
	@Override
	public List<SprayingOperation> selectSprayingOperationLists(SprayingOperation sprayingOperation) {
		return sprayingOperationMapper.selectSprayingOperationLists(sprayingOperation);
	}

	/**
     * 新增装车喷洒作业
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 结果
     */
	@Override
	public int insertSprayingOperation(SprayingOperation sprayingOperation)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		sprayingOperation.setSprayCreatetime(format);//创建时间
		CStock stock = cStockMapper.selectsByStockPalceId(sprayingOperation.getSprayLocationId());//拿到库存表
		Integer stockSurplus = stock.getStockSurplus();//剩余库存
		Integer spraySum = sprayingOperation.getSpraySum();//喷洒总量
		CStock cStock =new CStock();
		cStock.setStockSurplus(stockSurplus-spraySum);
		cStock.setStockPalceId(sprayingOperation.getSprayLocationId());
		cStockMapper.updateByPalceId(cStock);//更新库存表
		return sprayingOperationMapper.insertSprayingOperation(sprayingOperation);
	}
	/**
	 * 测试查询装车喷洒作业(冻车数)
	 * @param freezerId 冻车id(喷洒表)
	 * @return装车喷洒作业集合
	 */
	@Override
	public List<SprayingOperation> selectBySprayingOperationCount(Integer freezerId) {
		return sprayingOperationMapper.selectBySprayingOperationCount(freezerId);
	}
	/**
	 * 1，煤，2，矿粉
	 * @param sprayType 喷洒类型
	 * @return
	 */
	@Override
	public List<SprayingOperation> selectByCoalCars(Integer sprayType) {
		return sprayingOperationMapper.selectByCoalCars(sprayType);
	}
	/***
	 *根据货运中心查询喷洒总量
	 */
	@Override
	public List<SprayingOperation> selectByHyZx(Integer sprayDeptPId) {
		return sprayingOperationMapper.selectByHyZx(sprayDeptPId);
	}

	/**
	 *
	 * @return喷洒作业集合
	 */
	@Override
	public List<SprayingOperation> selectByTypeCarS() {
		return sprayingOperationMapper.selectByTypeCarS();
	}

	/**
     * 修改装车喷洒作业
     * 
     * @param sprayingOperation 装车喷洒作业信息
     * @return 结果
     */
	@Override
	public int updateSprayingOperation(SprayingOperation sprayingOperation)
	{
	    return sprayingOperationMapper.updateSprayingOperation(sprayingOperation);
	}
	/**
	 * 验证数据是否存在
	 * @param sprayDeptPId
	 * @param sprayType
	 * @return
	 */
	@Override
	public SprayingOperation selectByVerify(Integer sprayDeptPId, Integer sprayType) {
		return sprayingOperationMapper.selectByVerify(sprayDeptPId,sprayType);
	}

	/**
     * 删除装车喷洒作业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSprayingOperationByIds(String ids)
	{
		return sprayingOperationMapper.deleteSprayingOperationByIds(Convert.toStrArray(ids));
	}

}
