import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int gcf = Euclidean(m, n);   // Greatest Common Factor (최대공약수)
		int lcm = m * n / gcf;   // Least Common Multiple
		
		System.out.println(gcf + "\n" + lcm);
	}
	
	public static int Euclidean(int a, int b) {
		if(b == 0)
			return a;
		else 
			return Euclidean(b, a%b);
	}
}
