package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 总结上报表 Summary
 * 
 * @author lyb
 * @date 2019-08-15
 */
public class Summary extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 总结上报id */
	private Integer sId;
	/** 总结上报文件名称 */
	private String summaryFile;
	/** 总结上报创建人 */
	private String summaryCreatename;
	/** 总结上报部门 */
	private String summaryCreateDept;
	/** 总结上报单位 */
	private String summaryCreateUnits;
	/** 创建时间 */
	private Date summaryCreateTime;
	/** 总结上报备注 */
	private String remarks;
	/** 总结上报标题 */
	private String summaryTitle;
	/** 总结上报状态 */
	private Integer status;
	/** 总结上报部门id */
	private Integer summaryDeptId;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public void setSummaryFile(String summaryFile)
	{
		this.summaryFile = summaryFile;
	}

	public String getSummaryFile() 
	{
		return summaryFile;
	}
	public void setSummaryCreatename(String summaryCreatename) 
	{
		this.summaryCreatename = summaryCreatename;
	}

	public String getSummaryCreatename() 
	{
		return summaryCreatename;
	}
	public void setSummaryCreateDept(String summaryCreateDept) 
	{
		this.summaryCreateDept = summaryCreateDept;
	}

	public String getSummaryCreateDept() 
	{
		return summaryCreateDept;
	}
	public void setSummaryCreateUnits(String summaryCreateUnits) 
	{
		this.summaryCreateUnits = summaryCreateUnits;
	}

	public String getSummaryCreateUnits() 
	{
		return summaryCreateUnits;
	}
	public void setSummaryCreateTime(Date summaryCreateTime)
	{
		this.summaryCreateTime = summaryCreateTime;
	}

	public Date getSummaryCreateTime()
	{
		return summaryCreateTime;
	}
	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public String getRemarks() 
	{
		return remarks;
	}
	public void setSummaryTitle(String summaryTitle) 
	{
		this.summaryTitle = summaryTitle;
	}

	public String getSummaryTitle() 
	{
		return summaryTitle;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setSummaryDeptId(Integer summaryDeptId) 
	{
		this.summaryDeptId = summaryDeptId;
	}

	public Integer getSummaryDeptId() 
	{
		return summaryDeptId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sId", getsId())
            .append("summaryFile", getSummaryFile())
            .append("summaryCreatename", getSummaryCreatename())
            .append("summaryCreateDept", getSummaryCreateDept())
            .append("summaryCreateUnits", getSummaryCreateUnits())
            .append("summaryCreateTime", getSummaryCreateTime())
            .append("remarks", getRemarks())
            .append("summaryTitle", getSummaryTitle())
            .append("status", getStatus())
            .append("summaryDeptId", getSummaryDeptId())
            .toString();
    }
}
