package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1.드라이버로딩			
			Class.forName("com.mysql.jdbc.Driver");
			// 2. connection
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. statememt 생성
			stmt = conn.createStatement();
	
			// 4.SQL실행
			String sql = " select no, first_name, last_name, email  from emaillist ";
			rs = stmt.executeQuery(sql);
			
			// 5. fetch row
			while (rs.next()) {
				long no = rs.getLong(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String email = rs.getString(4);
				System.out.println(no + ":" + fn + ":" + ln + ":" + email);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
		
}
