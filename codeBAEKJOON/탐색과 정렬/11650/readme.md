# 문제 주소  
https://www.acmicpc.net/problem/11650

## 목표
좌표 정렬하기


## 문제 해결
Comparator 객체를 Override 하여 사용
```
Arrays.sort(point, new Comparator<int []>() {
	public int compare(int [] e1, int [] e2) {
		if(e1[0] == e2[0])                         // x 좌표값이 같은가?
			return Integer.compare(e1[1], e2[1]);   // y 좌표 비교하여 정렬
		return Integer.compare(e1[0], e2[0]);   // x 좌표 비교하여 정렬 
	}
});
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
				if(e1[0] == e2[0])
					return Integer.compare(e1[1], e2[1]);
				return Integer.compare(e1[0], e2[0]);
			}
		});
		
		for(int i=0; i<n; i++)
			bw.write(Integer.toString(point[i][0]) + " " + point[i][1] + "\n");
		
		bw.flush();
	}
}
```
