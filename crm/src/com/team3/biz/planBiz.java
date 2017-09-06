package com.team3.biz;

import java.util.List;

import com.common.biz.BaseBiz;
import com.team3.entity.*;
import com.common.util.PageResult;
public class planBiz extends BaseBiz {
	public void getList(SalChance item, PageResult pageResult) {
		String hql = "select o from SalChance o where (o.chcStatus='2' or o.chcStatus='4') ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getChcCustName())) {
				hql += "and o.chcCustName like '%" + item.getChcCustName()
						+ "%' ";
			}
			if (isNotNullOrEmpty(item.getChcTitle())) {
				hql += "and o.chcTitle like '%" + item.getChcTitle() + "%' ";
			}
			if (isNotNullOrEmpty(item.getChcLinkman())) {
				hql += "and o.chcLinkman like '%" + item.getChcLinkman()
						+ "%' ";
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}

	public List getListBySalChance(Long id){
		String sql="select o from SalPlan o where o.salChance.chcId="+id;
		return this.getCommonDAO().list(sql);	
	}
	public void add(SalPlan item) {
		long res= (Long) super.getCommonDAO().add(item);
	}

	public SalChance get(long id) {
		return (SalChance) super.getCommonDAO().getObj(SalChance.class, id);
	}
	public SalPlan getPlan(long id){
		return (SalPlan) super.getCommonDAO().getObj(SalPlan.class, id);
	}
	public void update(SalChance item) {
		super.getCommonDAO().update(item);
	}
	
	public void updatePlan(SalPlan item) {
		super.getCommonDAO().update(item);
	}

	public void del(long id) {
		super.getCommonDAO().del(SalPlan.class, id);
	}
}
