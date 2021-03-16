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
		//List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) 같은 타입일경우에거
		//List<T> query(String sql, RowMapper<T> rowMapper, Object... args)
		if(results.size()!=1) return false; //해당되는 id가 없거나 여러개임.
		UserVO temp = results.get(0); //하나니까 가져옴.
		if(temp.getPwd().compareTo(pwd)==0) return true;
		else return false;
	}
	public boolean isDup(String id) {
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
		if(!results.isEmpty()) return true; //아이디 중복
		else return false; //아이디 중복 없음
	}
	
	public void insertUser(UserVO uvo) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO MYUSER(USERID, USERPWD, NAME) VALUES (?, ?, ?)");
				pstmt.setString(1, uvo.getId());
				pstmt.setString(2, uvo.getPwd());
				pstmt.setString(3, uvo.getName());
				return pstmt;
			}
		});
	}
}
