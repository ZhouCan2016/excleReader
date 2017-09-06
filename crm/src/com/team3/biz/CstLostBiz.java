package com.team3.biz;

import com.common.biz.BaseBiz;
import com.team3.entity.*;
import com.common.util.PageResult;

public class CstLostBiz extends BaseBiz {
	public void getList(CstLost item, PageResult pageResult) {
		String hql = "select o from CstLost o where o.lstStatus='3' ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getLstCustName())) {
				hql += "and o.lstCustName like '%" + item.getLstCustName()
						+ "%' ";
			}
			if (isNotNullOrEmpty(item.getLstCustManagerName())) {
				hql += "and o.lstCustManagerName like '%"
						+ item.getLstCustManagerName() + "%' ";
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}

}
