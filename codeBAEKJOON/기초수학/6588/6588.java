import java.io.*;
import java.util.*;

public class Main {
	public static int n = Integer.MAX_VALUE;
	public static int MAX = 1000000;
	public static boolean check = false;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean [] primeNum = new boolean [MAX+1];
		primeNum[0] = primeNum[1] = true;
		
		for(int i=2; i<=MAX; i++) {
			if(!primeNum[i]) {
				for(int j=i+i; j<=MAX; j+=i)
					primeNum[j] = true;
			}
		}
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			check = false;
			for(int i=3; i<n; i+=2) {
				if(check)
					break;
				if(!primeNum[i] && !primeNum[n-i]) {
					System.out.println(n + " = " + i + " + " + (n-i));
					check = true;
					break;
				}
			}
			if(!check)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}
}
