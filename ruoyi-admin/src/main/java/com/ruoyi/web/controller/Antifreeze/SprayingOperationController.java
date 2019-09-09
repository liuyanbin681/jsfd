package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SprayingOperation;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.IFrozenCarReportService;
import com.ruoyi.system.service.ISprayingOperationService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 装车喷洒作业 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-16
 */
@Controller
@RequestMapping("/system/sprayingOperation")
public class SprayingOperationController extends BaseController
{
    private String prefix = "system/sprayingOperation";
	
	@Autowired
	private ISprayingOperationService sprayingOperationService;
	@Autowired
	private ISysDeptService iSysDeptService;//部门
	@Autowired
	private IFrozenCarReportService frozenCarReportService;//冻车信息
	@RequiresPermissions("system:sprayingOperation:view")
	@GetMapping()
	public String sprayingOperation()
	{
	    return prefix + "/sprayingOperation";
	}
	
	/**
	 * 查询装车喷洒作业列表
	 */
	@RequiresPermissions("system:sprayingOperation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SprayingOperation sprayingOperation)
	{
		startPage();
        List<SprayingOperation> list = sprayingOperationService.selectSprayingOperationList(sprayingOperation);
		return getDataTable(list);
	}
	/**
	 * 查询装车喷洒作业列表(发站核实专用)
	 */
	@PostMapping("/lists")
	@ResponseBody
	public TableDataInfo lists(SprayingOperation sprayingOperation) throws ParseException {
		startPage();
		if (StringUtils.isEmpty(sprayingOperation.getSprayDatetime())){
          sprayingOperation.setSprayCreatetime(new Date().toString());
			List<SprayingOperation> list = sprayingOperationService.selectSprayingOperationLists(sprayingOperation);
			return getDataTable(list);
		}else if (StringUtils.isNotEmpty(sprayingOperation.getSprayDatetime())){
			List<SprayingOperation> list = sprayingOperationService.selectSprayingOperationList(sprayingOperation);
			return getDataTable(list);
		}
		List<SprayingOperation> list = sprayingOperationService.selectSprayingOperationLists(sprayingOperation);
		return getDataTable(list);
	}
	/**
	 * 根据冻车id查询冻车数（喷洒作业）详情
	 */
	@GetMapping("/detail/{fdReportId}")
	public String spraying(@PathVariable(value = "fdReportId")String fdReportId,ModelMap map)
	{
		map.put("id",fdReportId);
		return "system/VerifyCarReport/Spraying";
	}

	/**
	 * 导出装车喷洒作业列表
	 */
	@RequiresPermissions("system:sprayingOperation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SprayingOperation sprayingOperation)
    {
    	List<SprayingOperation> list = sprayingOperationService.selectSprayingOperationList(sprayingOperation);
        ExcelUtil<SprayingOperation> util = new ExcelUtil<SprayingOperation>(SprayingOperation.class);
        return util.exportExcel(list, "sprayingOperation");
    }
	
	/**
	 * 新增装车喷洒作业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存装车喷洒作业
	 */
	@RequiresPermissions("system:sprayingOperation:add")
	@Log(title = "装车喷洒作业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SprayingOperation sprayingOperation)
	{
		String sprayLocation = sprayingOperation.getSprayLocation();//获取装车点
		SysDept dept = iSysDeptService.selectDeptByName(sprayLocation);//根据装车点名称拿到装车点id
		sprayingOperation.setSprayLocationId(dept.getDeptId().intValue());//装车点id
		SysDept dept1 = iSysDeptService.selectDeptById(dept.getParentId());//上级部门
		SysDept dept2 = iSysDeptService.selectDeptById(dept1.getParentId());//上级总部门
		SysDept dept3 = iSysDeptService.selectDeptById(dept2.getParentId().longValue());
		sprayingOperation.setSprayDeptId(dept2.getDeptId().intValue());//上级总部门
		sprayingOperation.setSprayDeptPId(dept3.getDeptId().intValue());//父id
		sprayingOperation.setSprayDeparture(ShiroUtils.getSysUser().getDept().getDeptName());//发站
		sprayingOperation.setSprayCreatename( ShiroUtils.getSysUser().getUserName());//创建人
		sprayingOperation.setSprayDcCount(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		sprayingOperation.setSprayCreatetime(format);

		return toAjax(sprayingOperationService.insertSprayingOperation(sprayingOperation));
	}

	/**
	 * 修改装车喷洒作业
	 */
	@GetMapping("/edit/{sprayId}")
	public String edit(@PathVariable("sprayId") Integer sprayId, ModelMap mmap)
	{
		SprayingOperation sprayingOperation = sprayingOperationService.selectSprayingOperationById(sprayId);
		mmap.put("sprayingOperation", sprayingOperation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存装车喷洒作业
	 */
	@RequiresPermissions("system:sprayingOperation:edit")
	@Log(title = "装车喷洒作业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SprayingOperation sprayingOperation)
	{		
		return toAjax(sprayingOperationService.updateSprayingOperation(sprayingOperation));
	}
	
	/**
	 * 删除装车喷洒作业
	 */
	@RequiresPermissions("system:sprayingOperation:remove")
	@Log(title = "装车喷洒作业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sprayingOperationService.deleteSprayingOperationByIds(ids));
	}
	
}
