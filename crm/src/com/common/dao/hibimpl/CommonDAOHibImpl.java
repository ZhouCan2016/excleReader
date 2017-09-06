package com.common.dao.hibimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.dao.CommonDAO;
import com.common.util.PageResult;

/**
 * 
 * @author hailong.liu
 */
public class CommonDAOHibImpl implements CommonDAO {
	private SessionFactory sessionFactory=null;

	/* （非 Javadoc）
	 * @see y2ssh.dlc.chp2.dao.CommonDAO#add(java.lang.Object)
	 */
	public Serializable add(Object o){
		Serializable ret=0;
		Session session=this.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
			ret=session.save(o);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ret;
	}
	/* （非 Javadoc）
	 * @see y2ssh.dlc.chp2.dao.CommonDAO#get(java.lang.Class, java.io.Serializable)
	 */
	public Object get(Class clazz, Serializable id){
		Session session=this.getSessionFactory().openSession();
		Object ret = session.get(clazz, id);
		//session.close();
		return ret;
	}
	public Object getObj(Class clazz, Serializable id){
		Session session=this.getSessionFactory().openSession();
		Object ret = session.get(clazz, id);
		session.close();
		return ret;
	}
	/* （非 Javadoc）
	 * @see y2ssh.dlc.chp2.dao.CommonDAO#del(java.lang.Class, java.io.Serializable)
	 */
	public void del(Class clazz,Serializable id){
		Session session=this.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
			Object o=this.getObj(clazz, id);
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	/* （非 Javadoc）
	 * @see y2ssh.dlc.chp2.dao.CommonDAO#update(java.lang.Object)
	 */
	public void update(Object o){
		Session session=this.getSessionFactory().openSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
			session.update(o);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	/* （非 Javadoc）
	 * @see y2ssh.dlc.chp2.dao.CommonDAO#search(java.lang.String)
	 */
	public List list(String hql){
		Session session=this.getSessionFactory().openSession();
		List ret = session.createQuery(hql).list();
		//session.close();
		return ret;
	}
	/* （非 Javadoc）
	 * @see org.jb.common.dao.CommonDAO#listByPage(java.lang.String, org.jb.common.util.PageResult)
	 */
	@SuppressWarnings("unchecked")
	public void listByPage(String hql, PageResult pageResult) {
		if (null==hql){
			return ;
		}
		Query query = this.getSessionFactory().openSession().createQuery(hql);
		query.setFirstResult(pageResult.getFirstRec());
		query.setMaxResults(pageResult.getPageSize());
		List list = query.list();
		pageResult.setList(list);

		String queryString = "";
		if (hql.toUpperCase().indexOf("SELECT") != -1) {
			int i = query.getQueryString().toUpperCase().indexOf("FROM");
			queryString = "Select count(*) " + hql.substring(i,hql.length());
		} else {
			queryString = "Select count(*) " + hql;
		}
		// 去掉ORDER BY 的部分
		int j = queryString.toUpperCase().lastIndexOf("ORDER");
		if (j!=-1){
			queryString = queryString.substring(0, j);
		}		
		Query cquery = this.getSessionFactory().openSession().createQuery(queryString);
		cquery.setCacheable(true);
		int recTotal = ((Integer)cquery.iterate().next()).intValue();		
		pageResult.setRecTotal(recTotal);
	}
	public SessionFactory getSessionFactory() {
//		Configuration conf=new Configuration().configure();
//		SessionFactory sf=conf.buildSessionFactory();
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
		return sf;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
