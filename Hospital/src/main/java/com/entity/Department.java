package com.entity;


import java.io.Serializable;


public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	public String kno;
	private String kname;

	
	
	
	public Department(String kno, String kname) {
		super();
		this.kno = kno;
		this.kname = kname;

	}
	
	public Department() {
		
	}

	public String getKno() {
		return kno;
	}

	public void setKno(String Kno) {
		this.kno = Kno;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String Kname) {
		this.kname = Kname;
	}

	//重写equals(),hashCode(),toString()
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((kno == null) ? 0 : kno.hashCode());
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
			Department other = (Department) obj;
			if (kno == null) {
				if (other.kno != null)
					return false;
			} else if (!kno.equals(other.kno))
				return false;
			return true;
		}
	
	@Override
	public String toString() {
		return "Department [kno=" + kno + ", kname=" + kname + "]";
	}

	
}

