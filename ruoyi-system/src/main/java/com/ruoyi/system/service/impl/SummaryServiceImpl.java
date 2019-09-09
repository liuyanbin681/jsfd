package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Summary;
import com.ruoyi.system.mapper.SummaryMapper;
import com.ruoyi.system.service.ISummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 总结上报 服务层实现
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Service
public class SummaryServiceImpl implements ISummaryService
{
	@Autowired
	private SummaryMapper summaryMapper;

	/**
     * 查询总结上报信息
     * 
     * @param sId 总结上报ID
     * @return 总结上报信息
     */
    @Override
	public Summary selectSummaryById(Integer sId)
	{
	    return summaryMapper.selectSummaryById(sId);
	}
	
	/**
     * 查询总结上报列表
     * 
     * @param summary 总结上报信息
     * @return 总结上报集合
     */
	@Override
	public List<Summary> selectSummaryList(Summary summary)
	{
	    return summaryMapper.selectSummaryList(summary);
	}
	
    /**
     * 新增总结上报
     * 
     * @param summary 总结上报信息
     * @return 结果
     */
	@Override
	public int insertSummary(Summary summary)
	{
	    return summaryMapper.insertSummary(summary);
	}
	
	/**
     * 修改总结上报
     * 
     * @param summary 总结上报信息
     * @return 结果
     */
	@Override
	public int updateSummary(Summary summary)
	{
	    return summaryMapper.updateSummary(summary);
	}

	/**
     * 删除总结上报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSummaryByIds(String ids)
	{
		return summaryMapper.deleteSummaryByIds(Convert.toStrArray(ids));
	}
	
}
