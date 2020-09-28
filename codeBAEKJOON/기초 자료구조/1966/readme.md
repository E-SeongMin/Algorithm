# 문제 주소  
https://www.acmicpc.net/problem/1966

## 목표
Queue 자료 구조를 이용한 자리 찾기

## 문제 해결
LinkedList 두 개 생성 후 첫번째는 입력 값, 두번째는 인덱스 값을 넣음
```
for(int i=0; i<n; i++)
	priority.add(Integer.parseInt(priority_str[i]));
	
for(int i=0; i<n; i++)
	Q.offer(i+1);
```
입력 값 Priority 를 내림차순으로 Poll 하고, Count 증가
```
for(int i=0; !Q.isEmpty(); ) {
	isMax = true;
	for(int j=i; j<Q.size(); j++) {
		if(priority.get(i) < priority.get(j)) {
			priority.offer(priority.poll());
			Q.offer(Q.poll());
				
			isMax = false;
			break;
		}
	}
			
	if(isMax) {
		count++;
		priority.poll();
		...
	}
}
```
이 때 Index 값이 M과 같으면 반복을 멈추고 증가된 Count 출력
```
if(Q.poll() == m) {
	System.out.println(count);
	break;
}
```
모든 과정을 N 번 반복

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int a=0; a<testcase; a++) {
			LinkedList<Integer> priority = new LinkedList<Integer>();
			Queue<Integer> Q = new LinkedList<Integer>();
			int count = 0;
			boolean isMax;
			
			String[] input = br.readLine().split(" ");
			String[] priority_str = br.readLine().split(" ");
			
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]) + 1;
			
			for(int i=0; i<n; i++)
				priority.add(Integer.parseInt(priority_str[i]));
			
			for(int i=0; i<n; i++)
				Q.offer(i+1);
		
			for(int i=0; !Q.isEmpty(); ) {
				isMax = true;
				for(int j=i; j<Q.size(); j++) {
					if(priority.get(i) < priority.get(j)) {
						priority.offer(priority.poll());
						Q.offer(Q.poll());
						
						isMax = false;
						break;
					}
				}
				
				if(isMax) {
					count++;
					priority.poll();
					if(Q.poll() == m) {
						System.out.println(count);
						break;
					}
				}
			}
		}
	}
}
```
