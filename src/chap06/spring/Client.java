package chap06.spring;
import org.springframework.beans.factory.*;

public class Client implements InitializingBean, DisposableBean{
	
	private String id;
	public Client() {
		id = null;
		System.out.println("Client Bean Created!");
	}
	public void setId(String in) {
		this.id = in;
	}
	public String getId() {
		return this.id;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called!");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destory called!");
		
	}
}
