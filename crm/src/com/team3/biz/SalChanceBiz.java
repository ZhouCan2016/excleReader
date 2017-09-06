package com.team3.biz;

import com.common.biz.BaseBiz;
import com.team3.entity.*;
import com.common.util.PageResult;
public class SalChanceBiz extends BaseBiz {
	public void getList(SalChance item, PageResult pageResult) {
		String hql = "select o from SalChance o where o.chcStatus='1' ";
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

	public void add(SalChance item) {
		long res= (Long) super.getCommonDAO().add(item);
		System.out.println(res);
	}

	public SalChance get(long id) {
		return (SalChance) super.getCommonDAO().getObj(SalChance.class, id);
	}

	public void update(SalChance item) {
		super.getCommonDAO().update(item);
	}

	public void del(long id) {
		super.getCommonDAO().del(SalChance.class, id);
	}
}
