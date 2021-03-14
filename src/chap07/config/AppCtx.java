package chap07.config;
import org.springframework.context.annotation.*;
import chap07.spring.*;
import chap07.aspect.*;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	@Bean
	public AspectIsum aspectIsum() {
		return new AspectIsum();
	}
	
	@Bean
	public Isum isum() {
		return new StrSum();
	}
}
