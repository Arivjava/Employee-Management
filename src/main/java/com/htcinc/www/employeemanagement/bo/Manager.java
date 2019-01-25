/**
 * 
 */
package com.htcinc.www.employeemanagement.bo;

import java.io.Serializable;

/**
 * @author ARIVA
 *
 */
public class Manager implements Serializable {

	
	private int id;
	private String name;
	/**
	 * 
	 */
	
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
