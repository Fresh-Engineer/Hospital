package com.entity;


import java.io.Serializable;


public class Sc implements Serializable {
	private static final long serialVersionUID = 1L;
	public String sno;
	private String ssno;
	private String srade;
	
	

	public Sc(String sno, String ssno, String srade) {
		super();
		this.sno = sno;
		this.ssno = ssno;
		this.srade = srade;
	}
	
	public Sc() {
		
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSsno() {
		return ssno;
	}

	public void setSsno(String Ssno) {
		this.ssno = Ssno;
	}

	public String getSrade() {
		return srade;
	}

	public void setSrade(String Srade) {
		this.srade = Srade;
	}

	//重写equals(),hashCode(),toString()
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((sno == null) ? 0 : sno.hashCode());
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
			Sc other = (Sc) obj;
			if (sno == null) {
				if (other.sno != null)
					return false;
			} else if (!sno.equals(other.sno))
				return false;
			return true;
		}
	
	@Override
	public String toString() {
		return "Sc [sno=" + sno + ", ssno=" + ssno + ", srade=" + srade + "]";
	}

	
}

