package kr.co.saramin.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.saramin.mysite.vo.GuestbookVo;

public class GuestbookDao {

	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
				
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
			String sql = " select no, name, date_format(reg_date, '%Y-%m-%d') as reg_date, message "
					   + "from guestbook order by reg_date desc ";
			rs = stmt.executeQuery(sql);
			
			// 5. fetch row
			while (rs.next()) {
				long no = rs.getLong(1);
				String nm = rs.getString(2);
				String reg_dt = rs.getString(3);
				String msg = rs.getString(4);
				
				GuestbookVo vo = new GuestbookVo();
				
				vo.setMessage(msg);
				vo.setName(nm);
				vo.setNo(no);
				vo.setReg_dt(reg_dt);
				
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
		
		
		return list;
	}
	
	public GuestbookDao() {
		// TODO Auto-generated constructor stub
	}

}
