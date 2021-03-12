package chap03.spring;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.*;

public class InsertServ implements IService{
	@Autowired
	private MemberDAO Dao;
	@Autowired
	@Qualifier("WriteLock")
	private ReentrantLock LLock;
	
	public InsertServ() {
	}
	@Override
	public void run(Object[] in) {
		String id = (String)in[0];
		String pwd = (String)in[1];
		this.LLock.lock();
		try {			
			if(id.length()<4 || pwd.length()<4) {
				System.out.println("insert fail");
				System.out.print("cnt : ");
				System.out.println(getCnt());
			} else {
				System.out.println("insert success");
				this.Dao.insert(id, pwd);
				System.out.print("cnt : ");
				System.out.println(getCnt());
			}
		} finally {
			this.LLock.unlock();
		}
	}
	@Override
	public int getCnt() {
		return this.Dao.count;
	}
}
