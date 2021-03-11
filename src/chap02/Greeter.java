package chap02;

public class Greeter {
	private String format;
	
	public String getGreet() {
		return this.format;
	}
	public void sumGreet(String guest) {
		this.format = this.format + guest;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
