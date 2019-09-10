package com.ruoyi.system.service;

import com.ruoyi.system.domain.Train;

import java.util.List;

/**
 * 培训课件 服务层
 * 
 * @author lyb
 * @date 2019-08-15
 */
public interface ITrainService 
{
	/**
     * 查询培训课件信息
     * 
     * @param trainId 培训课件ID
     * @return 培训课件信息
     */
	public Train selectTrainById(Integer trainId);
	
	/**
     * 查询培训课件列表
     * 
     * @param train 培训课件信息
     * @return 培训课件集合
     */
	public List<Train> selectTrainList(Train train);
	
	/**
     * 新增培训课件
     * 
     * @param train 培训课件信息
     * @return 结果
     */
	public int insertTrain(Train train);
	
	/**
     * 修改培训课件
     * 
     * @param train 培训课件信息
     * @return 结果
     */
	public int updateTrain(Train train);
		
	/**
     * 删除培训课件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTrainByIds(String ids);
	
}
