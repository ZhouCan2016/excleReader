package com.team3.entity;

/**
 * Dtproperties generated by MyEclipse Persistence Tools
 */

public class Dtproperties implements java.io.Serializable {

	// Fields

	private DtpropertiesId id;

	private Integer objectid;

	private String value;

	private String uvalue;

	private String lvalue;

	private Integer version;

	// Constructors

	/** default constructor */
	public Dtproperties() {
	}

	/** minimal constructor */
	public Dtproperties(DtpropertiesId id, Integer version) {
		this.id = id;
		this.version = version;
	}

	/** full constructor */
	public Dtproperties(DtpropertiesId id, Integer objectid, String value,
			String uvalue, String lvalue, Integer version) {
		this.id = id;
		this.objectid = objectid;
		this.value = value;
		this.uvalue = uvalue;
		this.lvalue = lvalue;
		this.version = version;
	}

	// Property accessors

	public DtpropertiesId getId() {
		return this.id;
	}

	public void setId(DtpropertiesId id) {
		this.id = id;
	}

	public Integer getObjectid() {
		return this.objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUvalue() {
		return this.uvalue;
	}

	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}

	public String getLvalue() {
		return this.lvalue;
	}

	public void setLvalue(String lvalue) {
		this.lvalue = lvalue;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}