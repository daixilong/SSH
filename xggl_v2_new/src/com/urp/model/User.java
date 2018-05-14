package com.urp.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

public class User implements Serializable {

	private static final long serialVersionUID = 1449870151752913698L;

	@NotNull(message="主键不能为空")
	private Integer id;
	
	@JsonIgnore
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
