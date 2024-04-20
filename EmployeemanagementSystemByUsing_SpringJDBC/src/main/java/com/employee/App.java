package com.employee;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.employee.config.EmployeeConfig;
import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeeDetails;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
       EmployeeDetails employeeDetails=new EmployeeDetails();
       System.out.println("Enter Employee name");
       String name=sc.next();
       employeeDetails.setEmp_name(name);
       System.out.println("Enter employee deptno");
       int deptno=sc.nextInt();
       employeeDetails.setEmp_deptno(deptno);
       System.out.println("Enter employee salary");
       double salary=sc.nextDouble();
       employeeDetails.setEmp_sal(salary);
       ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
       EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
       employeeDao.registration(employeeDetails);
       employeeDao.updatesalary(75000,5);
       employeeDao.deletebasedonname("Pradeep");
       employeeDao.updatesalarybasedondeptno(99000, 30);
       employeeDao.deleteempstartswithanycharacter('r');
       employeeDao.deleteempendswithanycharacter('v');
       employeeDao.selectemployeedetailsbasedonid(1);
       employeeDao.displayemployeedetailsbasedondeptno(30);
       employeeDao.displaysallessthangivenvalue(98000);
       employeeDao.displaynamebasedongivencharacter('n');
       employeeDao.printnameifvowelgreaterthanone("praveen");
       employeeDao.printifdeptnoismegaprime(37);
       employeeDao.selectemployeedetailsbasedonidbasedonlambda(1);
       employeeDao.selectdetailswheredeptnogreaterthangivenvalue(30);
       employeeDao.selectdetailswheredeptnogreaterthangivenvaluebyusingbeanproperty(30);
     
        
    }
}
