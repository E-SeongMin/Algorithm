# 문제 주소  
https://www.acmicpc.net/problem/6603

## 목표
백트래킹 이해하기

## 문제 해결
재귀 이용
```
public static void Backtracking(int v, int count, String result) {
	if(v == n) {
		if(count == MAX)
			System.out.println(result);
	}
	else {
		// 해당 인덱스를 선택하거나
		Backtracking(v+1, count+1, result + arr[v] + " "); 
		// 선택하지 않거나
		Backtracking(v+1, count, result);
	}
}
```

## 소스코드
```
import java.io.*;
import java.util.*;


public class Main {
	public static int MAX = 6;
	public static int n;
	public static int [] arr;
	
	public static void Backtracking(int v, int count, String result) {
		if(v == n) {
			if(count == MAX)
				System.out.println(result);
		}
		else {
			Backtracking(v+1, count+1, result + arr[v] + " ");
			Backtracking(v+1, count, result);
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0)
				break;
				
			arr = new int [n];
			
			for(int i=0; i<n; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			Backtracking(0, 0, "");
		
			System.out.println();
		}
	}
}
```
