package com.team3.biz;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.biz.BaseBiz;
import com.common.util.PageResult;
import com.team3.entity.SysRight;
import com.team3.entity.SysRole;

/**
 * 用户管理业务逻辑类
 * 
 * @author hailong.liu
 */
public class RoleBiz extends BaseBiz {
	/**
	 * 查询用户列表
	 */
	public void getList(SysRole item, PageResult pageResult) {
		String hql = "select o from SysRole o where 1=1 ";
		if (null != item) {
			if (isNotNullOrEmpty(item.getRoleName())) {
				hql += "and o.roleName like '%" + item.getRoleName() + "%' ";
			}
			if (item.getRoleFlag() != null) {
				if (item.getRoleFlag() != -1) {
					hql += "and o.roleFlag = " + item.getRoleFlag() + " ";
				}
			}
		}
		this.getCommonDAO().listByPage(hql, pageResult);
	}

	/**
	 * 查询所有客户经理
	 * 
	 * @return
	 */
	public List getRights() {
		String hql = "select o from SysRight o";
		return this.getCommonDAO().list(hql);
	}

	public List getAllRole() {
		String hql = "select o from SysRole o";
		return this.getCommonDAO().list(hql);
	}

	public SysRole getRoleWithRights(Long id) {
		SysRole ret = null;
		String hql = "select distinct rl from SysRole rl left outer join fetch rl.sysRights where rl.roleId="
				+ id;
		List list=this.getCommonDAO().list(hql);
		if(list.size()>0){
			ret=(SysRole) list.get(0);
		}else{
			ret=null;
		}
		return ret;
	}

	public void assignRights(Long roleId,String[] selectedRightCodes){
		SysRole role=(SysRole) this.getCommonDAO().get(SysRole.class, roleId);
		role.getSysRights().clear();
		if(null!=selectedRightCodes){
			for(int i=0;i<selectedRightCodes.length;++i){
				SysRight right=(SysRight) this.getCommonDAO().get(SysRight.class, selectedRightCodes[i]);
				role.getSysRights().add(right);
			}
		}
		this.getCommonDAO().update(role);
	}
	public SysRole get(long id) {
		// TODO Auto-generated method stub
		SysRole user = (SysRole) this.getCommonDAO().get(SysRole.class, id);
		return user;
	}
	public SysRight getRight(String rightCode){
		return (SysRight) this.getCommonDAO().get(SysRight.class, rightCode);
	}
}
