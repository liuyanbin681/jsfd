package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 厂商明细表 c_Detailed
 * 
 * @author lyb
 * @date 2019-08-08
 */
public class CDetailed extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 供货明细id */
	private Integer cjId;
	/** 货用中心名称 */
	private String cjDept;
	/** 营业部 */
	private String cjYydept;
	/** 营业网点 */
	private String cjYywd;
	/** 装车点 */
	private String cjPalce;
	/** 装车点id */
	private Integer cjPalceId;
	/** 出货量 */
	private Integer cjShipment;
	/** 出货时间 */
	private Date cjOutTime;
	/** 录入日期 */
	private Date cjWriterTime;
	/** 备注 */
	private String cjRemarks;
	/** 用户所在部门 */
	private Integer cjUserDeptId;
	/** 防冻液类型 */
	private String cjType;
	/** 防冻液转化后结果 */
	private Integer cjConversionAp;

	public Integer getCjConversionAp() {
		return cjConversionAp;
	}

	public void setCjConversionAp(Integer cjConversionAp) {
		this.cjConversionAp = cjConversionAp;
	}

	public String getCjType() {
		return cjType;
	}

	public void setCjType(String cjType) {
		this.cjType = cjType;
	}

	public Date getCjOutTime() {
		return cjOutTime;
	}

	public void setCjOutTime(Date cjOutTime) {
		this.cjOutTime = cjOutTime;
	}

	public Date getCjWriterTime() {
		return cjWriterTime;
	}

	public void setCjWriterTime(Date cjWriterTime) {
		this.cjWriterTime = cjWriterTime;
	}

	/** 创建人 */
	private String cjCreate;

	public void setCjId(Integer cjId) 
	{
		this.cjId = cjId;
	}

	public Integer getCjId() 
	{
		return cjId;
	}
	public void setCjDept(String cjDept) 
	{
		this.cjDept = cjDept;
	}

	public String getCjDept() 
	{
		return cjDept;
	}
	public void setCjYydept(String cjYydept) 
	{
		this.cjYydept = cjYydept;
	}

	public String getCjYydept() 
	{
		return cjYydept;
	}
	public void setCjYywd(String cjYywd) 
	{
		this.cjYywd = cjYywd;
	}

	public String getCjYywd() 
	{
		return cjYywd;
	}
	public void setCjPalce(String cjPalce) 
	{
		this.cjPalce = cjPalce;
	}

	public String getCjPalce() 
	{
		return cjPalce;
	}
	public void setCjPalceId(Integer cjPalceId) 
	{
		this.cjPalceId = cjPalceId;
	}

	public Integer getCjPalceId() 
	{
		return cjPalceId;
	}
	public void setCjShipment(Integer cjShipment) 
	{
		this.cjShipment = cjShipment;
	}

	public Integer getCjShipment()
	{
		return cjShipment;
	}
	public void setCjRemarks(String cjRemarks)
	{
		this.cjRemarks = cjRemarks;
	}

	public String getCjRemarks() 
	{
		return cjRemarks;
	}
	public void setCjUserDeptId(Integer cjUserDeptId) 
	{
		this.cjUserDeptId = cjUserDeptId;
	}

	public Integer getCjUserDeptId() 
	{
		return cjUserDeptId;
	}
	public void setCjCreate(String cjCreate) 
	{
		this.cjCreate = cjCreate;
	}

	public String getCjCreate() 
	{
		return cjCreate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cjId", getCjId())
            .append("cjDept", getCjDept())
            .append("cjYydept", getCjYydept())
            .append("cjYywd", getCjYywd())
            .append("cjPalce", getCjPalce())
            .append("cjPalceId", getCjPalceId())
            .append("cjShipment", getCjShipment())
            .append("cjOutTime", getCjOutTime())
            .append("cjWriterTime", getCjWriterTime())
            .append("cjRemarks", getCjRemarks())
            .append("cjUserDeptId", getCjUserDeptId())
            .append("cjCreate", getCjCreate())
            .toString();
    }
}
