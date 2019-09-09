package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Supervise;
import com.ruoyi.system.mapper.SuperviseMapper;
import com.ruoyi.system.service.ISuperviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 督办事项 服务层实现
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Service
public class SuperviseServiceImpl implements ISuperviseService
{
	@Autowired
	private SuperviseMapper superviseMapper;

	/**
     * 查询督办事项信息
     * 
     * @param suId 督办事项ID
     * @return 督办事项信息
     */
    @Override
	public Supervise selectSuperviseById(Integer suId)
	{
	    return superviseMapper.selectSuperviseById(suId);
	}
	
	/**
     * 查询督办事项列表
     * 
     * @param supervise 督办事项信息
     * @return 督办事项集合
     */
	@Override
	public List<Supervise> selectSuperviseList(Supervise supervise)
	{
	    return superviseMapper.selectSuperviseList(supervise);
	}
	
    /**
     * 新增督办事项
     * 
     * @param supervise 督办事项信息
     * @return 结果
     */
	@Override
	public int insertSupervise(Supervise supervise)
	{
	    return superviseMapper.insertSupervise(supervise);
	}
	
	/**
     * 修改督办事项
     * 
     * @param supervise 督办事项信息
     * @return 结果
     */
	@Override
	public int updateSupervise(Supervise supervise)
	{
	    return superviseMapper.updateSupervise(supervise);
	}

	/**
     * 删除督办事项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSuperviseByIds(String ids)
	{
		return superviseMapper.deleteSuperviseByIds(Convert.toStrArray(ids));
	}
	
}
