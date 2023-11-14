package database.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J01_SelectQuiz {
	/*
	  	모든 사원의 사번/ 이름 / 부서명 / 직책명을 읽어 파일형태로 저장해보세요
	*/
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT employee_id, first_name, department_name ,job_title  FROM employees "
				+ "INNER JOIN jobs USING (job_id) INNER JOIN departments USING (department_id)";
		try(
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			FileWriter out = new FileWriter("myfiles/employee.txt");
		) {
			
			while(rs.next()) {
				out.write(String.format("%d/%s/%s/%s\n",
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("department_name"),
						rs.getString("job_title")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
// --------------------------------------------------------------------------------------------------------------
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		long before = System.currentTimeMillis();
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","1234");
//			// 모든 사원의 사번/ 이름 / 부서명 / 직책명을 읽어 파일형태로 저장해보세요
//			String sql = "SELECT employee_id, first_name, department_name ,job_title  FROM employees "
//					+ "INNER JOIN jobs USING (job_id) INNER JOIN departments USING (department_id)";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			StringBuilder st = new StringBuilder();
//			
//			while(rs.next()) {
//				st.append(rs.getString("employee_id")+" : ");
//				st.append(rs.getString("first_name")+" - ");
//				st.append(rs.getString("department_name")+" - ");
//				st.append(rs.getString("job_title")+"\n");
//				try	(		
//					FileWriter fout = new FileWriter("myfiles/sql_employee.txt");
//					BufferedWriter bout = new BufferedWriter(fout);
//					PrintWriter out = new PrintWriter(bout);
//				) {
////					out.append(st.toString());
//					out.print(st.toString());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			rs.close();
//			pstmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		long after = System.currentTimeMillis();
//		System.out.println("time 1: " + (after - before) + "ms");

	}
}
