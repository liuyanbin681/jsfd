package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.CDetailed;
import com.ruoyi.system.domain.CStock;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ICDetailedService;
import com.ruoyi.system.service.ICStockService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 厂商明细 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/system/cDetailed")
public class CDetailedController extends BaseController
{
    private String prefix = "system/cDetailed";
	
	@Autowired
	private ICDetailedService cDetailedService;//供货明细
	@Autowired
	private ISysDeptService iSysDeptService;//部门
	@Autowired
	private ICStockService icStockService;//供货统计表
	
	@RequiresPermissions("system:cDetailed:view")
	@GetMapping()
	public String cDetailed(ModelMap map)
	{
		Long deptId = ShiroUtils.getSysUser().getDeptId();
		map.put("deptId",deptId);
		return prefix + "/cDetailed";
	}
	
	/**
	 * 查询厂商明细列表
	 */
	@RequiresPermissions("system:cDetailed:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CDetailed cDetailed)
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
			List<CDetailed> list = cDetailedService.selectCDetailedList(cDetailed);
			return getDataTable(list);
		}
		cDetailed.setCjUserDeptId(deptId.intValue());

        List<CDetailed> list = cDetailedService.selectCDetailedList(cDetailed);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出厂商明细列表
	 */
	@RequiresPermissions("system:cDetailed:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CDetailed cDetailed)
    {
    	List<CDetailed> list = cDetailedService.selectCDetailedList(cDetailed);
        ExcelUtil<CDetailed> util = new ExcelUtil<CDetailed>(CDetailed.class);
        return util.exportExcel(list, "cDetailed");
    }
	
	/**
	 * 新增厂商明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存厂商明细
	 */
	@RequiresPermissions("system:cDetailed:add")
	@Log(title = "厂商明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	@RepeatSubmit()
	public AjaxResult addSave(CDetailed cDetailed)
	{
		cDetailed.setCjCreate(ShiroUtils.getSysUser().getUserName());//获取当前登陆人姓名
		cDetailed.setCjUserDeptId(ShiroUtils.getSysUser().getDeptId().intValue());//获取当前登陆部门
		return toAjax(cDetailedService.insertCDetailed(cDetailed));
	}

	/**
	 * 修改厂商明细
	 */
	@GetMapping("/edit/{cjId}")
	public String edit(@PathVariable("cjId") Integer cjId, ModelMap mmap)
	{
		CDetailed cDetailed = cDetailedService.selectCDetailedById(cjId);
		mmap.put("cDetailed", cDetailed);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存厂商明细
	 */
	@RequiresPermissions("system:cDetailed:edit")
	@Log(title = "厂商明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	@SuppressWarnings("all")
	public AjaxResult editSave(CDetailed cDetailed)
	{
		CDetailed cDetailed1 = cDetailedService.selectCDetailedById(cDetailed.getCjId());
		CStock stock = icStockService.selectsByStockPalceId(cDetailed1.getCjPalceId());//拿到汇总表装车点id
		if (Integer.parseInt(cDetailed.getCjType())==0){ //状态为0为增加防冻液
			    cDetailed.setCjType("");
			    CStock sk =new CStock();
				Integer cj = cDetailed.getCjShipment();//获取当前出货量
				double v = cj * 2.3;
				sk.setStockId(stock.getStockId());
				sk.setStockSurplus(stock.getStockSurplus()+(int)v);//统计防冻液总量
				int i = cDetailed1.getCjShipment() + (int)v;//出货量总和
				cDetailed.setCjShipment(i);//添加销售明细总量
				icStockService.updateCStock(sk);
		}else if (Integer.parseInt(cDetailed.getCjType())==1){//状态为1减少防冻液 1也代表防冻粉
				Integer cjShipment = cDetailed.getCjShipment();//获取当前输入出货量
			    cDetailed.setCjType("");
				CStock sk =new CStock();
				Integer cj = cDetailed.getCjShipment();//获取当前出货量
				double v = cj * 2.3;
				sk.setStockId(stock.getStockId());
				sk.setStockSurplus(stock.getStockSurplus()-(int)v);//统计防冻液总量
				int i = cDetailed1.getCjShipment()-(int)v;//出货量相减
				cDetailed.setCjShipment(i);
				icStockService.updateCStock(sk);
		}
		return toAjax(cDetailedService.updateCDetailed(cDetailed));
	}
	
	/**
	 * 删除厂商明细
	 */
	@RequiresPermissions("system:cDetailed:remove")
	@Log(title = "厂商明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cDetailedService.deleteCDetailedByIds(ids));
	}
	
}
