package config09;
import org.springframework.context.annotation.*;
import chap09.*;

@Configuration
public class ControllerConfig {
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
}
