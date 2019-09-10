package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 装车喷洒作业表 Spraying_operation
 * 
 * @author lyb
 * @date 2019-08-17
 */
public class SprayingOperation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 喷洒作业id */
	private Integer sprayId;
	/** 装车点 */
	private String sprayLocation;
	/** 装车点id */
	private Integer sprayLocationId;
	/** 喷洒车数 */
	private Integer sprayCarsCount;
	/** 冻车数 */
	private Integer sprayDcCount;
	/** 冻车id */
	private Integer freezerId;
	/** 喷洒总量 */
	private Integer spraySum;
	/** 喷洒人 */
	private String sprayName;
	/** 喷洒单位 */
	private String sprayCompany;
	/** 创建时间 */
	private String sprayCreatetime;
	/** 喷洒时间 */
	private String sprayDatetime;
	/** 喷洒作业修改时间 */
	private Date sprayUpdatetime;
	/** 发站 */
	private String sprayDeparture;
	/** 到站 */
	private String sprayStation;
	/** 上级部门id */
	private Integer sprayDeptId;
	/** 喷洒类型 */
	private Integer sprayType;
	/** 备注 */
	private String sprayRemarks;
	/** 创建人 */
	private String sprayCreatename;
	/** 父id */
	private Integer sprayDeptPId;
  /**冻车次数**/
  private  Integer count;
  /*喷洒车数*/
  private  Integer cars;

	/**
	 * 喷洒的货用中心
	 * @return
	 */
	private Integer PDeptId;

	public Integer getCars() {
		return cars;
	}

	public void setCars(Integer cars) {
		this.cars = cars;
	}

	public Integer getPDeptId() {
		return PDeptId;
	}

	public void setPDeptId(Integer PDeptId) {
		this.PDeptId = PDeptId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setSprayId(Integer sprayId)
	{
		this.sprayId = sprayId;
	}

	public Integer getSprayId() 
	{
		return sprayId;
	}
	public void setSprayLocation(String sprayLocation) 
	{
		this.sprayLocation = sprayLocation;
	}

	public String getSprayLocation() 
	{
		return sprayLocation;
	}
	public void setSprayLocationId(Integer sprayLocationId) 
	{
		this.sprayLocationId = sprayLocationId;
	}

	public Integer getSprayLocationId() 
	{
		return sprayLocationId;
	}
	public void setSprayCarsCount(Integer sprayCarsCount) 
	{
		this.sprayCarsCount = sprayCarsCount;
	}

	public Integer getSprayCarsCount() 
	{
		return sprayCarsCount;
	}
	public void setSprayDcCount(Integer sprayDcCount) 
	{
		this.sprayDcCount = sprayDcCount;
	}

	public Integer getSprayDcCount() 
	{
		return sprayDcCount;
	}
	public void setFreezerId(Integer freezerId) 
	{
		this.freezerId = freezerId;
	}

	public Integer getFreezerId() 
	{
		return freezerId;
	}
	public void setSpraySum(Integer spraySum) 
	{
		this.spraySum = spraySum;
	}

	public Integer getSpraySum() 
	{
		return spraySum;
	}
	public void setSprayName(String sprayName) 
	{
		this.sprayName = sprayName;
	}

	public String getSprayName() 
	{
		return sprayName;
	}
	public void setSprayCompany(String sprayCompany) 
	{
		this.sprayCompany = sprayCompany;
	}

	public String getSprayCompany() 
	{
		return sprayCompany;
	}

	public String getSprayCreatetime() {
		return sprayCreatetime;
	}

	public void setSprayCreatetime(String sprayCreatetime) {
		this.sprayCreatetime = sprayCreatetime;
	}

	public String getSprayDatetime() {
		return sprayDatetime;
	}

	public void setSprayDatetime(String sprayDatetime) {
		this.sprayDatetime = sprayDatetime;
	}

	public void setSprayUpdatetime(Date sprayUpdatetime)
	{
		this.sprayUpdatetime = sprayUpdatetime;
	}

	public Date getSprayUpdatetime()
	{
		return sprayUpdatetime;
	}
	public void setSprayDeparture(String sprayDeparture) 
	{
		this.sprayDeparture = sprayDeparture;
	}

	public String getSprayDeparture() 
	{
		return sprayDeparture;
	}
	public void setSprayStation(String sprayStation) 
	{
		this.sprayStation = sprayStation;
	}

	public String getSprayStation() 
	{
		return sprayStation;
	}
	public void setSprayDeptId(Integer sprayDeptId) 
	{
		this.sprayDeptId = sprayDeptId;
	}

	public Integer getSprayDeptId() 
	{
		return sprayDeptId;
	}
	public void setSprayType(Integer sprayType) 
	{
		this.sprayType = sprayType;
	}

	public Integer getSprayType() 
	{
		return sprayType;
	}
	public void setSprayRemarks(String sprayRemarks) 
	{
		this.sprayRemarks = sprayRemarks;
	}

	public String getSprayRemarks() 
	{
		return sprayRemarks;
	}
	public void setSprayCreatename(String sprayCreatename) 
	{
		this.sprayCreatename = sprayCreatename;
	}

	public String getSprayCreatename() 
	{
		return sprayCreatename;
	}
	public void setSprayDeptPId(Integer sprayDeptPId) 
	{
		this.sprayDeptPId = sprayDeptPId;
	}

	public Integer getSprayDeptPId() 
	{
		return sprayDeptPId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sprayId", getSprayId())
            .append("sprayLocation", getSprayLocation())
            .append("sprayLocationId", getSprayLocationId())
            .append("sprayCarsCount", getSprayCarsCount())
            .append("sprayDcCount", getSprayDcCount())
            .append("freezerId", getFreezerId())
            .append("spraySum", getSpraySum())
            .append("sprayName", getSprayName())
            .append("sprayCompany", getSprayCompany())
            .append("sprayCreatetime", getSprayCreatetime())
            .append("sprayDatetime", getSprayDatetime())
            .append("sprayUpdatetime", getSprayUpdatetime())
            .append("sprayDeparture", getSprayDeparture())
            .append("sprayStation", getSprayStation())
            .append("sprayDeptId", getSprayDeptId())
            .append("sprayType", getSprayType())
            .append("sprayRemarks", getSprayRemarks())
            .append("sprayCreatename", getSprayCreatename())
            .append("sprayDeptPId", getSprayDeptPId())
            .toString();
    }
}
