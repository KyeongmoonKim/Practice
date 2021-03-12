package chap03.spring;

public class MyRunnable implements Runnable{
	private IService Serv;
	private String[] args;
	public int count;
	public MyRunnable(IService srv) {
		this.Serv = srv;
		args = new String[2];
	}
	public void setId(String id) {
		this.args[0] = id;
	}
	public void setPwd(String pwd) {
		this.args[1] = pwd;
	}
	@Override
	public void run() {
		this.Serv.run(args);
		System.out.print("My count : ");
		System.out.println(count);
	}
}
