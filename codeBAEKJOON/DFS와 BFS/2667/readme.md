# 문제 주소  
https://www.acmicpc.net/problem/2667

## 목표
단지 번호 

## 문제 해결
DFS나 BFS로 인접해있는 그룹의 갯수와 크기를 구하는 문제
필자는 DFS가 손에 익어서 DFS로 구현

## 결과
![image](https://user-images.githubusercontent.com/42796952/117265018-c514dd00-ae8e-11eb-95c7-ad0495897bf3.png)

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int [] dx = {-1, 1, 0, 0};   // 상하좌우
	public static int [] dy = {0, 0, -1, 1};
	public static int [][] map;
	public static boolean [][] visited;
	public static int n, count = 0;
	public static ArrayList<Integer> result;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++)
				map[i][j] = str.charAt(j)-'0';
		}
		
//		입력값 확인
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++)
//				System.out.print(map[i][j]);
//			System.out.println();
//		}
		
		result = new ArrayList<Integer>();
		
		// 맵 탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 현재 위치 값이 1 이고 true 라면
				if(map[i][j] == 1 && visited[i][j] == false) {
					count = 1;
					DFS(i, j);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		
		for(int i=0; i<result.size(); i++) 
			System.out.println(result.get(i));
	}
	private static int DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int ddx = x + dx[i];
			int ddy = y + dy[i];
			
			if(ddx >= 0 && ddy >= 0 && ddx < n &&  ddy < n) {
				if(map[ddx][ddy] == 1 && visited[ddx][ddy] == false) {
					DFS(ddx, ddy);
					count++;
				}
			}
		}
		
		return count;
	}
}
```
