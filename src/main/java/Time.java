package main.java;
import java.util.StringTokenizer;

public class Time {

	private int min, sec;
	private float milli;

	public Time(String line) {
		StringTokenizer t = new StringTokenizer(line);
		StringTokenizer t2;

		min = Integer.parseInt(t.nextToken("'"));

		t2 = new StringTokenizer(t.nextToken("'"));
		sec = Integer.parseInt(t2.nextToken("."));
		milli = Float.parseFloat(t2.nextToken("."));
	}

	public float convertToSec() {
		return min * 60 + sec + (milli / 1000);
	}

	public String toString() {
		if (sec < 10)
			return min + "'0" + sec + "." + milli;
		else
			return min + "'" + sec + "." + milli;
	}
}
