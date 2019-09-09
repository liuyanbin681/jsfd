package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 资质审核表 Qualification_Audit
 * 
 * @author lyb
 * @date 2019-08-14
 */
public class QualificationAudit extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 资质审核id */
	private Integer zzId;
	/** 厂商 */
	private String zzManufacturer;
	/** 资质文件名称 */
	private String zzFilename;
	/** 创建时间 */
	private Date zzCreatetime;
	/** 修改时间 */
	private Date zzUpdatetime;
	/** 用户id */
	private Integer zzUserId;
	/** 资质审核备注 */
	private String zzRemarks;
	/** 资质审核部门id */
	private Integer zzDeptId;
	/** 资质审核标题 */
	private String zzTitle;

	public void setZzId(Integer zzId) 
	{
		this.zzId = zzId;
	}

	public Integer getZzId() 
	{
		return zzId;
	}
	public void setZzManufacturer(String zzManufacturer) 
	{
		this.zzManufacturer = zzManufacturer;
	}

	public String getZzManufacturer() 
	{
		return zzManufacturer;
	}
	public void setZzFilename(String zzFilename) 
	{
		this.zzFilename = zzFilename;
	}

	public String getZzFilename() 
	{
		return zzFilename;
	}
	public void setZzCreatetime(Date zzCreatetime)
	{
		this.zzCreatetime = zzCreatetime;
	}

	public Date getZzCreatetime()
	{
		return zzCreatetime;
	}
	public void setZzUpdatetime(Date zzUpdatetime)
	{
		this.zzUpdatetime = zzUpdatetime;
	}

	public Date getZzUpdatetime()
	{
		return zzUpdatetime;
	}
	public void setZzUserId(Integer zzUserId) 
	{
		this.zzUserId = zzUserId;
	}

	public Integer getZzUserId() 
	{
		return zzUserId;
	}
	public void setZzRemarks(String zzRemarks) 
	{
		this.zzRemarks = zzRemarks;
	}

	public String getZzRemarks() 
	{
		return zzRemarks;
	}
	public void setZzDeptId(Integer zzDeptId) 
	{
		this.zzDeptId = zzDeptId;
	}

	public Integer getZzDeptId() 
	{
		return zzDeptId;
	}
	public void setZzTitle(String zzTitle) 
	{
		this.zzTitle = zzTitle;
	}

	public String getZzTitle() 
	{
		return zzTitle;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("zzId", getZzId())
            .append("zzManufacturer", getZzManufacturer())
            .append("zzFilename", getZzFilename())
            .append("zzCreatetime", getZzCreatetime())
            .append("zzUpdatetime", getZzUpdatetime())
            .append("zzUserId", getZzUserId())
            .append("zzRemarks", getZzRemarks())
            .append("zzDeptId", getZzDeptId())
            .append("zzTitle", getZzTitle())
            .toString();
    }
}
