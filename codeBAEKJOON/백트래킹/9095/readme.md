# 문제 주소  
https://www.acmicpc.net/problem/9095

## 목표
백트래킹 이용한 부분수열의 합 찾기 2

## 문제 해결
재귀함수를 이용하여 탐색
```
public static void Backtracking(int target, int now) {
	if(target < now)
		return;
	
	if(target == now) {
		count++;
		return;
	}
	else {
		Backtracking(target, now + 1);
		Backtracking(target, now + 2);
		Backtracking(target, now + 3);
	}
}
```
재귀를 통해 찾던 중 target보다 커질 경우 return으로 종료 

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int count;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			count = 0;
			int n = Integer.parseInt(br.readLine());
			Backtracking(n, 0);
			
			System.out.println(count);
		}
	}
	
	public static void Backtracking(int target, int now) {
		if(target < now)
			return;
		
		if(target == now) {
			count++;
			return;
		}
		else {
			Backtracking(target, now + 1);
			Backtracking(target, now + 2);
			Backtracking(target, now + 3);
		}
	}
}
```
