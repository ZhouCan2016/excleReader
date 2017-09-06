package com.ctsi.backup.utils;


import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSON;

public class ListClause<K, V> extends HashMap<K, V> {
	
	boolean isChecked = false;
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public ListClause(String input){
		Object obj = JSON.parse(input);
		this.putAll((Map<K, V>)obj);
	}
	
	public static Map<String,String> entityMap = new HashMap<String,String>();
	private static Map<String,Method> methodMap = new HashMap<String,Method>();

	@SuppressWarnings("unchecked")
	private void checkPage4Clause(){
		boolean needInit = true;
		if(this.containsKey("pagesize") && this.containsKey("startpage")){
			try{
				int ps=1 , sp=0;
				if(String.class.isInstance(this.get("pagesize"))){
					ps = Integer.parseInt((String)this.get("pagesize"));
					sp = Integer.parseInt((String)this.get("startpage"));
				}else{
					ps = ((Integer)this.get("pagesize")).intValue();
					sp = ((Integer)this.get("startpage")).intValue();				
				}

				put((K) "startPage", (V)Integer.valueOf(sp));
				put((K) "pageSize", (V)Integer.valueOf(ps));
			}catch(Exception e){ }
			needInit = false;
		}
		if(needInit){
			put((K) "startPage", (V) "1");
			put((K) "pageSize", (V) "0");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void checkOrder4Clause(){
		if(this.containsKey("ordercol")){
			boolean isDesc = false;
			if(String.class.isInstance(this.get("isdesc"))){
				isDesc = Boolean.parseBoolean((String)this.get("isdesc"));
			}else{
				isDesc = Boolean.valueOf((Boolean)this.get("isdesc"));
			}
			
			put((K)"orderType", (V) (isDesc ? "desc" : "asc"));
			put((K) "orderCol", this.get("ordercol"));
		}
	}
	
	private void checkClauseType(){
		Iterator<K> keyIt = this.keySet().iterator();
		while(keyIt.hasNext()){
			String clauseName = (String)keyIt.next();
			String[] names = clauseName.split("_");
			if(names.length>1){
				Method m = null;
				if(methodMap.containsKey(clauseName)){
					m = methodMap.get(clauseName);
				}else{
					String entityName = names[0];
					String entityClassName = entityMap.get(entityName.toLowerCase());
					if(entityClassName == null){
						continue;
					}
					String propertyName = names[1];
					String getPropertyMName = "get"+
							propertyName.substring(0,1).toUpperCase()+
							propertyName.substring(1, propertyName.length());
					try {
						m = Class.forName(entityClassName).getMethod(getPropertyMName);
						methodMap.put(clauseName, m);
					} catch (NoSuchMethodException e) {
						System.out.println("can not find method : "+ getPropertyMName);
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				Class<?> retType = m.getReturnType();
				if(clauseName.contains("List")){
					List<String> list = (List<String>)this.get(clauseName);
					String vals = "";
					for(String o : list){
						if(String.class.getSimpleName().equals(retType.getSimpleName()) || 
								Date.class.getSimpleName().equals(retType.getSimpleName())){
							vals = vals + "'" + o + "',";
						}else{
							vals = vals + o + ",";
						}
					}
					if(String.class.getSimpleName().equals(retType.getSimpleName()) || 
							Date.class.getSimpleName().equals(retType.getSimpleName())){
						vals = vals + "''";
					}else{
						vals = vals + ",-10";
					}
					this.put((K) clauseName, (V)vals);
				}else{
					String value = (String) this.get(clauseName);
					if(Date.class.getSimpleName().equals(retType.getSimpleName())){
						
					}
					if(Long.class.getSimpleName().equals(retType.getSimpleName())){
						Long.parseLong(value);
					}
					if(Integer.class.getSimpleName().equals(retType.getSimpleName())){
						Integer.parseInt(value);
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getClause(){
		if(isChecked == false){
			checkPage4Clause();
			checkOrder4Clause();
			checkClauseType();
		}
		return (Map<String, String>) this;		
	}
}

