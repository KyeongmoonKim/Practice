package chap03.config;
import chap03.spring.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppCtx { 
	@Bean
	public MemberDAO Dao() { //기본이 싱글톤이라 밑에 두개가 같은 dao를 공유함
		return new MemberDAO();
	}
	
	@Bean
	public InsertServ Is() {
		return new InsertServ(Dao());
	}
	@Bean
	public loginServ Ls() {
		return new loginServ(Dao());
	}
}
