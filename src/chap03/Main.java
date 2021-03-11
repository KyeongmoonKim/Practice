package chap03;
import chap03.spring.*;
import chap03.config.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import java.io.*;

public class Main {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String command = br.readLine();
			String in = br.readLine();
			String[] idPwd = in.split(" ");
			
			if(command.compareTo("break")==0) break;
			else if(command.compareTo("insert")==0) {
				System.out.println("Insertion start!");
				IService service = ctx.getBean("Is", InsertServ.class);
				service.run(idPwd);
				System.out.println(service.getCnt());
			} else if(command.compareTo("login")==0) {
				System.out.println("Login start!");
				IService service = ctx.getBean("Ls", loginServ.class);
				service.run(idPwd);
				System.out.println(service.getCnt());
			}
		}
	}

}
