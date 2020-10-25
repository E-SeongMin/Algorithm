import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num, primeCount, count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			primeCount = 0;
			num = Integer.parseInt(st.nextToken());
			for(int j=1; j<=num; j++) {
				if(num % j == 0)
					primeCount++;
			}		
			if(primeCount == 2)
				count++;
		}
		System.out.print(count);
	}
}
