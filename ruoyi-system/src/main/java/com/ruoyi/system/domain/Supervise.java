package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 督办事项表 supervise
 * 
 * @author lyb
 * @date 2019-08-15
 */
public class Supervise extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 督办序号 */
	private Integer suId;
	/** 督办标题 */
	private String suTitle;
	/** 督办内容 */
	private String suContent;
	/** 反馈结果 */
	private String suResult;
	/** 创建人部门id */
	private Integer suCreatedeptId;
	/** 创建人id */
	private Integer suCreatenameId;
	/** 接收方 */
	private String suAccept;
	/** 接收方id */
	private Integer suAcceptDeptId;
	/** 创建时间 */
	private Date suCreatetime;
	/** 修改时间 */
	private Date suUpdatetime;
	/** 状态值 0，未读 1，已读 */
	private Integer suStatus;
	/** 督办文件名称 */
	private String suFilename;

	public void setSuId(Integer suId) 
	{
		this.suId = suId;
	}

	public Integer getSuId() 
	{
		return suId;
	}
	public void setSuTitle(String suTitle) 
	{
		this.suTitle = suTitle;
	}

	public String getSuTitle() 
	{
		return suTitle;
	}
	public void setSuContent(String suContent) 
	{
		this.suContent = suContent;
	}

	public String getSuContent() 
	{
		return suContent;
	}
	public void setSuResult(String suResult) 
	{
		this.suResult = suResult;
	}

	public String getSuResult() 
	{
		return suResult;
	}
	public void setSuCreatedeptId(Integer suCreatedeptId) 
	{
		this.suCreatedeptId = suCreatedeptId;
	}

	public Integer getSuCreatedeptId() 
	{
		return suCreatedeptId;
	}
	public void setSuCreatenameId(Integer suCreatenameId) 
	{
		this.suCreatenameId = suCreatenameId;
	}

	public Integer getSuCreatenameId() 
	{
		return suCreatenameId;
	}
	public void setSuAccept(String suAccept) 
	{
		this.suAccept = suAccept;
	}

	public String getSuAccept() 
	{
		return suAccept;
	}
	public void setSuAcceptDeptId(Integer suAcceptDeptId) 
	{
		this.suAcceptDeptId = suAcceptDeptId;
	}

	public Integer getSuAcceptDeptId() 
	{
		return suAcceptDeptId;
	}
	public void setSuCreatetime(Date suCreatetime)
	{
		this.suCreatetime = suCreatetime;
	}

	public Date getSuCreatetime()
	{
		return suCreatetime;
	}
	public void setSuUpdatetime(Date suUpdatetime)
	{
		this.suUpdatetime = suUpdatetime;
	}

	public Date getSuUpdatetime()
	{
		return suUpdatetime;
	}
	public void setSuStatus(Integer suStatus) 
	{
		this.suStatus = suStatus;
	}

	public Integer getSuStatus() 
	{
		return suStatus;
	}
	public void setSuFilename(String suFilename) 
	{
		this.suFilename = suFilename;
	}

	public String getSuFilename() 
	{
		return suFilename;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("suId", getSuId())
            .append("suTitle", getSuTitle())
            .append("suContent", getSuContent())
            .append("suResult", getSuResult())
            .append("suCreatedeptId", getSuCreatedeptId())
            .append("suCreatenameId", getSuCreatenameId())
            .append("suAccept", getSuAccept())
            .append("suAcceptDeptId", getSuAcceptDeptId())
            .append("suCreatetime", getSuCreatetime())
            .append("suUpdatetime", getSuUpdatetime())
            .append("suStatus", getSuStatus())
            .append("suFilename", getSuFilename())
            .toString();
    }
}
