package com.frank.axis.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("interfacemsg")
public class Interfacemsg {

	private Query query;
	private Result result;
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	
}
