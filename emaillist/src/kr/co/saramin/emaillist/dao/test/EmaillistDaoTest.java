package kr.co.saramin.emaillist.dao.test;

import java.util.List;

import kr.co.saramin.emaillist.dao.*;
import kr.co.saramin.emaillist.vo.EmaillistVo;

/**
 * dao를 테스트 하기 위한 파일
 * @author user1
 *
 */
public class EmaillistDaoTest {
	public static void main(String[] args) {
		EmaillistDao dao = new EmaillistDao();
		
		List<EmaillistVo> list = dao.getList();
		for (EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}
}
