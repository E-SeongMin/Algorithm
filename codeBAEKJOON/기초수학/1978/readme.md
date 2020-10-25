# 문제 주소  
https://www.acmicpc.net/problem/1978

## 목표
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램 작성

## 문제 해결
소수는 1과 자기자신으로만 나누어지는 수. 따라서 
```
for(int j=1; j<=num; j++) {
	if(num % j == 0)
		primeCount++;
}
```
해당 정수를 for문 차례대로 나누어보았을때 나머지가 0이 되는 수가 2개여야 함
```
if(primeCount == 2)
	count++;
```
1과 자기 자신으로만 나눠지는 것이 확인 되면 Count++

## 소스코드
```
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
```
