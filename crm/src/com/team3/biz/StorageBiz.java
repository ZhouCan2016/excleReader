package com.team3.biz;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.Storage;

public class StorageBiz extends BaseBiz {
	public void getList(Storage item, PageResult pageResult) {
		String hql = "select o from Storage o where 1=1 ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getStkWarehouse())) {
				hql += "and o.stkWarehouse like '%" + item.getStkWarehouse() + "%' ";
			}
			if (item.getProduct().getProdName()!=null) {
				hql += "and o.product.prodName like '%" + item.getProduct().getProdName() + "%' ";
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}
	public void add(Storage item) {
		long res= (Long) super.getCommonDAO().add(item);
		System.out.println(res);
	}

	public Storage get(long id) {
		return (Storage) super.getCommonDAO().get(Storage.class, id);
	}

	public void update(Storage item) {
		super.getCommonDAO().update(item);
	}

	public void del(long id) {
		super.getCommonDAO().del(Storage.class, id);
	}
}
