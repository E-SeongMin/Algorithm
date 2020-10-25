import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean [] primeNum = new boolean [n+1];
		primeNum[0] = primeNum[1] = true;
		
		for(int i=2; i<=n; i++) {
			if(!primeNum[i]) {
				for(int j=i+i; j<=n; j+=i)
					primeNum[j] = true;
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(!primeNum[i])
				System.out.println(i);
		}
	}
}
