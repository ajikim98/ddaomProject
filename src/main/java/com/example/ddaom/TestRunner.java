package com.example.ddaom;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {
//	private final DataSource dataSource;
//	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Connection connection = dataSource.getConnection();
//		log.info("DBCP: {}", dataSource.getClass());
//		log.info("Url : {}", connection.getMetaData().getURL());
//		log.info("username : {}", connection.getMetaData().getUserName());
		
//		jdbcTemplate.execute("INSERT INTO member2(name, password, email) VALUES('Lion', '1234', 'lion@email.com')");
	}
}