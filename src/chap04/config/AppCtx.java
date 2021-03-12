package chap04.config;
import chap04.spring.*;
import org.springframework.context.annotation.*;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class AppCtx { 
	@Bean
	public MemberDAO Dao() { //기본이 싱글톤이라 밑에 두개가 같은 dao를 공유함
		return new MemberDAO();
	}
	
	@Bean
	public IService Is() {
		return new InsertServ(Dao());
	}
	
	@Bean
	public IService Ls() {
		return new loginServ(Dao());
	}
}
