package chap07.spring;

public class StrSum implements Isum {
	public StrSum() {
		
	}
	
	@Override
	public Object sum(Object[] lists) {
		String ret = new String("");
		for(int i = 0; i < lists.length; i++) {
			String temp = (String)lists[i];
			ret = ret + temp;
		}
		return ret;
	}
}
