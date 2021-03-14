package config;
import org.springframework.context.annotation.*;
import chap07.spring.Isum;
import chap07.spring.StrSum;
import aspect.*;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	@Bean
	public AspectIsum aspectIsum() {
		return new AspectIsum();
	}
	
	@Bean
	public Isum hello() {
		return new StrSum();
	}
}
