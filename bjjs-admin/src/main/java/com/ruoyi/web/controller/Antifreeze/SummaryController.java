package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Summary;
import com.ruoyi.system.service.ISummaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 总结上报 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/system/summary")
public class SummaryController extends BaseController
{
    private String prefix = "system/summary";
	private static String FileUrl ="";//文件路径
	@Autowired
	private ISummaryService summaryService;
	
	@RequiresPermissions("system:summary:view")
	@GetMapping()
	public String summary()
	{
	    return prefix + "/summary";
	}
	
	/**
	 * 查询总结上报列表
	 */
	@RequiresPermissions("system:summary:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Summary summary)
	{
		startPage();
        List<Summary> list = summaryService.selectSummaryList(summary);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出总结上报列表
	 */
	@RequiresPermissions("system:summary:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Summary summary)
    {
    	List<Summary> list = summaryService.selectSummaryList(summary);
        ExcelUtil<Summary> util = new ExcelUtil<Summary>(Summary.class);
        return util.exportExcel(list, "summary");
    }
	
	/**
	 * 新增总结上报
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存总结上报
	 */
	@RequiresPermissions("system:summary:add")
	@Log(title = "总结上报", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Summary summary)
	{		
		summary.setSummaryFile(FileUrl);//总结上报文件名称
		summary.setStatus(0);
		summary.setSummaryCreateTime(new Date());
		summary.setSummaryCreateDept(ShiroUtils.getSysUser().getDept().getDeptName());//创建人部门
		summary.setSummaryDeptId(ShiroUtils.getSysUser().getDept().getDeptId().intValue());//创建人部门id
		summary.setSummaryCreatename(ShiroUtils.getLoginName());
		return toAjax(summaryService.insertSummary(summary));
	}

	/**
	 * 修改总结上报
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String sId, ModelMap mmap)
	{
		Summary summary = summaryService.selectSummaryById(Integer.parseInt(sId));
		mmap.put("summary", summary);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存总结上报
	 */
	@RequiresPermissions("system:summary:edit")
	@Log(title = "总结上报", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Summary summary)
	{		
		return toAjax(summaryService.updateSummary(summary));
	}
	
	/**
	 * 删除总结上报
	 */
	@RequiresPermissions("system:summary:remove")
	@Log(title = "总结上报", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(summaryService.deleteSummaryByIds(ids));
	}

	/**
	 * 总结上报上传
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public AjaxResult upload(@RequestParam("zzFilename") MultipartFile file) {
		logger.info("方法进入");
		if (file.isEmpty()) {
			return error("上传失败");
		}
		String uploadPath = Global.getUploadPath();
		System.out.println("目前路径"+uploadPath);
		try {
			String upload = FileUploadUtils.upload(uploadPath, file);
			FileUrl=upload;
			return success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return error("上传失败");
	}
}
