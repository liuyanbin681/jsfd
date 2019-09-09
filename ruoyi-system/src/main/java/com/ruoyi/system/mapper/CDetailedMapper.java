package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.CDetailed;

import java.util.List;

/**
 * 厂商明细 数据层
 * 
 * @author lyb
 * @date 2019-08-08
 */
public interface CDetailedMapper 
{
	/**
     * 查询厂商明细信息
     * 
     * @param cjId 厂商明细ID
     * @return 厂商明细信息
     */
	public CDetailed selectCDetailedById(Integer cjId);
	
	/**
     * 查询厂商明细列表
     * 
     * @param cDetailed 厂商明细信息
     * @return 厂商明细集合
     */
	public List<CDetailed> selectCDetailedList(CDetailed cDetailed);
	
	/**
     * 新增厂商明细
     * 
     * @param cDetailed 厂商明细信息
     * @return 结果
     */
	public int insertCDetailed(CDetailed cDetailed);
	
	/**
     * 修改厂商明细
     * 
     * @param cDetailed 厂商明细信息
     * @return 结果
     */
	public int updateCDetailed(CDetailed cDetailed);
	
	/**
     * 删除厂商明细
     * 
     * @param cjId 厂商明细ID
     * @return 结果
     */
	public int deleteCDetailedById(Integer cjId);
	
	/**
     * 批量删除厂商明细
     * 
     * @param cjIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCDetailedByIds(String[] cjIds);
	
}