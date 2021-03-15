package chap08.spring;
import javax.sql.DataSource;

import org.springframework.jdbc.core.*;
import org.springframework.beans.factory.annotation.*;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
