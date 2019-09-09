package com.ruoyi.web.controller.Antifreeze;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SprayingOperation;
import com.ruoyi.system.domain.Sum;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISprayingOperationService;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyb
 * @date 2019-09-03
 */
@RestController
@RequestMapping("system/sum")
public class SumController extends BaseController {
    @Autowired
    private ISprayingOperationService iSprayingOperationService;//喷洒作业表
    @Autowired
    private ISysDeptService iSysDeptService;//部门表



    @PostMapping("sumAll")
    public TableDataInfo sumAll(SprayingOperation sprayingOperation){
        List<Sum>lists = new ArrayList<>();
       List<SprayingOperation> so = iSprayingOperationService.selectByTypeCarS();//喷洒作业情况
        List<SprayingOperation> 煤 = iSprayingOperationService.selectByCoalCars(1);//煤喷洒情况
        List<SprayingOperation> 矿粉 = iSprayingOperationService.selectByCoalCars(2);//矿粉喷洒情况
        for (SprayingOperation s :煤){
         for (SprayingOperation o:矿粉){
          Sum sum = new Sum();
          SysDept sysDept = iSysDeptService.selectDeptById(Long.valueOf(s.getSprayDeptPId()));
          SprayingOperation sprayingOperation1 = iSprayingOperationService.selectByVerify(s.getSprayDeptPId(), o.getSprayType());
          if (sprayingOperation1.getCount()==0){
           sum.setMpCount(0);
           sum.setName(sysDept.getDeptName());
           sum.setCoalCount(s.getCount());
           lists.add(sum);
          }else if (sprayingOperation1.getCount()!=0){
           sum.setName(sysDept.getDeptName());
           sum.setCoalCount(s.getCount());
           sum.setMpCount(o.getCount());
           lists.add(sum);
          }
         }

        }



        startPage();
        List<Sum>list = new ArrayList<>();
        Sum sum = new Sum();
        sum.setName("第一货运中心");
        sum.setCoalCount(5);
        sum.setCoalAntifreezeSum(400);
        sum.setMpCount(20);
        sum.setMpSum(500);
        sum.setFre(3);
        sum.setMpCSum(1500);
       Sum sum2 = new Sum();
        sum2.setName("第2货运中心");
        sum2.setCoalCount(5);
        sum2.setCoalAntifreezeSum(10);
        sum2.setFre(2);
        sum2.setMpSum(20);
        sum2.setMpCount(40);
        sum2.setMpCSum(1500);
        Sum sum3 = new Sum();
        sum3.setName("第3货运中心");
        sum3.setCoalCount(5);
        sum3.setCoalAntifreezeSum(10);
        sum3.setFre(2);
        sum3.setMpSum(20);
        sum3.setMpCount(40);
        sum3.setMpCSum(1500);
        Sum sum4 = new Sum();
        sum4.setName("第4货运中心");
        sum4.setCoalCount(5);
        sum4.setCoalAntifreezeSum(10);
        sum4.setFre(2);
        sum4.setMpSum(20);
        sum4.setMpCount(40);
        sum4.setMpCSum(1500);
        Sum sum5 = new Sum();
        sum5.setName("第5货运中心");
        sum5.setCoalCount(5);
        sum5.setCoalAntifreezeSum(10);
        sum5.setFre(2);
        sum5.setMpSum(20);
        sum5.setMpCount(40);
        sum5.setMpCSum(1500);
        Sum sum6 = new Sum();
        sum6.setName("第6货运中心");
        sum6.setCoalCount(5);
        sum6.setCoalAntifreezeSum(10);
        sum6.setFre(2);
        sum6.setMpSum(20);
        sum6.setMpCount(40);
        sum6.setMpCSum(1500);
        Sum sum7 = new Sum();
        sum7.setName("第7货运中心");
        sum7.setCoalCount(5);
        sum7.setCoalAntifreezeSum(10);
        sum7.setFre(2);
        sum7.setMpSum(20);
        sum7.setMpCount(40);
        sum7.setMpCSum(12000);
        list.add(sum);
        list.add(sum2);
        list.add(sum3);
        list.add(sum4);
        list.add(sum5);
        list.add(sum6);
        list.add(sum7);
        return getDataTable(lists);
    }
}
