# 문제 주소  
https://www.acmicpc.net/problem/1260

## 목표
DFS탐색과 BFS탐색 구현

## 문제 해결
깊이우선탐색(DFS)
```
루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(Branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법

* 장점
 - 현 경로상의 노드를 기억하기 때문에 적은 메모리를 사용
 - 찾으려는 노드가 깊은 단계에 있는 경우 BFS보다 빠르게 찾을 수 있음
* 단점
 - 해가 없는 경로를 탐색할 경우 단계가 끝날 때까지 탐색함. 효율성을 높이기 위해서 미리 지정한 임의 깊이까지만 탐색하고
   해를 발견하지 못하면 빠져나와 다른 경로를 탐색하는 방법을 사용함
 - DFS를 통해서 얻어진 해가 최단 경로라는 보장이 없음. 
```

너비우선탐색(BFS)
```
루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

* 장점
 - 답이 되는 경로가 여러 개인 경우에도 최단경로임을 보장함
 - 최단 경로가 존재하면 깊이가 무한정 깊어진다고 해도 답을 찾을 수 있음
* 단점
 - 경로가 매우 길 경우에는 탐색가지가 급격히 증가함에 따라 보다 많은 메모리를 필요하게 됨
 - 해가 존재하지 않는다면 유한그래프의 경우에는 모든 그래프를 탐색한 후에 실패로 끝남
 - 무한 그래프의 경우에는 결코 해를 찾지도 못하고, 끝내지도 못함
```

DFS vs BFS 탐색 차이
```
* DFS는 스택(혹은 재귀), BFS는 큐를 사용함
* BFS는 재귀적으로 동작하지 않음
* 최단거리 문제를 푼다면 BFS를 사용
* 이동할 때마다 가중치가 붙어서 이동한다거나 이동 과정에서 여러 제약이 있을 경우 DFS로 구현하는 것이 좋음
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	static int map [][];
	static boolean [] visit;
	static int n, m, v;
	
	public static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		for(int i=1; i<n+1; i++) {
			if(map[v][i] == 1 && visit[i] == false)
				dfs(i);
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		visit[v] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int i=1; i<=n; i++) {
				if(map[temp][i] == 1 && visit[i] == false) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());   // 정점의 개수
		m = Integer.parseInt(st.nextToken());   // 간선의 개수
		v = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호
		
		map = new int[n+1][n+1];   // 인접한 간선
		visit = new boolean[n+1];   // 지나간 정점
		for(int i=0; i<n+1; i++)
			Arrays.fill(map[i], 0);
		Arrays.fill(visit, false);
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);
	}
}
```
