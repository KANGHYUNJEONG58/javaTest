package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String fn = "강";
			String ln = "민수";
			String em = "alstn@gamil.com";
			
			
			// 1.드라이버로딩			
			Class.forName("com.mysql.jdbc.Driver");
			// 2. connection
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. statememt 준비
			String sql = " insert into emaillist values (null, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
	
			// 4.binding
			pstmt.setString(1, fn);
			pstmt.setString(2, ln);
			pstmt.setString(3, em);
			
			// 5.sql 실행
			pstmt.executeUpdate();
			
			// close하면 자동으로 커밋됨.
			// 중간 catch걸리면 자동으로 롤백됨	
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				
				if (pstmt != null) {
					pstmt.close();
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
