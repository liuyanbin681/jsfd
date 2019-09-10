package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.CStock;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ICStockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 厂商销售库存 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-09
 */
@Controller
@RequestMapping("/system/cStock")
public class CStockController extends BaseController
{
    private String prefix = "system/cStock";
	
	@Autowired
	private ICStockService cStockService;
	
	@RequiresPermissions("system:cStock:view")
	@GetMapping()
	public String cStock()
	{
	    return prefix + "/cStock";
	}
	
	/**
	 * 查询厂商销售库存列表
	 */
	@RequiresPermissions("system:cStock:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CStock cStock)
	{
		startPage();
		Long deptId = ShiroUtils.getSysUser().getDeptId();//获取当前登陆人部门id
		List<SysRole> roles = ShiroUtils.getSysUser().getRoles();//获取当前登陆人角色id
		int role =0;
		for (SysRole d: roles
		) {
			role =d.getRoleId().intValue();
		}
		if (role==1){
			List<CStock> list = cStockService.selectCStockList(cStock);
			return getDataTable(list);
		}
		cStock.setStockUserDeptId(deptId.intValue());
        List<CStock> list = cStockService.selectCStockList(cStock);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出厂商销售库存列表
	 */
	@RequiresPermissions("system:cStock:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CStock cStock)
    {
    	List<CStock> list = cStockService.selectCStockList(cStock);
        ExcelUtil<CStock> util = new ExcelUtil<CStock>(CStock.class);
        return util.exportExcel(list, "cStock");
    }
	
	/**
	 * 新增厂商销售库存
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存厂商销售库存
	 */
	@RequiresPermissions("system:cStock:add")
	@Log(title = "厂商销售库存", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CStock cStock)
	{		
		return toAjax(cStockService.insertCStock(cStock));
	}

	/**
	 * 修改厂商销售库存
	 */
	@GetMapping("/edit/{stockId}")
	public String edit(@PathVariable("stockId") Integer stockId, ModelMap mmap)
	{
		CStock cStock = cStockService.selectCStockById(stockId);
		mmap.put("cStock", cStock);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存厂商销售库存
	 */
	@RequiresPermissions("system:cStock:edit")
	@Log(title = "厂商销售库存", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CStock cStock)
	{		
		return toAjax(cStockService.updateCStock(cStock));
	}
	
	/**
	 * 删除厂商销售库存
	 */
	@RequiresPermissions("system:cStock:remove")
	@Log(title = "厂商销售库存", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cStockService.deleteCStockByIds(ids));
	}
	
}
