package chap03.spring;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.*;

public class InsertServ implements IService{
	private MemberDAO Dao;
	public InsertServ() {
	}
	@Override
	public void run(Object[] in) {
		String id = (String)in[0];
		String pwd = (String)in[1];
		if(id.length()<4 || pwd.length()<4) {
			System.out.println("insert fail");
			return;
		}
		System.out.println("insert success");
		this.Dao.insert(id, pwd);
	}
	@Override
	public int getCnt() {
		return this.Dao.count;
	}
}
