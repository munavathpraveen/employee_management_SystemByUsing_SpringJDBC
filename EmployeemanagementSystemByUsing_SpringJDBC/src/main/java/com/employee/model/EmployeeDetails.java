package com.employee.model;

public class EmployeeDetails {
	private int Emp_id;
	private String Emp_name;
	private double Emp_sal;
	private int Emp_deptno;
	public EmployeeDetails() {
	
	}
	public EmployeeDetails(int emp_id, String emp_name, double emp_sal, int emp_deptno) {
		
		Emp_id = emp_id;
		Emp_name = emp_name;
		Emp_sal = emp_sal;
		Emp_deptno = emp_deptno;
	}
	public int getEmp_id() {
		return Emp_id;
	}
	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}
	public String getEmp_name() {
		return Emp_name;
	}
	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}
	public double getEmp_sal() {
		return Emp_sal;
	}
	public void setEmp_sal(double emp_sal) {
		Emp_sal = emp_sal;
	}
	public int getEmp_deptno() {
		return Emp_deptno;
	}
	public void setEmp_deptno(int emp_deptno) {
		Emp_deptno = emp_deptno;
	}
	@Override
	public String toString() {
		return "EmployeeDetails2 [Emp_id=" + Emp_id + ", Emp_name=" + Emp_name + ", Emp_sal=" + Emp_sal
				+ ", Emp_deptno=" + Emp_deptno + "]";
	}
	

}
