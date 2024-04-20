package com.employee.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.model.EmployeeDetails;

public class EmployeeDetailsRowMapperImpl implements RowMapper<EmployeeDetails> {

	@Override
	public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDetails employeeDetails=new EmployeeDetails();
		employeeDetails.setEmp_id(rs.getInt("Emp_id"));
		employeeDetails.setEmp_name(rs.getString("Emp_name"));
		employeeDetails.setEmp_sal(rs.getDouble("Emp_sal"));
		employeeDetails.setEmp_deptno(rs.getInt("Emp_deptno"));
		return employeeDetails;
	}

}
