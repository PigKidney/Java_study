package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.Employee;

public class J06_DataModelClass {
	/*
	  
		# 데이터 모델 클래스
	   
		- DB에서 꺼낸 데이터를 담아놓는 용도로 사용하는 클래스
	 	- 데이터를 매개변수 등으로 활용하기 편리한 형태
	 	- DTO, VO 등으로 불리기도 한다 
	*/
	public static void main(String[] args) {
		
		String sql = "SELECT * FROM employees";
		try(
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			int columnCount = rs.getMetaData().getColumnCount();
			
			// 테이블의 한 행을 인스턴스화 해놓으면 Collection에도 활용할 수 있다
			List<Employee> employees = new ArrayList<>();
			
			while(rs.next()) {
				// 꺼낸 데이터를 인스턴스화 해놓으면 여기저기 사용하기 편리해진다
				Employee emp = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getString("email"), 
						rs.getString("phone_number"), 
						rs.getString("HIRE_DATE"), 
						rs.getString("JOB_ID"), 
						rs.getInt("SALARY"), 
						rs.getDouble("COMMISSION_PCT"), 
						rs.getInt("MANAGER_ID"), 
						rs.getInt("DEPARTMENT_ID"));
				
//				System.out.println(rs.getInt("employee_id"));
//				System.out.println(rs.getString("first_name"));
//				System.out.println(rs.getString("last_name"));
//				System.out.println(rs.getString("email"));
//				System.out.println(rs.getString("phone_number"));
//				System.out.println(rs.getString("HIRE_DATE"));
//				System.out.println(rs.getString("JOB_ID"));
//				System.out.println(rs.getString("SALARY"));
//				System.out.println(rs.getString("COMMISSION_PCT"));
//				System.out.println(rs.getString("MANAGER_ID"));
//				System.out.println(rs.getString("DEPARTMENT_ID"));
				
				
//				for(int i = 1 ; i <= columnCount ; ++i) {
//					System.out.printf("%-"+rs.getMetaData().getColumnDisplaySize(i)+"s",rs.getObject(i));
//				}
//				System.out.println();
				employees.add(emp);
			}
			System.out.println(employees.get(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
