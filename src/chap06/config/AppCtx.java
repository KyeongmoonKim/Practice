package chap06.config;
import org.springframework.context.annotation.*;
import chap06.spring.*;

@Configuration
public class AppCtx {
	@Bean
	public Client client() {
		Client ret = new Client();
		ret.setId("kkm8031");
		System.out.println("Before Client bean return");
		return ret;
	}
	
	@Bean(initMethod = "init", destroyMethod = "end") //커스텀 메서드
	public ExternalClass ec() {
		ExternalClass a = new ExternalClass();
		a.hi = "hi";
		System.out.println("Before ExternalClass bean return");
		return a;
	}
}
