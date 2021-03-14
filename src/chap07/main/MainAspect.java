package chap07.main;
import config.AppCtx;
import chap07.spring.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

public class MainAspect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Isum is = ctx.getBean("hello", Isum.class); //중요 인터페이스.class로 생성해줘야함 프록시하려면. 왜냐면 프록시가 상속을 받을수있어야하니까.
		String[] input = {"a", "b", "c", "d", "e"};
		System.out.println(is.sum(input));
		System.out.println(is.getClass().getName()); //실제로 is에 할당되는건 proxy 객체 가 할당되고, 얘도 지금 저기위에 넣어준 Isum인터페이스를 다중상속하고있는거임.
		ctx.close();
	}

}
