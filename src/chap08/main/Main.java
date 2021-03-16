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
		/*UserVO uvo = new UserVO();
		uvo.setId("test2");
		uvo.setPwd("test2");
		uvo.setName("test2");
		dao.insertUser(uvo); */ //id insertion
		String[] ids = {"test1", "test2"};
		String[] pwds = {"test1", "test2"};
		String[] pwdNews = {"0", "0"};
		try {
			dao.changePwds(ids, pwds, pwdNews);
		} catch(Exception e){
			System.out.println("error!");
		}
		ctx.close();
	}

}
