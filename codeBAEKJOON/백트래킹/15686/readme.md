# 문제 주소  
https://www.acmicpc.net/problem/15686

## 목표
가정집과 치킨집의 거리를 최대한 가깝게 만들 수 있는 M개의 치킨집 고르기

## 문제 해결
백트래킹을 이용하여 이차원 배열 map[][] 의 2 (치킨집) 를 탐색하다 m 개가 되면 가정집과 가장 가까운 치킨집 사이의 거리를 구함.
```
public static void Backtracking(int index, int count) {
	if(count == m) {
		getDistance();
		return;
	}
	for(int i=index; i<chicken.size(); i++) {
		visit[i] = true;
		Backtracking(i+1, count+1);
		visit[i] = false;
	}
}
``` 
Math.min() 메소드를 이용하여 한 가정집에 가장 가까운 치킨집의 거리를 구하고 이를 sum에 더함. 그 후 다음 가정집도 이 과정을 반복.
```
public static void getDistance() {
	int sum = 0;
	for(int i=0; i<house.size(); i++) {
		int distance = Integer.MAX_VALUE;
		for(int j=0; j<chicken.size(); j++) {
			if(visit[j]) {
				distance = Math.min(distance, Math.abs(house.get(i).x - chicken.get(j).x) 
							+ Math.abs(house.get(i).y - chicken.get(j).y));
			}
		}
		sum += distance;
	}
	min = Math.min(min, sum);
	return;
}
```
마지막 가정집까지 모두 검색 후 해당 값이 기존의 min 값보다 더 작으면 가장 작은 도시의 치킨거리가 됨.

## 소스코드
```
import java.io.*;
import java.util.*;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int [][] map;   // 0 은 빈칸, 1 은 집, 2 는 치킨집
	public static int n, m;   // n은 배열의 크기, m은 남길 치킨집 갯수
	public static int min = Integer.MAX_VALUE;   // 답
	public static boolean [] visit;   // 치킨집 다 돌았는지 확인
	public static ArrayList <Point> house;
	public static ArrayList <Point> chicken;
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n+1][n+1];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1)
					house.add(new Point(i, j));
				if(map[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}
		visit = new boolean [chicken.size()];   // 치킨집 갯수만큼 배열 크기 선언
		
		Backtracking(0, 0);
		
		System.out.println(min);
	}
	
	public static void Backtracking(int index, int count) {
		if(count == m) {
			getDistance();
			return;
		}

		for(int i=index; i<chicken.size(); i++) {
			visit[i] = true;
			Backtracking(i+1, count+1);
			visit[i] = false;
		}
	}
	
	public static void getDistance() {
		int sum = 0;
		for(int i=0; i<house.size(); i++) {
			int distance = Integer.MAX_VALUE;
			for(int j=0; j<chicken.size(); j++) {
				if(visit[j]) {
					distance = Math.min(distance, Math.abs(house.get(i).x - chicken.get(j).x) 
							+ Math.abs(house.get(i).y - chicken.get(j).y));
				}
			}
			sum += distance;
		}
		min = Math.min(min, sum);
		return;
	}
}
```
