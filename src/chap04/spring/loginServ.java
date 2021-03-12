package chap04.spring;

public class loginServ implements IService{
	private MemberDAO Dao;
	public loginServ(MemberDAO dao) {
		this.Dao = dao;
	}
	
	public void run(Object[] in) {
		String id = (String)in[0];
		String pwd = (String)in[1];
		
		String key = this.Dao.select(id);
		if(key!=null&&key.compareTo(pwd)==0) {
			System.out.println("Login Success!");
		} else {
			System.out.println("Login Failed");
		}
	}
	@Override
	public int getCnt() {
		return this.Dao.count;
	}
}
