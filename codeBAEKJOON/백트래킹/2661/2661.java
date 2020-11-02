import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static boolean end = false;
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		Backtracking("");
	}
	
	public static void Backtracking(String s) {
		if(end)	return;
		if(s.length() == n) {
			System.out.println(s);
			end = true;
			return;
		}
		for(int i=1; i<=3; i++) {
			if(isGood(s + i))
				Backtracking(s + i);
		}
	}
	
	public static boolean isGood(String s) {
		String front_str, end_str;
		for(int i=1; i<=s.length()/2; i++) {
			front_str = s.substring(s.length()-2*i, s.length()-i);
			end_str = s.substring(s.length()-i, s.length());
			if(front_str.equals(end_str))
				return false;
		}
		return true;
	}
}
