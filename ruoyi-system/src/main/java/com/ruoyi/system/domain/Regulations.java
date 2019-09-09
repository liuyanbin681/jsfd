package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 规章文电表 Regulations
 * 
 * @author lyb
 * @date 2019-08-15
 */
public class Regulations extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 规章文电id */
	private Integer rulesId;
	/** 规章文电文件名称 */
	private String rulesFile;
	/** 规章文电创建时间 */
	private Date rulesCreatetime;
	/** 规章文电创建人 */
	private String rulesName;
	/** 规章文电备注 */
	private String rulesRemarks;
	/** 备用字段 */
	private String rulesSpare;
	/** 当前登陆人部门id */
	private Integer rulesDeptId;
	/** 当前登陆人角色id */
	private Integer rulesRoleId;
	/** 能看到的部门集合 */
	private String rulesDeptsIds;
	/** 当前登陆用户id */
	private Integer rulesUserId;
	/** 是否签收 0，未签收，1签收  */
	private String rulesStatus;
	/** 反馈结果 */
	private String rulesResults;

	public void setRulesId(Integer rulesId) 
	{
		this.rulesId = rulesId;
	}

	public Integer getRulesId() 
	{
		return rulesId;
	}
	public void setRulesFile(String rulesFile) 
	{
		this.rulesFile = rulesFile;
	}

	public String getRulesFile() 
	{
		return rulesFile;
	}
	public void setRulesCreatetime(Date rulesCreatetime)
	{
		this.rulesCreatetime = rulesCreatetime;
	}

	public Date getRulesCreatetime()
	{
		return rulesCreatetime;
	}
	public void setRulesName(String rulesName) 
	{
		this.rulesName = rulesName;
	}

	public String getRulesName() 
	{
		return rulesName;
	}
	public void setRulesRemarks(String rulesRemarks) 
	{
		this.rulesRemarks = rulesRemarks;
	}

	public String getRulesRemarks() 
	{
		return rulesRemarks;
	}
	public void setRulesSpare(String rulesSpare) 
	{
		this.rulesSpare = rulesSpare;
	}

	public String getRulesSpare() 
	{
		return rulesSpare;
	}
	public void setRulesDeptId(Integer rulesDeptId) 
	{
		this.rulesDeptId = rulesDeptId;
	}

	public Integer getRulesDeptId() 
	{
		return rulesDeptId;
	}
	public void setRulesRoleId(Integer rulesRoleId) 
	{
		this.rulesRoleId = rulesRoleId;
	}

	public Integer getRulesRoleId() 
	{
		return rulesRoleId;
	}
	public void setRulesDeptsIds(String rulesDeptsIds) 
	{
		this.rulesDeptsIds = rulesDeptsIds;
	}

	public String getRulesDeptsIds() 
	{
		return rulesDeptsIds;
	}
	public void setRulesUserId(Integer rulesUserId) 
	{
		this.rulesUserId = rulesUserId;
	}

	public Integer getRulesUserId() 
	{
		return rulesUserId;
	}
	public void setRulesStatus(String rulesStatus) 
	{
		this.rulesStatus = rulesStatus;
	}

	public String getRulesStatus() 
	{
		return rulesStatus;
	}
	public void setRulesResults(String rulesResults) 
	{
		this.rulesResults = rulesResults;
	}

	public String getRulesResults() 
	{
		return rulesResults;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rulesId", getRulesId())
            .append("rulesFile", getRulesFile())
            .append("rulesCreatetime", getRulesCreatetime())
            .append("rulesName", getRulesName())
            .append("rulesRemarks", getRulesRemarks())
            .append("rulesSpare", getRulesSpare())
            .append("rulesDeptId", getRulesDeptId())
            .append("rulesRoleId", getRulesRoleId())
            .append("rulesDeptsIds", getRulesDeptsIds())
            .append("rulesUserId", getRulesUserId())
            .append("rulesStatus", getRulesStatus())
            .append("rulesResults", getRulesResults())
            .toString();
    }
}
