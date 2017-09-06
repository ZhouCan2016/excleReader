package com.team3.biz;

import java.util.List;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.CstService;
import com.team3.entity.SalChance;

public class CstServiceBiz extends BaseBiz {

	public void getList(CstService item, PageResult pageResult) {
		String hql = "select o from CstService o where o.svrStatus='"+item.getSvrStatus()+"' ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getSvrCustName())) {
				hql += "and o.svrCustName like '%" + item.getSvrCustName()
						+ "%' ";
			}
			if (item.getSvrType()!=null&&!item.getSvrType().equals("-1")) {
				hql += "and o.svrType='"+item.getSvrType()+"' ";
			}
			
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}
	public List getListByYear(String year){
		String sql="";
		if(year==null||year.equals("-1")){
			sql="select o.svrType,count(o.svrType) from CstService o group by o.svrType";
		}else{
			sql="select o.svrType,count(o.svrType) from CstService o where o.svrCreateDate like '%"+year+"%' group by o.svrType";
		}
		List list=super.getCommonDAO().list(sql);		
		return list;		
	}
	public void add(CstService item){
		this.getCommonDAO().add(item);
	}
	public CstService get(long id){
		return (CstService) super.getCommonDAO().get(CstService.class, id);
	}
	public void del(long id){
		super.getCommonDAO().del(CstService.class, id);
	}
	public void update(CstService item){
		super.getCommonDAO().update(item);
	}
}
