package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.QualificationAudit;
import com.ruoyi.system.service.IQualificationAuditService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


/**
 * 资质审核 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-14
 */
@Controller
@RequestMapping("/system/qualificationAudit")
public class QualificationAuditController extends BaseController
{
    private String prefix = "system/qualificationAudit";

    private  String url ="";
	@Autowired
	private IQualificationAuditService qualificationAuditService;
	
	@RequiresPermissions("system:qualificationAudit:view")
	@GetMapping()
	public String qualificationAudit()
	{
	    return prefix + "/qualificationAudit";
	}
	
	/**
	 * 查询资质审核列表
	 */
	@RequiresPermissions("system:qualificationAudit:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(QualificationAudit qualificationAudit)
	{
		startPage();
        List<QualificationAudit> list = qualificationAuditService.selectQualificationAuditList(qualificationAudit);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资质审核列表
	 */
	@RequiresPermissions("system:qualificationAudit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QualificationAudit qualificationAudit)
    {
    	List<QualificationAudit> list = qualificationAuditService.selectQualificationAuditList(qualificationAudit);
        ExcelUtil<QualificationAudit> util = new ExcelUtil<QualificationAudit>(QualificationAudit.class);
        return util.exportExcel(list, "qualificationAudit");
    }
	
	/**
	 * 新增资质审核
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	public static String FileUrl = "";
	/**
	 * 新增保存资质审核
	 */
	@RequiresPermissions("system:qualificationAudit:add")
	@Log(title = "资质审核", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(QualificationAudit qualificationAudit)
	{
		qualificationAudit.setZzFilename(FileUrl);
	    qualificationAudit.setZzUserId(ShiroUtils.getSysUser().getUserId().intValue());
	    qualificationAudit.setZzDeptId(ShiroUtils.getSysUser().getDeptId().intValue());
		qualificationAudit.setZzCreatetime(new Date());
		return toAjax(qualificationAuditService.insertQualificationAudit(qualificationAudit));
	}


	/**
	 * 修改资质审核
	 */
	@GetMapping("/edit/{zzId}")
	public String edit(@PathVariable("zzId") Integer zzId, ModelMap mmap)
	{
		QualificationAudit qualificationAudit = qualificationAuditService.selectQualificationAuditById(zzId);
		mmap.put("qualificationAudit", qualificationAudit);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资质审核
	 */
	@RequiresPermissions("system:qualificationAudit:edit")
	@Log(title = "资质审核", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(QualificationAudit qualificationAudit)
	{		
		return toAjax(qualificationAuditService.updateQualificationAudit(qualificationAudit));
	}
	
	/**
	 * 删除资质审核
	 */
	@RequiresPermissions("system:qualificationAudit:remove")
	@Log(title = "资质审核", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(qualificationAuditService.deleteQualificationAuditByIds(ids));
	}

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
			System.out.println(upload);
			return success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return error("上传失败");
	}
	/**
	 * 通用下载请求
	 *
	 * @param fileName 文件名称
	 * @param delete 是否删除
	 */
	@GetMapping("common/download")
	@SuppressWarnings("all")
	public void fileDownload( String zzId, Boolean delete, HttpServletResponse response, HttpServletRequest request)
	{
		String[] split = zzId.split("/");
		String fileName ="";
		String url="";
		for (int i=0;i<split.length;i++){
			System.out.println(split[i]);
			url=split[0]+"/"+split[1]+"/"+split[2]+"/";
			fileName=split[3];

		}
		try
		{
			if (!FileUtils.isValidFilename(fileName))
			{
				throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
			}
			String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
			String filePath = Global.getUploadPath()+url + fileName;

			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
			FileUtils.writeBytes(filePath, response.getOutputStream());
			if (delete)
			{
				FileUtils.deleteFile(filePath);
			}
		}
		catch (Exception e)
		{
			logger.error("下载文件失败", e);
		}
	}

	
}
