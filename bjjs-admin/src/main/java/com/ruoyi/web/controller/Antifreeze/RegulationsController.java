package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Regulations;
import com.ruoyi.system.service.IRegulationsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 规章文电 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/system/regulations")
public class RegulationsController extends BaseController
{
    private String prefix = "system/regulations";
	
	@Autowired
	private IRegulationsService regulationsService;
	
	@RequiresPermissions("system:regulations:view")
	@GetMapping()
	public String regulations()
	{
	    return prefix + "/regulations";
	}
	
	/**
	 * 查询规章文电列表
	 */
	@RequiresPermissions("system:regulations:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Regulations regulations)
	{
		startPage();
        List<Regulations> list = regulationsService.selectRegulationsList(regulations);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出规章文电列表
	 */
	@RequiresPermissions("system:regulations:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Regulations regulations)
    {
    	List<Regulations> list = regulationsService.selectRegulationsList(regulations);
        ExcelUtil<Regulations> util = new ExcelUtil<Regulations>(Regulations.class);
        return util.exportExcel(list, "regulations");
    }
	
	/**
	 * 新增规章文电
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存规章文电
	 */
	@RequiresPermissions("system:regulations:add")
	@Log(title = "规章文电", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Regulations regulations)
	{		
		return toAjax(regulationsService.insertRegulations(regulations));
	}

	/**
	 * 修改规章文电
	 */
	@GetMapping("/edit/{rulesId}")
	public String edit(@PathVariable("rulesId") Integer rulesId, ModelMap mmap)
	{
		Regulations regulations = regulationsService.selectRegulationsById(rulesId);
		mmap.put("regulations", regulations);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存规章文电
	 */
	@RequiresPermissions("system:regulations:edit")
	@Log(title = "规章文电", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Regulations regulations)
	{		
		return toAjax(regulationsService.updateRegulations(regulations));
	}
	
	/**
	 * 删除规章文电
	 */
	@RequiresPermissions("system:regulations:remove")
	@Log(title = "规章文电", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(regulationsService.deleteRegulationsByIds(ids));
	}
	
}
