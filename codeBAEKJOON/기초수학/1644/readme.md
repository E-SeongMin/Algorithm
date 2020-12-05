# 문제 주소  
https://www.acmicpc.net/problem/1644

## 목표
연속된 소수의 합 구하기

## 문제 해결
에라토스테네스의 체 알고리즘을 사용하여 먼저 소수를 구해둠
```
for(int i=2; i<=n; i++) {
	if(!primeNum[i]) {
		for(int j=i+i; j<=n; j+=i)
			primeNum[j] = true;
	}
}
```
이중 for문을 사용하여 차례대로 합을 구해보고 원하는 답이 나올 경우 Count 증가
```
for(int i=2; i<=n; i++) {
	if(!primeNum[i]) {
		for(int j=i; j<=n; j++) {
			if(!primeNum[j]) {
				sum += j;
				if(sum == n)
					count++;
				if(sum > n) {
					sum = 0;
					break;
				}
			}
		}
	}
}
```

## 소스코드
```
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
						if(sum == n)
							count++;
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
```
