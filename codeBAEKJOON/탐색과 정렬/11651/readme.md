# 문제 주소  
https://www.acmicpc.net/problem/11651

## 목표
좌표 정렬하기2


## 문제 해결
Comparator 객체를 Override 하여 사용
```
Arrays.sort(point, new Comparator<int []>() {
	public int compare(int [] e1, int [] e2) {
		if(e1[1] == e2[1])
			return Integer.compare(e1[0], e2[0]);
		return Integer.compare(e1[1], e2[1]);
	}
});
```
11651번 문제와 같은 알고리즘을 사용하지만 우선순위 첫번째를 y좌표로 해야함
```
if(e1[0] == e2[0])                               if(e1[1] == e2[1])
	return Integer.compare(e1[1], e2[1]);   ->   	return Integer.compare(e1[0], e2[0]); 
return Integer.compare(e1[0], e2[0]);            return Integer.compare(e1[1], e2[1]);
```

## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] point = new int [n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(point, new Comparator<int []>() {
			public int compare(int [] e1, int [] e2) {
				if(e1[1] == e2[1])
					return Integer.compare(e1[0], e2[0]);
				return Integer.compare(e1[1], e2[1]);
			}
		});
		
		for(int i=0; i<n; i++)
			bw.write(Integer.toString(point[i][0]) + " " + point[i][1] + "\n");
		
		bw.flush();
	}
}
```
