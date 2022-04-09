package com.entity;

import java.io.Serializable;
import java.sql.Date;

public class Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer m_sid;
	private String m_name;
	private Date m_pdate;
	private Date m_edate;
	private Integer m_snumber;
	private String m_place;
	
	
	
	public Stock(Integer m_sid, String m_name, Date m_pdate, Date m_edate, Integer m_snumber, String m_place) {
		super();
		this.m_sid = m_sid;
		this.m_name = m_name;
		this.m_pdate = m_pdate;
		this.m_edate = m_edate;
		this.m_snumber = m_snumber;
		this.m_place = m_place;
	}



	public Stock(Integer m_sid, String m_name, Integer m_snumber) {
		// TODO Auto-generated constructor stub
	}



	public Stock() {
		// TODO Auto-generated constructor stub
	}



	public Integer getM_sid() {
		return m_sid;
	}



	public void setM_sid(Integer m_sid) {
		this.m_sid = m_sid;
	}



	public String getM_name() {
		return m_name;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public Date getM_pdate() {
		return m_pdate;
	}



	public void setM_pdate(Date m_pdate) {
		this.m_pdate = m_pdate;
	}



	public Date getM_edate() {
		return m_edate;
	}



	public void setM_edate(Date m_edate) {
		this.m_edate = m_edate;
	}



	public Integer getM_snumber() {
		return m_snumber;
	}



	public void setM_snumber(Integer m_snumber) {
		this.m_snumber = m_snumber;
	}



	public String getM_place() {
		return m_place;
	}



	public void setM_place(String m_place) {
		this.m_place = m_place;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}



	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public String toString() {
		return "Stock [m_sid=" + m_sid + ", m_name=" + m_name + ", m_pdate=" + m_pdate + ", m_edate=" + m_edate
				+ ", m_snumber=" + m_snumber + ", m_place=" + m_place + "]";
	}
	
	
	
	

	
}
