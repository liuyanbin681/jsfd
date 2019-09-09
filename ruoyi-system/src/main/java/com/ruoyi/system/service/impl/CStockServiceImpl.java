package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.CStock;
import com.ruoyi.system.mapper.CStockMapper;
import com.ruoyi.system.service.ICStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 厂商销售库存 服务层实现
 * 
 * @author lyb
 * @date 2019-08-09
 */
@Service
public class CStockServiceImpl implements ICStockService
{
	@Autowired
	private CStockMapper cStockMapper;

	/**
     * 查询厂商销售库存信息
     * 
     * @param stockId 厂商销售库存ID
     * @return 厂商销售库存信息
     */
    @Override
	public CStock selectCStockById(Integer stockId)
	{
	    return cStockMapper.selectCStockById(stockId);
	}

	/**
	 * 根据装车点id进行查询
	 * @param stockPalceId
	 * @return
	 */
	@Override
	public CStock selectsByStockPalceId(Integer stockPalceId) {
		return cStockMapper.selectsByStockPalceId(stockPalceId);
	}

	/**
	 * 根据装车点查看是否存在
	 * @param stockPalceId
	 * @return
	 */
	@Override
	public int selectsBySPalceId(Integer stockPalceId) {
		return cStockMapper.selectsBySPalceId(stockPalceId);
	}

	/**
     * 查询厂商销售库存列表
     * 
     * @param cStock 厂商销售库存信息
     * @return 厂商销售库存集合
     */
	@Override
	public List<CStock> selectCStockList(CStock cStock)
	{
	    return cStockMapper.selectCStockList(cStock);
	}
	
    /**
     * 新增厂商销售库存
     * 
     * @param cStock 厂商销售库存信息
     * @return 结果
     */
	@Override
	public int insertCStock(CStock cStock)
	{
	    return cStockMapper.insertCStock(cStock);
	}
	
	/**
     * 修改厂商销售库存
     * 
     * @param cStock 厂商销售库存信息
     * @return 结果
     */
	@Override
	public int updateCStock(CStock cStock)
	{
	    return cStockMapper.updateCStock(cStock);
	}

	@Override
	public int updateByPalceId(CStock cStock) {
		return 0;
	}


	/**
     * 删除厂商销售库存对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCStockByIds(String ids)
	{
		return cStockMapper.deleteCStockByIds(Convert.toStrArray(ids));
	}
	
}
