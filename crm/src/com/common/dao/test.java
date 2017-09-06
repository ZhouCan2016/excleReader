package com.common.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.dao.hibimpl.CommonDAOHibImpl;
import com.team3.entity.SalChance;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalChance item=new SalChance();
		item.setChcCustName("admin");
		item.setChcTitle("aa");
		item.setChcRate(12);
		item.setChcDesc("abcdedf");
		item.setChcCreateId(1L);
		item.setChcCreateBy("qq");
		item.setChcCreateDate(new Date());
		item.setChcStatus("1");
		item.setChcId(17L);
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		CommonDAO dao=(CommonDAO) context.getBean("commonDAO");
//		dao.add(item);
		
		CommonDAO dao=new CommonDAOHibImpl();
		dao.update(item);
//		Configuration conf=new Configuration().configure();
//		SessionFactory sf=conf.buildSessionFactory();
//		Session session=sf.openSession();
//		Transaction tx=null;
//		try {
//			tx = session.beginTransaction();
//			session.save(item);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
		
		
	}

}
