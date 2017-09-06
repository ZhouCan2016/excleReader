package com.team3.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.common.biz.BaseBiz;
import com.team3.entity.CstCustomer;
import com.team3.entity.Orders;

public class OrdersBiz extends BaseBiz {

	public Double getPrice(String custName,String year){
		String sql="select o from Orders o where o.odrCustomer like '%"+custName+"%'  and o.odrStatus=6";
		if(year!=null&&!year.equals("-1")){
			sql+=" and o.odrDate like '%"+year+"%'";
		}
		List list=super.getCommonDAO().list(sql);
		Double allPrice=new Double(0);
		Iterator it=list.iterator();
		while(it.hasNext()){
			Orders orders=(Orders) it.next();
			allPrice+=orders.getTotal();
		}
		return allPrice;
	}
}
