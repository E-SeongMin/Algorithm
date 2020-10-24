import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] divisor = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			divisor[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(divisor);
		
		System.out.print(divisor[0]*divisor[n-1]);
	}
}
