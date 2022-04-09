package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/** 实体类：
 * 1、一组private属性
 * 2、setter和getter
 * 3、一组构造器
 * 4、重写equals(),hashCode(),toString()
 * 5、实现Serializable接口
 * */
public class Cost implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer cost_id;  //挂号编号
	private String p_name;//病人姓名
	private String sex;//性别
	private String age;//年龄
	private String phone;//手机
	private Integer cost;//费用
	private String state;//状态
	private Timestamp created;//缴费时间
	
	
	public  Cost() {}
	//点右键Source然后Generate Constructor using Fields...
	

	

	public Cost(Integer cost_id, String p_name, String sex, String age, String phone, Integer cost, String state,
			Timestamp created) {
		super();
		this.cost_id = cost_id;
		this.p_name = p_name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.cost = cost;
		this.state = state;
		this.created = created;
	}

	public Integer getCost_id() {
		return cost_id;
	}
	public void setCost_id(Integer cost_id) {
		this.cost_id = cost_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getCost() {
		return cost;
	}


	public void setCost(Integer cost) {
		this.cost = cost;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Timestamp getCreated() {
		return created;
	}


	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	

}
