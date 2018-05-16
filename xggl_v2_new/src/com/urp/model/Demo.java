package com.urp.model;

import java.io.File;
import java.io.Serializable;

public class Demo implements Serializable {

	private static final long serialVersionUID = -9015638887000229504L;
	private String field1;
	private Byte [] field2;
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public Byte[] getField2() {
		return field2;
	}
	public void setField2(Byte[] field2) {
		this.field2 = field2;
	}

    
}
