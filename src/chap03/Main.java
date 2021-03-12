package chap03;
import chap03.spring.*;
import chap03.config.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import java.io.*;
import java.util.*;

public class Main {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MyRunnable run1 = new MyRunnable(ctx.getBean("Is1", InsertServ.class));
		MyRunnable run2 = new MyRunnable(ctx.getBean("Is2", InsertServ.class));
		MyRunnable run3 = new MyRunnable(ctx.getBean("Is3", InsertServ.class));
		MyRunnable run4 = new MyRunnable(ctx.getBean("Ls1", loginServ.class));
		MyRunnable run5 = new MyRunnable(ctx.getBean("Ls2", loginServ.class));
		MyRunnable run6 = new MyRunnable(ctx.getBean("Ls3", loginServ.class));
		run1.setId("111111");
		run1.setPwd("111111");
		run1.count=1;
		run2.setId("222222");
		run2.setPwd("222222");
		run2.count=2;
		run3.setId("333333");
		run3.setPwd("333333");
		run3.count=3;
		run4.setId("111111");
		run4.setPwd("111111");
		run4.count=4;
		run5.setId("222222");
		run5.setPwd("222222");
		run5.count=5;
		run6.setId("333333");
		run6.setPwd("333333");
		run6.count=6;
		Thread[] temp = new Thread[6];
		temp[0] = new Thread(run1);
		temp[1] = new Thread(run2);
		temp[2] = new Thread(run3);
		temp[3] = new Thread(run4);
		temp[4] = new Thread(run5);
		temp[5] = new Thread(run6);
		temp[0].start();
		temp[1].start();
		temp[2].start();
		
		temp[0].join();
		temp[1].join();
		temp[2].join();
		
		temp[3].start();
		temp[4].start();
		temp[5].start();
		temp[3].join();
		temp[4].join();
		temp[5].join();
	}

}
