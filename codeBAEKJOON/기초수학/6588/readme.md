# 문제 주소  
https://www.acmicpc.net/problem/6588

## 목표
에라토스테네스의 체 사용하여 소수를 먼저 구하고
```
for(int i=2; i<=MAX; i++) {
	if(!primeNum[i]) {
		for(int j=i+i; j<=MAX; j+=i)
			primeNum[j] = true;
	}
}
```
소수 i와 j의 합이 k라면 k-i = j
```
for(int i=3; i<n; i+=2) {
	if(check)
		break;
	if(!primeNum[i] && !primeNum[n-i]) {
		System.out.println(n + " = " + i + " + " + (n-i));
		check = true;
		break;
	}
}
```
boolean 변수 check를 사용하여 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에 "Goldbach's conjecture is wrong."을 출

## 소스코드
```
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
```
