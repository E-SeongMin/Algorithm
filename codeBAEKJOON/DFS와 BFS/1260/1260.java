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
