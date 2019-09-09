package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.OperatorType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.FrozenCarReport;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 到站冻车上报 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-17
 */
@Controller
@RequestMapping("/system/frozenCarReport")
public class FrozenCarReportController extends BaseController
{
    private String prefix = "system/frozenCarReport";//冻车上报
    private String Verify = "system/VerifyCarReport";//冻车上报

	/**
	 * 文件上传路径
	 */
	public static final String UPLOAD_PATH = "/profile/upload/";
    public static String imgUrl="";//图片路径
	@Autowired
	private ServerConfig serverConfig;
	@Autowired
	private IFrozenCarReportService frozenCarReportService;//冻车信息
	@Autowired
	private ISprayingOperationService iSprayingOperationService;//喷洒信息
	@Autowired
	private ISysDeptService iSysDeptService;//部门
	@RequiresPermissions("system:frozenCarReport:view")
	@GetMapping()
	public String frozenCarReport()
	{
	    return prefix + "/frozenCarReport";
	}

	@RequiresPermissions("system:VerifyCarReport:view")
	@GetMapping("Verify")
	public String VerifyCarReport()
	{
		return Verify + "/VerifyCarReport";
	}
	/**
	 * 查询到站冻车上报列表
	 */
	@RequiresPermissions("system:frozenCarReport:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FrozenCarReport frozenCarReport)
	{
		startPage();
        List<FrozenCarReport> list = frozenCarReportService.selectFrozenCarReportList(frozenCarReport);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出到站冻车上报列表
	 */
	@RequiresPermissions("system:frozenCarReport:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FrozenCarReport frozenCarReport)
    {
    	List<FrozenCarReport> list = frozenCarReportService.selectFrozenCarReportList(frozenCarReport);
        ExcelUtil<FrozenCarReport> util = new ExcelUtil<FrozenCarReport>(FrozenCarReport.class);
        return util.exportExcel(list, "frozenCarReport");
    }
	
	/**
	 * 新增到站冻车上报
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存到站冻车上报
	 */
	@RequiresPermissions("system:frozenCarReport:add")
	@Log(title = "到站冻车上报", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FrozenCarReport frozenCarReport)
	{
		Long deptId = ShiroUtils.getSysUser().getDeptId();//获取当前登陆人部门，此接口只有营业点进行操作，营业点查看自己营业点数据，营业部查看营业部以下数据，货运中心查看本货运中心以下数据,查询的时候按角色分配数据权限。
		frozenCarReport.setFdReporYywdDeptId(ShiroUtils.getSysUser().getDeptId().intValue());//当前登陆营业点部门id
		SysDept dept = iSysDeptService.selectDeptById(deptId);//找到当前登陆部门基本信息，返回对象。
		SysDept dept1 = iSysDeptService.selectDeptById(dept.getParentId());//找到上级部门（营业部）
		SysDept dept2 = iSysDeptService.selectDeptById(dept1.getParentId());//找到父部门（货运中心）
		frozenCarReport.setFdReporDeptId(dept1.getDeptId().intValue());//营业部
		frozenCarReport.setFdReporPDeptId(dept2.getDeptId().intValue());//货运中心
		frozenCarReport.setFdReporDz(ShiroUtils.getSysUser().getDept().getDeptName());//到站
		frozenCarReport.setFdReporDelFlag(0);
		return toAjax(frozenCarReportService.insertFrozenCarReport(frozenCarReport));
	}

	/**
	 * 修改到站冻车上报
	 */
	@GetMapping("/edit/{fdReportId}")
	public String edit(@PathVariable("fdReportId") Integer fdReportId, ModelMap mmap)
	{
		FrozenCarReport frozenCarReport = frozenCarReportService.selectFrozenCarReportById(fdReportId);
		mmap.put("frozenCarReport", frozenCarReport);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存到站冻车上报
	 */
	@RequiresPermissions("system:frozenCarReport:edit")
	@Log(title = "到站冻车上报", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FrozenCarReport frozenCarReport)
	{
		frozenCarReport.setFdReporImage(imgUrl);
		frozenCarReport.setFdUpdatetime(new Date());
		return toAjax(frozenCarReportService.updateFrozenCarReport(frozenCarReport));
	}
	
	/**
	 * 删除到站冻车上报
	 */
	@RequiresPermissions("system:frozenCarReport:remove")
	@Log(title = "到站冻车上报", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(frozenCarReportService.deleteFrozenCarReportByIds(ids));
	}


	/**
	 * 通用上传请求
	 */
	@PostMapping("/common/upload")
	@ResponseBody
	@SuppressWarnings("all")
	public AjaxResult uploadFile(@RequestParam(value ="fdReporImage") MultipartFile file) throws Exception
	{
		try
		{
			// 上传文件路径
			String filePath = Global.getAvatarPath();
			// 上传并返回新文件名称
			String fileName = FileUploadUtils.upload(filePath, file);
			String url = serverConfig.getUrl()+fileName;
			imgUrl=url;
			AjaxResult ajax = AjaxResult.success();
			ajax.put("fileName", fileName);
			ajax.put("url", url);
			return ajax;
		}
		catch (Exception e)
		{
			return AjaxResult.error(e.getMessage());
		}
	}
	@PostMapping("Relieve")
	@ResponseBody
	@RequiresPermissions("system:frozenCarReport:relieve")
	@Log(title = "解除冻车",businessType = BusinessType.UPDATE,operatorType= OperatorType.MANAGE)
	public AjaxResult Relieve(@RequestParam(value = "ids") String id){
		FrozenCarReport frozenCarReport = new FrozenCarReport();
		frozenCarReport.setFdReportId(Integer.parseInt(id));
		frozenCarReport.setFdReporDelFlag(1);//修改值，不做删除。
		frozenCarReport.setFdManualRelieveDatetime(new Date());//手工解除时间
		frozenCarReport.setFdRelieve("0");
		frozenCarReport.setFdSpray("0");
		frozenCarReport.setFdVerify("2");
		return toAjax(frozenCarReportService.updateFrozenCarReport(frozenCarReport));
	}
	/**
	 * 修改保存到站冻车上报
	 */
	@Log(title = "修改到站核实冻车", businessType = BusinessType.UPDATE)
	@PostMapping("/AutoEdit")
	@ResponseBody
	public AjaxResult AutoEditSave(FrozenCarReport frozenCarReport)
	{
	      frozenCarReport.setFdRelieve("0");
		return toAjax(frozenCarReportService.updateFrozenCarReport(frozenCarReport));
	}
	/******************************************冻车核实************************************************/

	/**
	 * 查询冻车核实列表
	 */
	@RequiresPermissions("system:VerifyCarReport:list")
	@PostMapping("/VerifyList")
	@ResponseBody
	public TableDataInfo VerifyList(FrozenCarReport frozenCarReport)
	{
		startPage();
		List<FrozenCarReport> list = frozenCarReportService.selectVerifyCarReportList(frozenCarReport);
		return getDataTable(list);
	}
	/**
	 * 查询(喷洒)冻车核实列表
	 */
	@PostMapping("/VerifyLists")
	@ResponseBody
	public TableDataInfo VerifyLists(String fdReportId)
	{
		startPage();
		//List<FrozenCarReport> list = frozenCarReportService.selectFrozenCarReportListById(Integer.parseInt(fdReportId));
		List<FrozenCarReport> sprayingOperations = frozenCarReportService.selectBySprayingOperationCounts(Integer.parseInt(fdReportId));
		for (FrozenCarReport fc:sprayingOperations){
			System.out.println(fc.getFdReporDz());
		}
		return getDataTable(sprayingOperations);
	}
	/**
	 * 修改保存未喷洒信息
	 */
	@Log(title = "修改到站核实冻车未喷洒", businessType = BusinessType.UPDATE)
	@PostMapping("/AutoEditSave")
	@ResponseBody
	public AjaxResult AutoEdit(FrozenCarReport frozenCarReport)
	{
		logger.info("核实冻车未喷洒信息");
		frozenCarReport.setFdVerify("1");//未喷洒 已核实状态
		return toAjax(frozenCarReportService.updateFrozenCarReport(frozenCarReport));
	}
	/**
	 * 修改保存已喷洒信息
	 */
	@Log(title = "修改到站核实冻车已喷洒", businessType = BusinessType.UPDATE)
	@PostMapping("/SprayedEditSave")
	@ResponseBody
	public AjaxResult Sprayed(String fdReportId, String sprayId)
	{
		logger.info("获取的值"+fdReportId+"---"+sprayId);
		SprayingOperation sprayingOperation = iSprayingOperationService.selectSprayingOperationById(Integer.parseInt(sprayId));//查询出喷洒信息
		SprayingOperation so= new SprayingOperation();//装车喷洒对象
	     so.setSprayId(Integer.parseInt(sprayId));//喷洒作业id
	     so.setFreezerId(Integer.parseInt(fdReportId));//冻车id
		Integer sprayDcCount = sprayingOperation.getSprayDcCount();
		so.setSprayDcCount(sprayDcCount+1);
		iSprayingOperationService.updateSprayingOperation(so);//冻车核实对象
		FrozenCarReport frozenCarReport = new FrozenCarReport();
		logger.info("核实冻车已喷洒信息");
		frozenCarReport.setFdVerify("1");//已核实
		frozenCarReport.setFdSpray("1");//已喷洒
		frozenCarReport.setFdRelieve("0");//已解除
		frozenCarReport.setFdReportId(Integer.parseInt(fdReportId));
		return toAjax(frozenCarReportService.updateFrozenCarReport(frozenCarReport));
	}
	/**
	 * 喷洒view
	 * @return
	 */
	@GetMapping("VerifyEdit")
	@Log(title = "冻车核实情况")
	public String VerifyEdit(@RequestParam(value = "id")Integer id,ModelMap map){
        map.put("id",id);
		return "/system/VerifyCarReport/verify2";
	}

}
