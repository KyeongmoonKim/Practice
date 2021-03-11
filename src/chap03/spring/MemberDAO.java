package chap03.spring;
import java.util.*;

public class MemberDAO {
	HashMap<String, String> map;
	public int count;
	public MemberDAO() {
		map = new HashMap<String, String>();
		count = 0;
	}
	
	public ArrayList<String> selectAll() {
		count++;
		ArrayList<String> ret = new ArrayList<String>();
		String[] keys = (String[])this.map.keySet().toArray();
		for(int i =0; i < this.map.size(); i++) {
			ret.add(map.get(keys[i]));
		}
		return ret;
	}
	public String select(String key) {
		count++;
		return this.map.get(key);
	}
	public boolean insert(String key, String value) { //성공시 true, 실패시 false
		count++;
		boolean ret = !this.map.containsKey(key);
		if(ret) map.put(key, value);
		return ret;
	}
	public boolean delete(String key) { //성공시 true, 실패시 false
		count++;
		boolean ret = this.map.containsKey(key);
		if(ret) map.remove(key);
		return ret;
	}
	public boolean update(String key, String value) {
		boolean ret = !this.map.containsKey(key);
	    if(ret) {
	    	map.remove(key);
	    	map.put(key, value);
	    }	    
	    count++;
	    return ret;
	}
}
