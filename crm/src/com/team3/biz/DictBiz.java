package com.team3.biz;

import java.util.List;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.BasDict;

public class DictBiz extends BaseBiz {
	public void getList(BasDict item, PageResult pageResult) {
		String hql = "select o from BasDict o where 1=1 ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getDictType())) {
				hql += "and o.dictType like '%" + item.getDictType() + "%' ";
			}
			if (isNotNullOrEmpty(item.getDictItem())) {
				hql += "and o.dictItem like '%" + item.getDictItem() + "%' ";
			}
			if (isNotNullOrEmpty(item.getDictValue())) {
				hql += "and o.dictValue like '%" + item.getDictValue() + "%' ";
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}

	public BasDict getDictByValue(String item) {
		String hql = "select o from BasDict o where o.dictItem='" + item
				+ "'";
		List list = this.getCommonDAO().list(hql);
		if (list != null)
			return (BasDict) list.get(0);
		else
			return null;
	}

	public List getAllDictByType(String type) {
		String sql = "select o from BasDict o where o.dictType='" + type + "'";
		return this.getCommonDAO().list(sql);
	}

	public void add(BasDict item) {
		long res = (Long) super.getCommonDAO().add(item);
		System.out.println(res);
	}

	public BasDict get(long id) {
		return (BasDict) super.getCommonDAO().get(BasDict.class, id);
	}

	public void update(BasDict item) {
		super.getCommonDAO().update(item);
	}

	public void del(long id) {
		super.getCommonDAO().del(BasDict.class, id);
	}
}
