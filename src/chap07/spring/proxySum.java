package chap07.spring;

public class proxySum implements Isum {
	private Isum delegate;
	public proxySum(Isum in) {
		this.delegate = in;
	}
	@Override
	public Object sum(Object[] lists) {
		long start = System.currentTimeMillis();
		String ret = (String)this.delegate.sum(lists);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		return ret;
	}
}
