package chap03.config;
import chap03.spring.*;
import org.springframework.context.annotation.*;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class AppCtx { 
	@Bean
	public MemberDAO Dao() { //기본이 싱글톤이라 밑에 두개가 같은 dao를 공유함
		return new MemberDAO();
	}
	
	@Bean
	public ReentrantLock ReadLock() {
		return new ReentrantLock();
	}
	@Bean
	public ReentrantLock WriteLock() {
		return new ReentrantLock();
	}
	
	@Bean
	public IService Is1() {
		return new InsertServ();
	}
	
	@Bean
	public IService Is2() {
		return new InsertServ();
	}
	@Bean
	public IService Is3() {
		return new InsertServ();
	}
	@Bean
	public IService Ls1() {
		return new loginServ();
	}
	@Bean
	public IService Ls2() {
		return new loginServ();
	}
	@Bean
	public IService Ls3() {
		return new loginServ();
	}
}
