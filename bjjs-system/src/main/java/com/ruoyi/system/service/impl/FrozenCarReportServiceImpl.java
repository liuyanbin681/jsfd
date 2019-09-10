package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FrozenCarReport;
import com.ruoyi.system.mapper.FrozenCarReportMapper;
import com.ruoyi.system.service.IFrozenCarReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 到站冻车上报 服务层实现
 * 
 * @author lyb
 * @date 2019-08-17
 */
@Service
public class FrozenCarReportServiceImpl implements IFrozenCarReportService
{
	@Autowired
	private FrozenCarReportMapper frozenCarReportMapper;

	/**
     * 查询到站冻车上报信息
     * 
     * @param fdReportId 到站冻车上报ID
     * @return 到站冻车上报信息
     */
    @Override
	public FrozenCarReport selectFrozenCarReportById(Integer fdReportId)
	{
	    return frozenCarReportMapper.selectFrozenCarReportById(fdReportId);
	}
	/**
	 * 返回集合
	 * @param fdReportId
	 * @return
	 */
	@Override
	public List<FrozenCarReport> selectFrozenCarReportListById(Integer fdReportId) {
		return frozenCarReportMapper.selectFrozenCarReportListById(fdReportId);
	}

	/**
	 * 通过冻车id进行查询
	 * @param freezerId
	 * @return
	 */
	@Override
	public List<FrozenCarReport> selectBySprayingOperationCounts(Integer freezerId) {
		return frozenCarReportMapper.selectBySprayingOperationCounts(freezerId);
	}

	/**
     * 查询到站冻车上报列表
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 到站冻车上报集合
     */
	@Override
	public List<FrozenCarReport> selectFrozenCarReportList(FrozenCarReport frozenCarReport)
	{
	    return frozenCarReportMapper.selectFrozenCarReportList(frozenCarReport);
	}
	/**
	 * 查询发站核实列表
	 *
	 * @param frozenCarReport 发站核实信息
	 * @return 发站集合
	 */
	@Override
	public List<FrozenCarReport> selectVerifyCarReportList(FrozenCarReport frozenCarReport) {
		return frozenCarReportMapper.selectVerifyCarReportList(frozenCarReport);
	}

	/**
     * 新增到站冻车上报
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 结果
     */
	@Override
	public int insertFrozenCarReport(FrozenCarReport frozenCarReport)
	{
		frozenCarReport.setFdCreatetime(new Date());
		frozenCarReport.setFdRelieve("1");//默认未解除
		frozenCarReport.setFdSpray("0");//默认未喷洒
		frozenCarReport.setFdVerify("0");//默认为核实
	    return frozenCarReportMapper.insertFrozenCarReport(frozenCarReport);
	}
	
	/**
     * 修改到站冻车上报
     * 
     * @param frozenCarReport 到站冻车上报信息
     * @return 结果
     */
	@Override
	public int updateFrozenCarReport(FrozenCarReport frozenCarReport)
	{
	    return frozenCarReportMapper.updateFrozenCarReport(frozenCarReport);
	}

	/**
     * 删除到站冻车上报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFrozenCarReportByIds(String ids)
	{
		return frozenCarReportMapper.deleteFrozenCarReportByIds(Convert.toStrArray(ids));
	}
	
}
