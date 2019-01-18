package com.auto.entity;

public class Dept {
	private String dname;
	private String loc;
	private Integer deptno;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Dept [dname=" + dname + ", loc=" + loc + ", deptno=" + deptno + "]";
	}
	
}
