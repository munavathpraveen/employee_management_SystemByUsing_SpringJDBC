package com.employee.dao;

import com.employee.model.EmployeeDetails;

public interface EmployeeDao {
	void registration(EmployeeDetails employeeDetails);
	void updatesalary(double salary,int empid);
	void updatesalarybasedondeptno(double salary,int deptno);
	void deletebasedonname(String name);
	void deleteempstartswithanycharacter(char c);
	void deleteempendswithanycharacter(char c);
	void selectemployeedetailsbasedonid(int empid);
	void displayemployeedetailsbasedondeptno(int deptno);
	void displaysallessthangivenvalue(int sal);
	void displaynamebasedongivencharacter(char c);
	void printnameifvowelgreaterthanone(String name);
	void printifdeptnoismegaprime(int deptno);
	void selectemployeedetailsbasedonidbasedonlambda(int empid);
	void selectdetailswheredeptnogreaterthangivenvalue(int deptno);
	void selectdetailswheredeptnogreaterthangivenvaluebyusingbeanproperty(int deptno);

}
