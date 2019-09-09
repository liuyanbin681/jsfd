package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 到站冻车上报表 Frozen_car_Report
 * 
 * @author lyb
 * @date 2019-08-17
 */
public class FrozenCarReport extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 冻车上报id */
	private Integer fdReportId;
	/** 车次 */
	private String fdReporNum;
	/** 达到时间 */
	private Date fdReporDatetime;
	/** 顺位号 */
	private Integer fdReporNo;
	/** 车号 */
	private String fdReporLicense;
	/** 发站 */
	private String fdReporFz;
	/** 到站 */
	private String fdReporDz;
	/** 品类 */
	private Integer fdReporPl;
	/** 父id */
	private Integer fdReporPDeptId;
	/** 上级营业部id */
	private Integer fdReporDeptId;
	/** 收货人 */
	private String fdReporName;
	/** 冻结厚度 */
	private String fdReporDjhd;
	/** 每车冻结厚度 */
	private String fdReporCount;
	/** 影响时间 */
	private Integer fdReporImpact;
	/** 图片 */
	private String fdReporImage;
	/** 创建时间 */
	private Date fdCreatetime;
	/** 修改时间 */
	private Date fdUpdatetime;
	/** 备注 */
	private String fdRemarks;
	/** 营业网点部门id */
	private Integer fdReporYywdDeptId;
	/**0，正常，1不正常*/
    private Integer fdReporDelFlag;
	/** 是否核实 0未核实，1已核实 */
	private String fdVerify;
	/** 是否喷洒，0未喷洒，1已喷洒 */
	private String fdSpray;
	/** 是否解除，0未解除，1已解除 */
	private String fdRelieve;
	private SprayingOperation sprayingOperation;//喷洒作业时间

	public SprayingOperation getSprayingOperation() {
		return sprayingOperation;
	}

	public void setSprayingOperation(SprayingOperation sprayingOperation) {
		this.sprayingOperation = sprayingOperation;
	}

	public String getFdVerify() {
		return fdVerify;
	}

	public void setFdVerify(String fdVerify) {
		this.fdVerify = fdVerify;
	}

	public String getFdSpray() {
		return fdSpray;
	}

	public void setFdSpray(String fdSpray) {
		this.fdSpray = fdSpray;
	}

	public String getFdRelieve() {
		return fdRelieve;
	}

	public void setFdRelieve(String fdRelieve) {
		this.fdRelieve = fdRelieve;
	}

	public Date getFdManualRelieveDatetime() {
		return fdManualRelieveDatetime;
	}

	public void setFdManualRelieveDatetime(Date fdManualRelieveDatetime) {
		this.fdManualRelieveDatetime = fdManualRelieveDatetime;
	}

	public Date getFdEstimateRelieveDatetime() {
		return fdEstimateRelieveDatetime;
	}

	public void setFdEstimateRelieveDatetime(Date fdEstimateRelieveDatetime) {
		this.fdEstimateRelieveDatetime = fdEstimateRelieveDatetime;
	}

	/** 手工解除时间 */
	private Date fdManualRelieveDatetime;
	/** 预计解除时间 */
	private Date fdEstimateRelieveDatetime;

	public Integer getFdReporDelFlag() {
		return fdReporDelFlag;
	}

	public void setFdReporDelFlag(Integer fdReporDelFlag) {
		this.fdReporDelFlag = fdReporDelFlag;
	}

	public Integer getFdReporYywdDeptId() {
		return fdReporYywdDeptId;
	}

	public void setFdReporYywdDeptId(Integer fdReporYywdDeptId) {
		this.fdReporYywdDeptId = fdReporYywdDeptId;
	}

	public void setFdReportId(Integer fdReportId)
	{
		this.fdReportId = fdReportId;
	}

	public Integer getFdReportId() 
	{
		return fdReportId;
	}


	public String getFdReporNum() {
		return fdReporNum;
	}

	public void setFdReporNum(String fdReporNum) {
		this.fdReporNum = fdReporNum;
	}

	public void setFdReporDatetime(Date fdReporDatetime)
	{
		this.fdReporDatetime = fdReporDatetime;
	}

	public Date getFdReporDatetime()
	{
		return fdReporDatetime;
	}
	public void setFdReporNo(Integer fdReporNo) 
	{
		this.fdReporNo = fdReporNo;
	}

	public Integer getFdReporNo() 
	{
		return fdReporNo;
	}
	public void setFdReporLicense(String fdReporLicense) 
	{
		this.fdReporLicense = fdReporLicense;
	}

	public String getFdReporLicense() 
	{
		return fdReporLicense;
	}
	public void setFdReporFz(String fdReporFz) 
	{
		this.fdReporFz = fdReporFz;
	}

	public String getFdReporFz() 
	{
		return fdReporFz;
	}
	public void setFdReporDz(String fdReporDz) 
	{
		this.fdReporDz = fdReporDz;
	}

	public String getFdReporDz() 
	{
		return fdReporDz;
	}
	public void setFdReporPl(Integer fdReporPl) 
	{
		this.fdReporPl = fdReporPl;
	}

	public Integer getFdReporPl() 
	{
		return fdReporPl;
	}
	public void setFdReporPDeptId(Integer fdReporPDeptId) 
	{
		this.fdReporPDeptId = fdReporPDeptId;
	}

	public Integer getFdReporPDeptId() 
	{
		return fdReporPDeptId;
	}
	public void setFdReporDeptId(Integer fdReporDeptId) 
	{
		this.fdReporDeptId = fdReporDeptId;
	}

	public Integer getFdReporDeptId() 
	{
		return fdReporDeptId;
	}
	public void setFdReporName(String fdReporName) 
	{
		this.fdReporName = fdReporName;
	}

	public String getFdReporName() 
	{
		return fdReporName;
	}
	public void setFdReporDjhd(String fdReporDjhd) 
	{
		this.fdReporDjhd = fdReporDjhd;
	}

	public String getFdReporDjhd() 
	{
		return fdReporDjhd;
	}
	public void setFdReporCount(String fdReporCount) 
	{
		this.fdReporCount = fdReporCount;
	}

	public String getFdReporCount() 
	{
		return fdReporCount;
	}
	public void setFdReporImpact(Integer fdReporImpact) 
	{
		this.fdReporImpact = fdReporImpact;
	}

	public Integer getFdReporImpact() 
	{
		return fdReporImpact;
	}
	public void setFdReporImage(String fdReporImage) 
	{
		this.fdReporImage = fdReporImage;
	}

	public String getFdReporImage() 
	{
		return fdReporImage;
	}
	public void setFdCreatetime(Date fdCreatetime)
	{
		this.fdCreatetime = fdCreatetime;
	}

	public Date getFdCreatetime()
	{
		return fdCreatetime;
	}
	public void setFdUpdatetime(Date fdUpdatetime)
	{
		this.fdUpdatetime = fdUpdatetime;
	}

	public Date getFdUpdatetime()
	{
		return fdUpdatetime;
	}
	public void setFdRemarks(String fdRemarks) 
	{
		this.fdRemarks = fdRemarks;
	}

	public String getFdRemarks() 
	{
		return fdRemarks;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fdReportId", getFdReportId())
            .append("fdRepor num",getFdReporNum())
            .append("fdReporDatetime", getFdReporDatetime())
            .append("fdReporNo", getFdReporNo())
            .append("fdReporLicense", getFdReporLicense())
            .append("fdReporFz", getFdReporFz())
            .append("fdReporDz", getFdReporDz())
            .append("fdReporPl", getFdReporPl())
            .append("fdReporPDeptId", getFdReporPDeptId())
            .append("fdReporDeptId", getFdReporDeptId())
            .append("fdReporName", getFdReporName())
            .append("fdReporDjhd", getFdReporDjhd())
            .append("fdReporCount", getFdReporCount())
            .append("fdReporImpact", getFdReporImpact())
            .append("fdReporImage", getFdReporImage())
            .append("fdCreatetime", getFdCreatetime())
            .append("fdUpdatetime", getFdUpdatetime())
            .append("fdRemarks", getFdRemarks())
            .toString();
    }
}
