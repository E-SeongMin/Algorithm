# 문제 주소  
https://www.acmicpc.net/problem/9663

## 목표
백트래킹 이용하여 조건부 탐색

## 문제 해결
일차원 배열 arr[] 로 이차원 배열을 구현
```
arr = new int[n];    // 각 원소의 index -> 열 
                     // 원소 값 -> 행	
```
퀸은 가로, 세로, 대각선으로 움직일 수 있음. 따라서 IF문을 통해 이를 검사함.
```
public static boolean isQueenOk(int col) {
	for(int i=0; i<col; i++) {
		if(arr[col] == arr[i])   // 같은 행에 존재하는가?
			return false;
		else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i]))   // 대각선에 존재하는가?
			return false;
	}
	return true;   // 아니면 놓을 수 있음
}
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int [] arr;
	public static int n;
	public static int count = 0;
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		arr = new int[n];    // 각 원소의 index -> 열 
		                     // 원소 값 -> 행	
		Backtracking(0);
		System.out.println(count);
    }
	
	public static void Backtracking (int col) {
		if(col == n) {
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[col] = i;
			if(isQueenOk(col))   // 퀸을 둘 수 있는가?
				Backtracking(col+1);
		}
	}
	
	public static boolean isQueenOk(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col] == arr[i])   // 같은 행에 존재하는가?
				return false;
			else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i]))   // 대각선에 존재하는가?
				return false;
		}
		return true;   // 아니면 놓을 수 있음
	}
}
```
