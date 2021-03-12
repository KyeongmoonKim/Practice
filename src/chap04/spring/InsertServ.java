package chap04.spring;

public class InsertServ implements IService{
	private MemberDAO Dao;
	public InsertServ(MemberDAO dao) {
		this.Dao = dao;
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
