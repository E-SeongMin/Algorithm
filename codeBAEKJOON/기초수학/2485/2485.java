import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] distance = new int [n-1];
		int temp = Integer.parseInt(br.readLine());
		int first = temp;
		int temp2;
		for(int i=0; i<n-1; i++) {
			temp2 = Integer.parseInt(br.readLine());
			distance[i] = temp2 - temp;
			temp = temp2;
		}
		
		int gcd = distance[n-2];
		for(int i=n-3; i>=0; i--) {
			gcd = Euclidean(gcd, distance[i]);
		}
		
		int total_gap = temp - first;
		int count = (total_gap / gcd) - n+1;
		
		System.out.println(count);
	}
	
	public static int Euclidean(int a, int b) {
		if(b == 0)
			return a;
		else
			return Euclidean(b, a%b);
	}
}
