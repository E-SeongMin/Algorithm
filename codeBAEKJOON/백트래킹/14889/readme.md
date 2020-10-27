# 문제 주소  
https://www.acmicpc.net/problem/14889

## 목표
N명의 사람을 두 팀으로 나누기 (능력치를 비교하여 차이를 최소화) 

## 문제 해결
백트래킹 사용
```
public static void Backtracking(int index, int depth) {
	if(depth == n/2) {
		getDifference();
		return;
	}
	for(int i=index; i<n; i++) {
		visited[i] = true;
		Backtracking(i+1, depth+1);
		visited[i] = false;
	}
}
```
visited[] 배열의 True는 스타트팀, False는 링크 팀으로 나눔
```
public static void getDifference() {
	int sTeam = 0;   // 스타트 팀 점수
	int lTeam = 0;   // 링크 팀 점수
	
	for(int i=0; i<n; i++) {
		if(visited[i]) {    // true는 스타트 팀
			for(int j=0; j<n; j++) {
				if(i == j)
					continue;
				if(visited[i] && visited[j])
					sTeam += arr[i][j];
			}
		}
		else {              // false는 링크 팀
			for(int j=0; j<n; j++) {
				if(i == j)
					continue;
				if(!visited[i] && !visited[j])
					lTeam += arr[i][j];
			}
		}
	}
		
	min = Math.min(min, Math.abs(sTeam - lTeam));   // 두 팀의 점수차이
	return;
}
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int [][] arr;
	public static boolean [] visited;
	public static int n;
	public static int min = Integer.MAX_VALUE;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Backtracking(0, 0);
		
		System.out.println(min);
	}
	
	public static void Backtracking(int index, int depth) {
		if(depth == n/2) {
			getDifference();
			return;
		}

		for(int i=index; i<n; i++) {
			visited[i] = true;
			Backtracking(i+1, depth+1);
			visited[i] = false;
		}
	}

	
	public static void getDifference() {
		int sTeam = 0;   // 스타트 팀 점수
		int lTeam = 0;   // 링크 팀 점수
		
		for(int i=0; i<n; i++) {
			if(visited[i]) {    // true는 스타트 팀
				for(int j=0; j<n; j++) {
					if(i == j)
						continue;
					if(visited[i] && visited[j])
						sTeam += arr[i][j];
				}
			}
			else {              // false는 링크 팀
				for(int j=0; j<n; j++) {
					if(i == j)
						continue;
					if(!visited[i] && !visited[j])
						lTeam += arr[i][j];
				}
			}
		}
		
		min = Math.min(min, Math.abs(sTeam - lTeam));
		return;
	}
}
```
