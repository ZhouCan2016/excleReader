package com.team3.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.common.biz.BaseBiz;
import com.team3.entity.CstCustomer;
import com.team3.entity.Orders;

public class ContrRptBiz extends BaseBiz {
	public List getList(String name){
		String sql="select o from CstCustomer o where 1=1";
		if(name!=null &&!name.equals("")){
			sql+="and o.custName like '%"+name+"%'";
		}
		List list=super.getCommonDAO().list(sql);
		return list;
	}
}
