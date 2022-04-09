package com.entity;

import java.io.Serializable;


public class Medicine implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer m_id;
	private String m_name;
	private String m_type;
	private String m_brand;
	private Integer m_price;
	private String m_specification;
	
	
	
	public Medicine(Integer m_id, String m_name, String m_type, String m_brand, Integer m_price,
			String m_specification) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_type = m_type;
		this.m_brand = m_brand;
		this.m_price = m_price;
		this.m_specification = m_specification;
	}
	
	public Medicine() {
	}

	/**
	 * @return the m_id
	 */
	public Integer getM_id() {
		return m_id;
	}
	/**
	 * @param m_id the m_id to set
	 */
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	/**
	 * @return the m_name
	 */
	public String getM_name() {
		return m_name;
	}
	/**
	 * @param m_name the m_name to set
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	/**
	 * @return the m_type
	 */
	public String getM_type() {
		return m_type;
	}
	/**
	 * @param m_type the m_type to set
	 */
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	/**
	 * @return the m_brand
	 */
	public String getM_brand() {
		return m_brand;
	}
	/**
	 * @param m_brand the m_brand to set
	 */
	public void setM_brand(String m_brand) {
		this.m_brand = m_brand;
	}
	/**
	 * @return the m_price
	 */
	public Integer getM_price() {
		return m_price;
	}
	/**
	 * @param m_price the m_price to set
	 */
	public void setM_price(Integer m_price) {
		this.m_price = m_price;
	}
	/**
	 * @return the m_specification
	 */
	public String getM_specification() {
		return m_specification;
	}
	/**
	 * @param m_specification the m_specification to set
	 */
	public void setM_specification(String m_specification) {
		this.m_specification = m_specification;
	}
	
	//重写equals(),hashCode(),toString()
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((m_id == null) ? 0 : m_id.hashCode());
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
			Medicine other = (Medicine) obj;
			if (m_id == null) {
				if (other.m_id != null)
					return false;
			} else if (!m_id.equals(other.m_id))
				return false;
			return true;
		}
	
	@Override
	public String toString() {
		return "Medicine [m_id=" + m_id + ", m_name=" + m_name + ", m_type=" + m_type + ", m_brand=" + m_brand
				+ ", m_price=" + m_price + ", m_specification=" + m_specification + "]";
	}
	
}
