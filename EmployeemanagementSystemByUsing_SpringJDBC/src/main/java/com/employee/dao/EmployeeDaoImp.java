package com.employee.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.employee.model.EmployeeDetails;
import com.employee.rowmapper.EmployeeDetailsRowMapperImpl;
@Component
public class EmployeeDaoImp implements EmployeeDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void registration(EmployeeDetails employeeDetails) {
		String insert="insert into employee (Emp_name, Emp_sal, Emp_deptno) values(?,?,?)";
		int update = jdbcTemplate.update(insert,employeeDetails.getEmp_name(),employeeDetails.getEmp_sal(),employeeDetails.getEmp_deptno());
		if(update!=0)
		{
			System.out.println("Data inserted successfully");
		}
		else
		{
			System.out.println("Data not inserted");
		}
	}
	@Override
	public void updatesalary(double salary, int empid) {
		String update="update employee set Emp_sal=? where Emp_id=?";
		int res = jdbcTemplate.update(update,salary,empid);
		if(res!=0)
		{
			System.out.println(res+" row is affected");
			System.out.println("Salary is updated successfull🙌🙌");
		}
		else
		{
			System.out.println("Salary not updated");
		}

	}
	@Override
	public void updatesalarybasedondeptno(double salary, int deptno) {
		String update="update employee set Emp_sal=? where Emp_deptno=?";
		int res = jdbcTemplate.update(update,salary,deptno);
		if(res!=0)
		{
			System.out.println(res+" row is affected");
			System.out.println("Salary is updated successfull🙌🙌");
		}
		else
		{
			System.out.println("Salary not updated");
		}

	}
	@Override
	public void deletebasedonname(String name) {
		String delete="delete from employee where Emp_name=?";
		int res = jdbcTemplate.update(delete,name);
		if(res!=0)
		{
			System.out.println("deleted successfully");
		}
		else
		{
			System.out.println("there is no emp based on name");
		}
	}
	@Override
	public void deleteempstartswithanycharacter(char c) {
		String delete="delete from employee where Emp_name like ?";
		int res = jdbcTemplate.update(delete,c+"%");
		if(res!=0)
		{
			System.out.println("deleted successfully");
		}
		else
		{
			System.out.println("there is no emp starts with character "+c);
		}

	}
	@Override
	public void deleteempendswithanycharacter(char c) {
		String delete="delete from employee where Emp_name like ?";
		int res = jdbcTemplate.update(delete,"%"+c);
		if(res!=0)
		{ 
			System.out.println("deleted successfully");
		}
		else
		{
			System.out.println("there is no emp ends with character "+c);
		}

	}
	@Override
	public void selectemployeedetailsbasedonid(int empid) {
		String select="select * from employee where Emp_id=?";
		try {
			EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(select, new EmployeeDetailsRowMapperImpl(),empid);
			System.out.println("Employeeid:" +employeeDetails .getEmp_id());
			System.out.println("Employeename:" +employeeDetails.getEmp_name());
			System.out.println("Employeesalary:" +employeeDetails.getEmp_sal());
			System.out.println("Employeedeptno:" +employeeDetails.getEmp_deptno());
		}
		catch (Exception e) {
			System.out.println("no employee found with given id " +empid);
		}

	}
	@Override
	public void displayemployeedetailsbasedondeptno(int deptno) {
		String select="select * from employee where Emp_deptno=?";
		List<EmployeeDetails> employeeDetails = jdbcTemplate.query(select, new EmployeeDetailsRowMapperImpl(),deptno);
		System.out.println(employeeDetails);
		Iterator<EmployeeDetails> iterator=employeeDetails.iterator();

		/*  	to get values one by one we can use foreach loop
		 * =========================================================*/
		System.out.println("============================================");
		System.out.println("By using for each loop");
		System.out.println("============================================");
		if(employeeDetails.size()!=0)
		{
			for(EmployeeDetails details:employeeDetails)
			{
				System.out.println("Employeeid:" +details .getEmp_name());
				System.out.println("Employeename:" +details.getEmp_name());
				System.out.println("Employeesalary:" +details.getEmp_sal());
				System.out.println("Employeedeptno:" +details.getEmp_deptno());
			}
			/* to get values one by one we can use forEachMethod */
			System.out.println("============================================");
			System.out.println("By using for each method");
			System.out.println("============================================");
			employeeDetails.forEach((details)->
			{
				System.out.println("Employeeid:" +details .getEmp_name());
				System.out.println("Employeename:" +details.getEmp_name());
				System.out.println("Employeesalary:" +details.getEmp_sal());
				System.out.println("Employeedeptno:" +details.getEmp_deptno());
			});
		}
		else
		{
			System.out.println("no employee found with given id " +deptno);
		}
		/*		to get values one by one we use cursor
		  ===========================================================*/
		while(iterator.hasNext())
		{
			EmployeeDetails employeeDetails2 = iterator.next();
			System.out.println("Employeeid:" +employeeDetails2 .getEmp_id());
			System.out.println("Employeename:" +employeeDetails2.getEmp_name());
			System.out.println("Employeesalary:" +employeeDetails2.getEmp_sal());
			System.out.println("Employeedeptno:" +employeeDetails2.getEmp_deptno());

		}
		 


	}
	@Override
	public void displaysallessthangivenvalue(int sal) {
		String select="select * from employee where Emp_sal<?";
		List<EmployeeDetails> query = jdbcTemplate.query(select, new EmployeeDetailsRowMapperImpl(),sal);
		System.out.println(query);

	}
	@Override
	public void displaynamebasedongivencharacter(char c) {
		String select="select * from employee where Emp_name like ?";
		List<EmployeeDetails> list = jdbcTemplate.query(select, new EmployeeDetailsRowMapperImpl(),c+"%");
		System.out.println(list);

	}
	@Override
	public void printnameifvowelgreaterthanone(String name) {
		int count=0;
		for(int i=0;i<name.length();i++)
		{
			char c=name.charAt(i);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			{
				count++;
			}
		}
		if(count>1)
		{
			String select="select * from employee where Emp_name=?";
			List<EmployeeDetails> list = jdbcTemplate.query(select, new EmployeeDetailsRowMapperImpl(),name);
			if(list.size()!=0)
			{
				System.out.println(list);
			}
			else
			{
				System.out.println("no data found with the given name  "+name);
			}
			
		}
		else
		{
			System.out.println(name+" : does not contain more than one vowel");
		}



	}
	@Override
	public void printifdeptnoismegaprime(int deptno) {
		boolean status=false;
		for(int i=0;i<deptno;i++)
		{
			int count=0;
			for(int j=1;j<deptno;j++)
			{
				if(i%j==0)
				{
					count++;
				}
			}
			if(count==1)
			{
				int temp=deptno;
				while(temp!=0)
				{
					int rem=temp%10;
					if(rem==2||rem==3||rem==5||rem==7)
					{
						status=true;
					}
					else
					{
						status=false;
						break;
					}
					temp/=10;

				}
				if(status==true)
				{
					String select="select * from employee where Emp_deptno=?";
					List<EmployeeDetails> list = jdbcTemplate.query(select, new EmployeeDetailsRowMapperImpl(),deptno);
					System.out.println(list);
				}
				
			}

		}
	}
	@Override
	public void selectemployeedetailsbasedonidbasedonlambda(int empid) {
		String select="select * from employee where Emp_id=?";
		RowMapper<EmployeeDetails> empdetails=(rs,rowNum)->
		{
			EmployeeDetails employeeDetails=new EmployeeDetails();
			employeeDetails.setEmp_id(rs.getInt("Emp_id"));
			employeeDetails.setEmp_name(rs.getString("Emp_name"));
			employeeDetails.setEmp_sal(rs.getDouble("Emp_sal"));
			employeeDetails.setEmp_deptno(rs.getInt("Emp_deptno"));
			return employeeDetails;
			
		};
		try {
			EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(select, empdetails,empid);
			System.out.println(employeeDetails);
			
		}
		catch(Exception e){
			System.out.println("no data found");
		}
		
		
	}
	@Override
	public void selectdetailswheredeptnogreaterthangivenvalue(int deptno) {
		String select="select * from employee where Emp_deptno>?";
		RowMapper<EmployeeDetails> empdetails=(rs,rowNum)->{/* here rs is resultset and int rowNum present in RowMapper interface */
			EmployeeDetails emp=new EmployeeDetails();
			emp.setEmp_id(rs.getInt("Emp_id"));
			emp.setEmp_name(rs.getString("Emp_name"));
			emp.setEmp_deptno(rs.getInt("Emp_deptno"));
			emp.setEmp_sal(rs.getDouble("Emp_sal"));
			return emp;
			
		};
		try {
			List<EmployeeDetails> list = jdbcTemplate.query(select, empdetails,deptno);
			System.out.println(list);
		}
		catch(Exception e)
		{
			System.out.println("No data found");
		}
		
	}
	@Override
	public void selectdetailswheredeptnogreaterthangivenvaluebyusingbeanproperty(int deptno) {
		String select="select * from employee where Emp_deptno>?";
		BeanPropertyRowMapper<EmployeeDetails> beanPropertyRowMapper=new BeanPropertyRowMapper<EmployeeDetails>(EmployeeDetails.class);
		List<EmployeeDetails> list = jdbcTemplate.query(select, beanPropertyRowMapper,deptno);
		if(list.size()!=0)
		{
			System.out.println(list);
		}
		else
		{
			System.out.println("No data found for given deptno : "+deptno);
		}
		
	}



}
