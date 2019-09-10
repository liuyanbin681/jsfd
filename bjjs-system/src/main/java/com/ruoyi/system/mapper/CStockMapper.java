package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.CStock;

import java.util.List;

/**
 * 厂商销售库存 数据层
 * 
 * @author lyb
 * @date 2019-08-09
 */
public interface CStockMapper 
{
	/**
     * 查询厂商销售库存信息
     * 
     * @param stockId 厂商销售库存ID
     * @return 厂商销售库存信息
     */
	public CStock selectCStockById(Integer stockId);

	/**
	 * 根据装车点进行查询
	 * @param stockPalceId
	 * @return
	 */
	public CStock selectsByStockPalceId(Integer stockPalceId);
	/**
     * 查询厂商销售库存列表
     * 
     * @param cStock 厂商销售库存信息
     * @return 厂商销售库存集合
     */
	public List<CStock> selectCStockList(CStock cStock);
	
	/**
     * 新增厂商销售库存
     * 
     * @param cStock 厂商销售库存信息
     * @return 结果
     */
	public int insertCStock(CStock cStock);
	
	/**
     * 修改厂商销售库存
     * 
     * @param cStock 厂商销售库存信息
     * @return 结果
     */
	public int updateCStock(CStock cStock);
	/**
	 * 根据装车点进行修改
	 * @param cStock
	 * @return
	 */
	public int updateByPalceId(CStock cStock);

	/**
	 * 根据装车点查看是否存在
	 * @param stockPalceId
	 * @return
	 */
	public int selectsBySPalceId(Integer stockPalceId);
	/**
     * 删除厂商销售库存
     * 
     * @param stockId 厂商销售库存ID
     * @return 结果
     */
	public int deleteCStockById(Integer stockId);
	
	/**
     * 批量删除厂商销售库存
     * 
     * @param stockIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCStockByIds(String[] stockIds);
	
}