package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 培训课件表 Train
 * 
 * @author lyb
 * @date 2019-08-15
 */
public class Train extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 培训课件id */
	private Integer trainId;
	/** 培训课件名称 */
	private String trainFileName;
	/** 培训课件创建时间 */
	private Date trainCreatetime;
	/** 培训课件创建人 */
	private String trainCreatename;
	/** 培训课件备注 */
	private String trainRemarks;
	/** 培训课件备用 */
	private String trainSpare;
	/** 培训课程标题 */
	private String trainTitile;

	public void setTrainId(Integer trainId) 
	{
		this.trainId = trainId;
	}

	public Integer getTrainId() 
	{
		return trainId;
	}
	public void setTrainFileName(String trainFileName) 
	{
		this.trainFileName = trainFileName;
	}

	public String getTrainFileName() 
	{
		return trainFileName;
	}
	public void setTrainCreatetime(Date trainCreatetime)
	{
		this.trainCreatetime = trainCreatetime;
	}

	public Date getTrainCreatetime()
	{
		return trainCreatetime;
	}
	public void setTrainCreatename(String trainCreatename) 
	{
		this.trainCreatename = trainCreatename;
	}

	public String getTrainCreatename() 
	{
		return trainCreatename;
	}
	public void setTrainRemarks(String trainRemarks) 
	{
		this.trainRemarks = trainRemarks;
	}

	public String getTrainRemarks() 
	{
		return trainRemarks;
	}
	public void setTrainSpare(String trainSpare) 
	{
		this.trainSpare = trainSpare;
	}

	public String getTrainSpare() 
	{
		return trainSpare;
	}
	public void setTrainTitile(String trainTitile) 
	{
		this.trainTitile = trainTitile;
	}

	public String getTrainTitile() 
	{
		return trainTitile;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trainId", getTrainId())
            .append("trainFileName", getTrainFileName())
            .append("trainCreatetime", getTrainCreatetime())
            .append("trainCreatename", getTrainCreatename())
            .append("trainRemarks", getTrainRemarks())
            .append("trainSpare", getTrainSpare())
            .append("trainTitile", getTrainTitile())
            .toString();
    }
}
