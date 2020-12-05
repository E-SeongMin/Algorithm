import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int count = 0;
		boolean [] primeNum = new boolean [n+1];
		primeNum[0] = primeNum[1] = true;
		
		for(int i=2; i<=n; i++) {
			if(!primeNum[i]) {
				for(int j=i+i; j<=n; j+=i)
					primeNum[j] = true;
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(!primeNum[i]) {
				for(int j=i; j<=n; j++) {
					if(!primeNum[j]) {
						sum += j;
						if(sum == n) {
							count++;
						}
						if(sum > n) {
							sum = 0;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
