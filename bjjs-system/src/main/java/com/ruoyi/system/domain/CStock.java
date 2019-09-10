package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 厂商销售库存表 c_Stock
 * 
 * @author lyb
 * @date 2019-08-09
 */
public class CStock extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 库存表id，作为每年的流水表，定期清零 */
	private Integer stockId;
	/** 货运中心 */
	private String stockHyzxDept;
	/** 营业部 */
	private String stockYybDept;
	/** 营业网点 */
	private String stockYywdDept;
	/** 装车点id */
	private Integer stockPalceId;
	/** 装车点 */
	private String stockPalce;
	/** 剩余库存 */
	private Integer stockSurplus;
	/** 创建人 */
	private String stockCreate;
	/** 用户所在部门 */
	private Integer stockUserDeptId;
	/** 创建时间 */
	private Date stockCreatetime;
	/** 修改时间 */
	private Date stockUpdatetime;

	public void setStockId(Integer stockId) 
	{
		this.stockId = stockId;
	}

	public Integer getStockId() 
	{
		return stockId;
	}
	public void setStockHyzxDept(String stockHyzxDept) 
	{
		this.stockHyzxDept = stockHyzxDept;
	}

	public String getStockHyzxDept() 
	{
		return stockHyzxDept;
	}
	public void setStockYybDept(String stockYybDept) 
	{
		this.stockYybDept = stockYybDept;
	}

	public String getStockYybDept() 
	{
		return stockYybDept;
	}
	public void setStockYywdDept(String stockYywdDept) 
	{
		this.stockYywdDept = stockYywdDept;
	}

	public String getStockYywdDept() 
	{
		return stockYywdDept;
	}
	public void setStockPalceId(Integer stockPalceId) 
	{
		this.stockPalceId = stockPalceId;
	}

	public Integer getStockPalceId() 
	{
		return stockPalceId;
	}
	public void setStockPalce(String stockPalce)
	{
		this.stockPalce = stockPalce;
	}

	public String getStockPalce()
	{
		return stockPalce;
	}
	public void setStockSurplus(Integer stockSurplus)
	{
		this.stockSurplus = stockSurplus;
	}

	public Integer getStockSurplus() 
	{
		return stockSurplus;
	}
	public void setStockCreate(String stockCreate) 
	{
		this.stockCreate = stockCreate;
	}

	public String getStockCreate() 
	{
		return stockCreate;
	}
	public void setStockUserDeptId(Integer stockUserDeptId) 
	{
		this.stockUserDeptId = stockUserDeptId;
	}

	public Integer getStockUserDeptId() 
	{
		return stockUserDeptId;
	}
	public void setStockCreatetime(Date stockCreatetime)
	{
		this.stockCreatetime = stockCreatetime;
	}

	public Date getStockCreatetime()
	{
		return stockCreatetime;
	}
	public void setStockUpdatetime(Date stockUpdatetime)
	{
		this.stockUpdatetime = stockUpdatetime;
	}

	public Date getStockUpdatetime()
	{
		return stockUpdatetime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockId", getStockId())
            .append("stockHyzxDept", getStockHyzxDept())
            .append("stockYybDept", getStockYybDept())
            .append("stockYywdDept", getStockYywdDept())
            .append("stockPalceId", getStockPalceId())
            .append("stockPalce", getStockPalce())
            .append("stockSurplus", getStockSurplus())
            .append("stockCreate", getStockCreate())
            .append("stockUserDeptId", getStockUserDeptId())
            .append("stockCreatetime", getStockCreatetime())
            .append("stockUpdatetime", getStockUpdatetime())
            .toString();
    }
}
