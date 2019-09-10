package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Regulations;
import com.ruoyi.system.mapper.RegulationsMapper;
import com.ruoyi.system.service.IRegulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 规章文电 服务层实现
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Service
public class RegulationsServiceImpl implements IRegulationsService
{
	@Autowired
	private RegulationsMapper regulationsMapper;

	/**
     * 查询规章文电信息
     * 
     * @param rulesId 规章文电ID
     * @return 规章文电信息
     */
    @Override
	public Regulations selectRegulationsById(Integer rulesId)
	{
	    return regulationsMapper.selectRegulationsById(rulesId);
	}
	
	/**
     * 查询规章文电列表
     * 
     * @param regulations 规章文电信息
     * @return 规章文电集合
     */
	@Override
	public List<Regulations> selectRegulationsList(Regulations regulations)
	{
	    return regulationsMapper.selectRegulationsList(regulations);
	}
	
    /**
     * 新增规章文电
     * 
     * @param regulations 规章文电信息
     * @return 结果
     */
	@Override
	public int insertRegulations(Regulations regulations)
	{
	    return regulationsMapper.insertRegulations(regulations);
	}
	
	/**
     * 修改规章文电
     * 
     * @param regulations 规章文电信息
     * @return 结果
     */
	@Override
	public int updateRegulations(Regulations regulations)
	{
	    return regulationsMapper.updateRegulations(regulations);
	}

	/**
     * 删除规章文电对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRegulationsByIds(String ids)
	{
		return regulationsMapper.deleteRegulationsByIds(Convert.toStrArray(ids));
	}
	
}
