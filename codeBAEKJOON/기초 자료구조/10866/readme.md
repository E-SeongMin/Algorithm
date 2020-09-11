# 문제 주소  
https://www.acmicpc.net/problem/10866

## 목표
Deque 구현하기

## 문제 해결
자바 Deque 클래스 사용
```
addFirst() -> 덱의 앞 쪽에 Element를 삽입
addLast() -> 덱의 뒷 쪽에 Element를 삽입
removeFirst() -> 덱 앞 쪽에서 Element를 하나 뽑아 제거한 다음 리턴
removeLast() -> 덱 뒷 쪽에서 Element를 하나 뽑아 제거한 다음 리턴
peekFirst() -> 덱 앞 쪽의 Element를 리턴. 제거 x
peekLast() -> 덱 뒷 쪽의 Element를 리턴, 제거 x
size() -> 덱의 크기 리턴
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
		int num = 0;
		
		Deque <Integer> dq = new LinkedList <Integer>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
			}
			
			if(str.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
			}
			
			if(str.equals("pop_front")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.pop()) + "\n");
			}
			
			if(str.equals("pop_back")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.removeLast()) + "\n");
			}
			
			if(str.equals("size")) 
				bw.write(Integer.toString(dq.size()) + "\n");
			
			if(str.equals("empty")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(1) + "\n");
				else
					bw.write(Integer.toString(0) + "\n");
			}
			
			if(str.equals("front")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.peekFirst()) + "\n");
			}
			
			if(str.equals("back")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.peekLast()) + "\n");
			}
			bw.flush();
		}
	}
}
```
