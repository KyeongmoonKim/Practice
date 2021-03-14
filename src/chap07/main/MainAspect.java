package chap07.main;
import config.AppCtx;
import chap07.spring.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

public class MainAspect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Isum is = ctx.getBean("hello", Isum.class); //�߿� �������̽�.class�� ����������� ���Ͻ��Ϸ���. �ֳĸ� ���Ͻð� ����� �������־���ϴϱ�.
		String[] input = {"a", "b", "c", "d", "e"};
		System.out.println(is.sum(input));
		System.out.println(is.getClass().getName()); //������ is�� �Ҵ�Ǵ°� proxy ��ü �� �Ҵ�ǰ�, �굵 ���� �������� �־��� Isum�������̽��� ���߻���ϰ��ִ°���.
		ctx.close();
	}

}
