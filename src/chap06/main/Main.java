package chap06.main;
import chap06.config.*;
import chap06.spring.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client client = ctx.getBean("client", Client.class);
		ExternalClass ec = ctx.getBean("ec", ExternalClass.class);
		ctx.close();

	}

}
