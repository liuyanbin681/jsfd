package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Train;
import com.ruoyi.system.service.ITrainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 培训课件 信息操作处理
 * 
 * @author lyb
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/system/train")
public class TrainController extends BaseController
{
    private String prefix = "system/train";
	
	@Autowired
	private ITrainService trainService;
	
	@RequiresPermissions("system:train:view")
	@GetMapping()
	public String train()
	{
	    return prefix + "/train";
	}
	
	/**
	 * 查询培训课件列表
	 */
	@RequiresPermissions("system:train:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Train train)
	{
		startPage();
        List<Train> list = trainService.selectTrainList(train);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出培训课件列表
	 */
	@RequiresPermissions("system:train:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Train train)
    {
    	List<Train> list = trainService.selectTrainList(train);
        ExcelUtil<Train> util = new ExcelUtil<Train>(Train.class);
        return util.exportExcel(list, "train");
    }
	
	/**
	 * 新增培训课件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训课件
	 */
	@RequiresPermissions("system:train:add")
	@Log(title = "培训课件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Train train)
	{		
		return toAjax(trainService.insertTrain(train));
	}

	/**
	 * 修改培训课件
	 */
	@GetMapping("/edit/{trainId}")
	public String edit(@PathVariable("trainId") Integer trainId, ModelMap mmap)
	{
		Train train = trainService.selectTrainById(trainId);
		mmap.put("train", train);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训课件
	 */
	@RequiresPermissions("system:train:edit")
	@Log(title = "培训课件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Train train)
	{		
		return toAjax(trainService.updateTrain(train));
	}
	
	/**
	 * 删除培训课件
	 */
	@RequiresPermissions("system:train:remove")
	@Log(title = "培训课件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(trainService.deleteTrainByIds(ids));
	}
	
}
