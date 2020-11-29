# 문제 주소  
https://www.acmicpc.net/problem/2485

## 목표
모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하기

## 문제 해결
유클리드 호제법을 사용하여 최대공약수를 구하는 방법을 사용함
```
public static int Euclidean(int a, int b) {
	if(b == 0)
		return a;
	else
		return Euclidean(b, a%b);
}
```
입력받은 각각의 자릿값 사이 거리를 Distance[] 배열에 저장 후 최대공약수를 구함
```
int gcd = distance[n-2];
for(int i=n-3; i>=0; i--)
	gcd = Euclidean(gcd, distance[i]);
``
그 후 가로수 전체의 거리를 해당 공약수로 나누면 총 가로수의 갯수가 나옴. 먼저 심어진 가로수 갯수를 빼면 됨.

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] distance = new int [n-1];
		int temp = Integer.parseInt(br.readLine());
		int first = temp;
		int temp2;
		for(int i=0; i<n-1; i++) {
			temp2 = Integer.parseInt(br.readLine());
			distance[i] = temp2 - temp;
			temp = temp2;
		}
		
		int gcd = distance[n-2];
		for(int i=n-3; i>=0; i--)
			gcd = Euclidean(gcd, distance[i]);
		
		int total_gap = temp - first;
		int count = (total_gap / gcd) - n+1;
		
		System.out.println(count);
	}
	
	public static int Euclidean(int a, int b) {
		if(b == 0)
			return a;
		else
			return Euclidean(b, a%b);
	}
}
```
