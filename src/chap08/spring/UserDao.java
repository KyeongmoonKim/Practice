package chap08.spring;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import org.springframework.beans.factory.annotation.*;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean login(String id, String pwd) {
		List<UserVO> results = jdbcTemplate.query(
				"SELECT * FROM MYUSER WHERE USERID = ? ",
				new RowMapper<UserVO>() {
					@Override
					public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserVO uvo = new UserVO();
						uvo.setId(rs.getString("USERID"));
						uvo.setPwd(rs.getString("USERPWD"));
						uvo.setName(rs.getString("NAME"));
						return uvo;
					}
				}, id);
		if(results.size()!=1) return false; //�ش�Ǵ� id�� ���ų� ��������.
		UserVO temp = results.get(0); //�ϳ��ϱ� ������.
		if(temp.getPwd().compareTo(pwd)==0) return true;
		else return false;
	}
}
