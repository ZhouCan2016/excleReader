package com.common.dao;

import java.io.Serializable;
import java.util.List;

import com.common.util.PageResult;

public interface CommonDAO {
	public Object get(Class clazz,Serializable id);
	public Object getObj(Class clazz,Serializable id);
	public Serializable add(Object o);
	public void del(Class clazz,Serializable id);
	public void update(Object o);
	public List list(String sql);
	public void listByPage(String hql, PageResult pageResult);
}
