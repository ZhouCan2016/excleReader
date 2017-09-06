package com.team3.biz;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.SysUser;

/**
 * 用户管理业务逻辑类
 * 
 * @author hailong.liu
 */
public class UserBiz extends BaseBiz {
	/**
	 * 查询用户列表
	 */
	public void getList(SysUser item, PageResult pageResult) {
		String hql = "select o from SysUser o where 1=1 ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getUsrName())) {
				hql += "and o.usrName like '%" + item.getUsrName() + "%' ";
			}
			if (item.getUsrFlag() != null && item.getUsrFlag() != -1) {
				hql += "and o.usrFlag = " + item.getUsrFlag() + " ";
			}
		}
		if (isNotNullOrEmpty(pageResult.getOrderBy())) {
			String sort = pageResult.getSort();
			hql += "order by " + pageResult.getOrderBy() + " " + sort;
			if ("asc".equals(sort)) {
				pageResult.setSort("desc");
			} else {
				pageResult.setSort("asc");
			}
		} else {
			hql += "order by o.usrId desc,o.usrName asc";
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}
	/**
	 * 查询所有客户经理
	 * @return
	 */
	public List getListByType() {
		String hql = "select o from SysUser o where o.sysRole.roleId=4";
		return this.getCommonDAO().list(hql);
	}
	public List getAllRole(){
		String hql="select o from SysRole o";
		return this.getCommonDAO().list(hql);
	}
	public void add(SysUser user) {
		this.getCommonDAO().add(user);
	}
	public SysUser get(long id) {
		// TODO Auto-generated method stub
		SysUser user=(SysUser) this.getCommonDAO().get(SysUser.class, id);
		return user;
	}
	public void del(long id){
		this.getCommonDAO().del(SysUser.class, id);
	}
	public void update(SysUser item){
		this.getCommonDAO().update(item);
	}
	public SysUser loginValidate(String uname,String upass){
		String hql="select o from SysUser o where o.usrName='"+uname+"' and o.usrPassword='"+upass+"'";
		List list=this.getCommonDAO().list(hql);
		SysUser user=null;
		if(list.size()!=0){
			user=(SysUser) list.get(0);
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
			SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");		
			SysUser item=(SysUser) sf.openSession().get(SysUser.class, user.getUsrId());			
			return item;
		}	
		return user;		
	}
}
