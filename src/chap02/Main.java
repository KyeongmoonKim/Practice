package chap02;
import org.springframework.context.annotation.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter h1 = ctx.getBean("greeter", Greeter.class);
		Greeter h2 = ctx.getBean("greeter", Greeter.class);
		Greeter b1 = ctx.getBean("greeter1", Greeter.class);
		h1.sumGreet(" biily!");
		b1.sumGreet(" billy!");
		System.out.println(h1.getGreet());
		System.out.println(h2.getGreet());
		System.out.println(b1.getGreet());
		ctx.close();
	}

}
