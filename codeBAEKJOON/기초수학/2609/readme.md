# 문제 주소  
https://www.acmicpc.net/problem/2609

## 목표
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램 작성

## 문제 해결
유클리드 호제법
```
1. 매개변수로 a와 b를 받는다.
2. b가 0이라면 a가 최대 공약수이다.
3. b가 0이 아니라면 매개변수로 b와 a%b를 받는다.
4. 위 과정을 반복한다.
```
위 과정을 코드로 작성하면
```
public static int Euclidean(int a, int b) {
	if(b == 0)
		return a;
	else 
		return Euclidean(b, a%b);
}
```
최소 공배수는 "정수 a * 정수 b / 최대공약수" 이므로 유클리드 호제법을 통해 구한 최대공약수를 활용함

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int gcf = Euclidean(m, n);   // Greatest Common Factor (최대공약수)
		int lcm = m * n / gcf;   // Least Common Multiple (최소공배수)
		
		System.out.println(gcf + "\n" + lcm);
	}
	
	public static int Euclidean(int a, int b) {
		if(b == 0)
			return a;
		else 
			return Euclidean(b, a%b);
	}
}
```
