package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.lyb.AntifreezeType;
import com.ruoyi.common.utils.lyb.publicUtils;
import com.ruoyi.system.domain.CDetailed;
import com.ruoyi.system.domain.CStock;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.CDetailedMapper;
import com.ruoyi.system.mapper.CStockMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.ICDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 厂商明细 服务层实现
 * 
 * @author lyb
 * @date 2019-08-08
 */
@Service
public class CDetailedServiceImpl implements ICDetailedService
{
	 @Autowired
	 private CDetailedMapper cDetailedMapper;
     @Autowired
	 private SysDeptMapper sysDeptMapper;//部门信息
	 @Autowired
     private CStockMapper cStockMapper;//供货统计表
	/**
     * 查询厂商明细信息
     * 
     * @param cjId 厂商明细ID
     * @return 厂商明细信息
     */
    @Override
	public CDetailed selectCDetailedById(Integer cjId)
	{
	    return cDetailedMapper.selectCDetailedById(cjId);
	}
	
	/**
     * 查询厂商明细列表
     * 
     * @param cDetailed 厂商明细信息
     * @return 厂商明细集合
     */
	@Override
	public List<CDetailed> selectCDetailedList(CDetailed cDetailed)
	{
	    return cDetailedMapper.selectCDetailedList(cDetailed);
	}
	
    /**
     * 新增厂商明细
     * 
     * @param cDetailed 厂商明细信息
     * @return 结果
     */
	@Override
	public int insertCDetailed(CDetailed cDetailed)
	{
		if (Integer.parseInt(cDetailed.getCjType())==AntifreezeType.Antifreeze_p.getValue()) {
			Integer cs = cDetailed.getCjShipment();
			double v = cs * 2.3;
			cDetailed.setCjShipment((int) v);//防冻粉数量
			//cDetailed.setCjConversionAp((int)v);//转化后的防冻液
		}
		SysDept sysDept = sysDeptMapper.selectDeptByName(cDetailed.getCjPalce());//拿到部门对象
		cDetailed.setCjPalceId(sysDept.getDeptId().intValue());//获取装车点部门id
		SysDept sysDept1 = sysDeptMapper.selectDeptById(sysDept.getParentId());//拿到营业点
		cDetailed.setCjYywd(sysDept1.getDeptName());
		SysDept sysDept2 = sysDeptMapper.selectDeptById(sysDept1.getParentId());//拿到营业部
		cDetailed.setCjYydept(sysDept2.getDeptName());
		SysDept sysDept3 = sysDeptMapper.selectDeptById(sysDept2.getParentId());//拿到货运中心
		cDetailed.setCjDept(sysDept3.getDeptName());
		/***************以下是添加供货统计表*******************/
		int i = cStockMapper.selectsBySPalceId(cDetailed.getCjPalceId());//查询供货统计表是否存在数据
		CStock cs= new CStock();//创建流水统计表
		if (i==0){
			cs.setStockCreate(cDetailed.getCjCreate());//创建人
			cs.setStockCreatetime(new Date());//创建时间
			cs.setStockHyzxDept(sysDept3.getDeptName());//货运中心
			cs.setStockYybDept(sysDept2.getDeptName());//营业部门
			cs.setStockYywdDept(sysDept1.getDeptName());//营业网点
			cs.setStockPalce(cDetailed.getCjPalce());//装车点
			cs.setStockPalceId(cDetailed.getCjPalceId());//装车点id
			cs.setStockSurplus(cDetailed.getCjShipment());//库存
			cs.setStockUserDeptId(cDetailed.getCjUserDeptId());//当前操作人部门id
			cStockMapper.insertCStock(cs);
		}else if (i!=0){
			CStock cStock = cStockMapper.selectsByStockPalceId(cDetailed.getCjPalceId());//查询是否有装车点记录
			CStock stock = new CStock();
			Integer stockSurplus =cStock.getStockSurplus();
			stock.setStockPalceId(cStock.getStockPalceId());
			stock.setStockSurplus(publicUtils.defaultValue(stockSurplus)+publicUtils.defaultValue(cDetailed.getCjShipment()));//库存
			cStockMapper.updateByPalceId(stock);
		}
	    return 	cDetailedMapper.insertCDetailed(cDetailed);
	}
	
	/**
     * 修改厂商明细
     * 
     * @param cDetailed 厂商明细信息
     * @return 结果
     */
	@Override
	public int updateCDetailed(CDetailed cDetailed)
	{
	    return cDetailedMapper.updateCDetailed(cDetailed);
	}

	/**
     * 删除厂商明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCDetailedByIds(String ids)
	{
		CDetailed cDetailed = cDetailedMapper.selectCDetailedById(Integer.parseInt(ids));//根据供货明细进行查询
		CStock cs =new CStock();
		CStock stock = cStockMapper.selectsByStockPalceId(cDetailed.getCjPalceId());//拿到当前要修改的装车点对象
		int Surplus= publicUtils.defaultValue(stock.getStockSurplus());//拿到汇总表出货量
		cs.setStockPalceId(cDetailed.getCjPalceId());//拿到装车点id
		cs.setStockSurplus(Surplus-publicUtils.defaultValue(cDetailed.getCjShipment()));//拿到出货量
		cStockMapper.updateByPalceId(cs);
		return cDetailedMapper.deleteCDetailedByIds(Convert.toStrArray(ids));
	}
	
}
