# 문제 주소  
https://www.acmicpc.net/problem/1182

## 목표
백트래킹 이용한 부분수열의 합 찾기

## 문제 해결
재귀함수를 이용하여 탐색 도중 합이 S와 같은 경우 Count를 1씩 증가 후 Return
```
if(index == n) {
	if(sum == s) {
		count++;
	}
	return;	
}
```
## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int count = 0;
	public static int n, s;
	public static int [] arr;
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());	
		arr = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Backtracking(0, 0);
		
		if(s == 0) { // count 합이 0인 경우 공집합도 포함되므로 그 수를 뺌
			count--;
			System.out.println(count);
		}
		else
			System.out.println(count);
	}
	
	public static void Backtracking(int index, int sum) {
		if(index == n) {
			if(sum == s) {
				count++;
			}
			return;	
		}
		Backtracking(index + 1, sum + arr[index]); // 지금 위치의 원소를 선택
		Backtracking(index + 1, sum); // 선택하지 않음
	}
}
```
