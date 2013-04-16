package main.java;
import java.util.ArrayList;
import java.util.List;

public class Rider {
	private String name;
	private List<Time> times;

	public Rider(String n) {
		name = n;
		times = new ArrayList<Time>();
	}

	public void addTime(Time t) {
		times.add(t);
	}

	public String toString(){
		StringBuffer str=new StringBuffer(); 
		str.append("Rider : "+name+"\n");
		
		for(Time t : times){
			str.append(t.convertToSec()+"\n");
		}
		
		str.append("\n");
		
		return str.toString();
	}

	public String getName() {
		return name;
	}

	public List<Time> getTimes() {
		return times;
	}
	
}
