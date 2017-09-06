package com.team3.biz;

import java.util.List;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.CstCustomer;
import com.team3.entity.SalChance;

public class CstCustomerBiz extends BaseBiz {
	public void getList(CstCustomer item, PageResult pageResult) {
		String hql = "select o from CstCustomer o where o.custStatus='1' ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getCustName())) {
				hql += "and o.custName like '%" + item.getCustName()
						+ "%' ";
			}
			
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}
	public List getListByType(String type){
		String sql="";
		if(type==null){
			sql="select o.custLevelLabel,count(o.custLevelLabel) from CstCustomer o group by o.custLevelLabel";
		}else if(type.equals("my")){
			sql="select o.custSatisfy,count(o.custSatisfy) from CstCustomer o group by o.custSatisfy";
		}else if(type.equals("xy")){
			sql="select o.custCredit,count(o.custCredit) from CstCustomer o group by o.custCredit";
		}else if(type.equals("dj")){
			sql="select o.custLevelLabel,count(o.custLevelLabel) from CstCustomer o group by o.custLevelLabel";
		}
		List list=super.getCommonDAO().list(sql);		
		return list;		
	}
	public CstCustomer getCstCustomerByName(String name){
		String sql="select o from CstCustomer o where o.custName='"+name+"'";
		List list=super.getCommonDAO().list(sql);
		if(list==null){
			return null;
		}else{
			CstCustomer customer=(CstCustomer) list.get(0);
			return customer;
		}
		
	}
	public CstCustomer get(String custNo){
		return (CstCustomer) this.getCommonDAO().get(CstCustomer.class, custNo);
	}
	public void update(CstCustomer item){
		this.getCommonDAO().update(item);
	}
}