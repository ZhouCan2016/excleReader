package com.team3.biz;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.Product;

public class ProductBiz extends BaseBiz {
	public void getList(Product item, PageResult pageResult) {
		String hql = "select o from Product o where 1=1 ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getProdName())) {
				hql += "and o.prodName like '%" + item.getProdName() + "%' ";
			}
			if (isNotNullOrEmpty(item.getProdType())) {
				hql += "and o.prodType like '%" + item.getProdType() + "%' ";
			}
			if (isNotNullOrEmpty(item.getProdBatch())) {
				hql += "and o.prodBatch like '%" + item.getProdBatch() + "%' ";
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}
	public void add(Product item) {
		long res= (Long) super.getCommonDAO().add(item);
		System.out.println(res);
	}

	public Product get(long id) {
		return (Product) super.getCommonDAO().get(Product.class, id);
	}

	public void update(Product item) {
		super.getCommonDAO().update(item);
	}

	public void del(long id) {
		super.getCommonDAO().del(Product.class, id);
	}
}
