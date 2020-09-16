# 문제 주소  
https://www.acmicpc.net/problem/10867

## 목표
중복빼고 정렬하기

## 문제 해결
출력에서 반복된 정수를 제외시킴
```
for(int i=1; i<n; i++) {
	if(arr[i-1] != arr[i])
		bw.write(Integer.toString(arr[i]) + " ");
	else
		continue;
}
```
문제에서 의도한 것이 이것은 아니겠지만 이 방법이 더 빠를 것으로 예상

## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		bw.write(Integer.toString(arr[0]) + " ");
		for(int i=1; i<n; i++) {
			if(arr[i-1] != arr[i])
				bw.write(Integer.toString(arr[i]) + " ");
			else
				continue;
		}
		bw.flush();
	}
}
```
