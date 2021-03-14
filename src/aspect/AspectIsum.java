package aspect;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import java.util.*;

@Aspect
public class AspectIsum {
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();  //���� ��� ��ü �޼��� ȣ��
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.print(joinPoint.getTarget().getClass().getSimpleName()+".");
			System.out.print(sig.getName()+".");
			System.out.print(Arrays.deepToString(joinPoint.getArgs())+ ", ����ð� : ");
			System.out.println(finish-start);
		}
	}
}
