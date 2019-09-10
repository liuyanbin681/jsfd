package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Supervise;
import com.ruoyi.system.service.ISuperviseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 督办事项 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/system/supervise")
public class SuperviseController extends BaseController
{
    private String prefix = "system/supervise";
	
	@Autowired
	private ISuperviseService superviseService;
	
	@RequiresPermissions("system:supervise:view")
	@GetMapping()
	public String supervise()
	{
	    return prefix + "/supervise";
	}
	
	/**
	 * 查询督办事项列表
	 */
	@RequiresPermissions("system:supervise:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Supervise supervise)
	{
		startPage();
        List<Supervise> list = superviseService.selectSuperviseList(supervise);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出督办事项列表
	 */
	@RequiresPermissions("system:supervise:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Supervise supervise)
    {
    	List<Supervise> list = superviseService.selectSuperviseList(supervise);
        ExcelUtil<Supervise> util = new ExcelUtil<Supervise>(Supervise.class);
        return util.exportExcel(list, "supervise");
    }
	
	/**
	 * 新增督办事项
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存督办事项
	 */
	@RequiresPermissions("system:supervise:add")
	@Log(title = "督办事项", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Supervise supervise)
	{		
		return toAjax(superviseService.insertSupervise(supervise));
	}

	/**
	 * 修改督办事项
	 */
	@GetMapping("/edit/{suId}")
	public String edit(@PathVariable("suId") Integer suId, ModelMap mmap)
	{
		Supervise supervise = superviseService.selectSuperviseById(suId);
		mmap.put("supervise", supervise);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存督办事项
	 */
	@RequiresPermissions("system:supervise:edit")
	@Log(title = "督办事项", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Supervise supervise)
	{		
		return toAjax(superviseService.updateSupervise(supervise));
	}
	
	/**
	 * 删除督办事项
	 */
	@RequiresPermissions("system:supervise:remove")
	@Log(title = "督办事项", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(superviseService.deleteSuperviseByIds(ids));
	}
	
}
