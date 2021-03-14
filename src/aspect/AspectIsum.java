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
			Object result = joinPoint.proceed();  //실제 대상 객체 메서드 호출
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.print(joinPoint.getTarget().getClass().getSimpleName()+".");
			System.out.print(sig.getName()+".");
			System.out.print(Arrays.deepToString(joinPoint.getArgs())+ ", 실행시간 : ");
			System.out.println(finish-start);
		}
	}
}
