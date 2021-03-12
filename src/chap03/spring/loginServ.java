package chap03.spring;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.*;


public class loginServ implements IService{
	@Autowired
	private MemberDAO Dao;
	@Autowired
	@Qualifier("ReadLock")
	private ReentrantLock LLock;
	
	public loginServ() {
	}
	
	public void run(Object[] in) {
		String id = (String)in[0];
		String pwd = (String)in[1];
		this.LLock.lock();
		try {
			String key = this.Dao.select(id);
			if(key!=null&&key.compareTo(pwd)==0) {
				System.out.println("Login Success!");
			} else {
				System.out.println("Login Failed");
			}
			System.out.print("cnt : ");
			System.out.println(getCnt());
		} finally {
			this.LLock.unlock();
		}
	}
	@Override
	public int getCnt() {
		return this.Dao.count;
	}
}
