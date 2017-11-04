package kr.co.saramin.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.saramin.emaillist.vo.EmaillistVo;

/**
 * sql 관련
 * @author user1
 *
 */
public class EmaillistDao {
	public boolean insert (EmaillistVo vo) {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
		
			// 1.드라이버로딩			
			Class.forName("com.mysql.jdbc.Driver");
			// 2. connection
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. statememt 준비
			String sql = " insert into emaillist values (null, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
	
			// 4.binding
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
			// 5.sql 실행
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
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
		
		return result;

	
	}
	
	public List<EmaillistVo> getList() {
		
		List<EmaillistVo> list = new ArrayList<EmaillistVo>(); // 인터페이스?
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1.드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");	//	db접속?
			
			// 2.connect 하기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3.create statement
			stmt = conn.createStatement();
			
			// 4.Execute SQL
			String sql = " select no, first_name, last_name, email from emaillist ";
			rs = stmt.executeQuery(sql); // select
			/*stmt.executeUpdate(sql)	// select 외*/
			
			while (rs.next()) {
				long no = rs.getLong(1);		
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				list.add(vo);
			}
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("JDBC드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("NOT CONNECTED" + e);
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
		
		return list; 
	}
	
}
