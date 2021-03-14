package chap07.main;
import chap07.spring.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Isum proSum = new proxySum(new StrSum());
		String[] input = {"a", "b", "c", "d", "e"};
		System.out.println(proSum.sum(input));
	
	}

}
