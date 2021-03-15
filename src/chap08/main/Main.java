package chap08.main;

import config08.AppCtx;
import chap08.spring.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		UserDao dao = ctx.getBean("userDao", UserDao.class);
		ctx.close();
	}

}
