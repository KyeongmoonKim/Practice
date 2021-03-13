package chap06.spring;

public class ExternalClass {
	public String hi;
	public ExternalClass() {
		this.hi = null;
		System.out.println("ExternalClass Bean Created!");
	}
	public void init() {
		System.out.println("init start!");
	}
	public void end() {
		System.out.println("end");
	}
}
