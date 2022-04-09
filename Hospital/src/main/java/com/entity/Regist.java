package com.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/** 实体类：
 * 1、一组private属性
 * 2、setter和getter
 * 3、一组构造器
 * 4、重写equals(),hashCode(),toString()
 * 5、实现Serializable接口
 * */

public class Regist implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Date datetime;
	private String userName;
	private String sex;
	private String IDcard;
	private String phone;
	private Timestamp created;
	private Timestamp updated;
	
	
	public Regist(Date datetime, String userName, String sex, String iDcard, String phone) {
		super();
		this.datetime = datetime;
		this.userName = userName;
		this.sex = sex;
		IDcard = iDcard;
		this.phone = phone;
	}


	public  Regist() {}

	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getIDcard() {
		return IDcard;
	}


	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Timestamp getCreated() {
		return created;
	}


	public void setCreated(Timestamp created) {
		this.created = created;
	}


	public Timestamp getUpdated() {
		return updated;
	}


	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDcard == null) ? 0 : IDcard.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regist other = (Regist) obj;
		if (IDcard == null) {
			if (other.IDcard != null)
				return false;
		} else if (!IDcard.equals(other.IDcard))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Regist [datetime=" + datetime + ", userName=" + userName + ", sex=" + sex + ", IDcard=" + IDcard
				+ ", phone=" + phone + ", created=" + created + ", updated=" + updated + "]";
	}

	
	
}
