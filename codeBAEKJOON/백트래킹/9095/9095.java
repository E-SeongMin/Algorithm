import java.io.*;
import java.util.*;

public class Main {
	public static int count;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			count = 0;
			int n = Integer.parseInt(br.readLine());
			Backtracking(n, 0);
			
			System.out.println(count);
		}
	}
	
	public static void Backtracking(int target, int now) {
		if(target < now)
			return;
		
		if(target == now) {
			count++;
			return;
		}
		else {
			Backtracking(target, now + 1);
			Backtracking(target, now + 2);
			Backtracking(target, now + 3);
		}
	}
}
