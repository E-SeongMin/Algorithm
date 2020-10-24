# 문제 주소  
https://www.acmicpc.net/problem/1037

## 목표
약수가 주어졌을 때 해당 정수 찾기

## 문제 해결
진짜 약수(1을 제외한 약수)의 가장 작은 수와 가장 큰 수를 곱함.
```
Arrays.sort(divisor);
System.out.print(divisor[0]*divisor[n-1]);
```
Arrays.sort() 메소드를 이용하여 오름차순 정렬 후 배열의 첫번째와 마지막을 곱

## 소스코드
```
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
```
