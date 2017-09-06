package com.team3.entity;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.team3.biz.UserBiz;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");		
//		SysUser item=(SysUser) sf.openSession().get(SysUser.class, 2L);
		UserBiz biz=(UserBiz) context.getBean("userBiz");
		SysUser item=biz.loginValidate("hlliu", "pwd");
		SysRole role=item.getSysRole();
		Set rights=role.getSysRights();
		Iterator it=item.getSysRole().getSysRights().iterator();// rights.iterator();
		while(it.hasNext()){
			SysRight right=(SysRight) it.next();
			right.getRightCode();
			System.out.println(right.getRightCode()+right.getRightText()+right.getRightTip());
		}
	}

}
