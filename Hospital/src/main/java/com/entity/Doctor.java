package com.entity;


import java.io.Serializable;


public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	public String cnoo;
	private String cname;
	private String cteacher;
	private String ccredit;
	
	
	
	public Doctor(String cnoo, String cname, String cteacher, String ccredit) {
		super();
		this.cnoo = cnoo;
		this.cname = cname;
		this.cteacher = cteacher;
		this.ccredit = ccredit;
	}
	
	public Doctor() {
		
	}

	public String getCnoo() {
		return cnoo;
	}

	public void setCnoo(String Cnoo) {
		this.cnoo = Cnoo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String Cname) {
		this.cname = Cname;
	}

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String Cteacher) {
		this.cteacher = Cteacher;
	}

	public String getCcredit() {
		return ccredit;
	}

	public void setCcredit(String Ccredit) {
		this.ccredit = Ccredit;
	}

	//重写equals(),hashCode(),toString()
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cnoo == null) ? 0 : cnoo.hashCode());
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
			Doctor other = (Doctor) obj;
			if (cnoo == null) {
				if (other.cnoo != null)
					return false;
			} else if (!cnoo.equals(other.cnoo))
				return false;
			return true;
		}
	
	@Override
	public String toString() {
		return "Doctor [cnoo=" + cnoo + ", cname=" + cname + ", cteacher=" + cteacher + ", ccredit=" + ccredit
				+ "]";
	}

	
}

