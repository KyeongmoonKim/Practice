package chap03.config;
import chap03.spring.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppCtx { 
	@Bean
	public MemberDAO Dao() { //�⺻�� �̱����̶� �ؿ� �ΰ��� ���� dao�� ������
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
