package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Train;
import com.ruoyi.system.mapper.TrainMapper;
import com.ruoyi.system.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 培训课件 服务层实现
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Service
public class TrainServiceImpl implements ITrainService
{
	@Autowired
	private TrainMapper trainMapper;

	/**
     * 查询培训课件信息
     * 
     * @param trainId 培训课件ID
     * @return 培训课件信息
     */
    @Override
	public Train selectTrainById(Integer trainId)
	{
	    return trainMapper.selectTrainById(trainId);
	}
	
	/**
     * 查询培训课件列表
     * 
     * @param train 培训课件信息
     * @return 培训课件集合
     */
	@Override
	public List<Train> selectTrainList(Train train)
	{
	    return trainMapper.selectTrainList(train);
	}
	
    /**
     * 新增培训课件
     * 
     * @param train 培训课件信息
     * @return 结果
     */
	@Override
	public int insertTrain(Train train)
	{
	    return trainMapper.insertTrain(train);
	}
	
	/**
     * 修改培训课件
     * 
     * @param train 培训课件信息
     * @return 结果
     */
	@Override
	public int updateTrain(Train train)
	{
	    return trainMapper.updateTrain(train);
	}

	/**
     * 删除培训课件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTrainByIds(String ids)
	{
		return trainMapper.deleteTrainByIds(Convert.toStrArray(ids));
	}
	
}
