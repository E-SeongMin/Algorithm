# 문제 주소  
https://www.acmicpc.net/problem/10989

## 목표
가장 빠른 방법을 찾아 정렬하기

## 문제 해결
지난 정렬 알고리즘에서 사용했던 

  [ BefferedReader + Array + Quick_Sort ]
 
알고리즘은 시간초과가 발생하므로 더 빠른 방법을 찾아야함

#### 카운팅 정렬(Counting_Sort) 사용
 보통 정렬은 숫자들을 비교해 정렬하는 방식이지만
 카운팅 정렬은 숫자 빈도 수를 체크해서 그만큼의 수를 출력함

#### 정리
 1. 출력을 System.out.print -> BufferedWriter 로 변경
 2. 정렬 알고리즘을 Quick_Sort -> Counting 로 변경

## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args []) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] countArr = new int[10001];
		for(int i = 0; i < n; i++) 
			countArr[Integer.parseInt(br.readLine())-1]++;
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 10000; i++) {
			if(countArr[i] == 0)
				continue;
			else {
				for(int j = 0; j < countArr[i]; j++) {
					bw.write(i + 1 + "\n");
				}
			}
		}
		bw.flush();
	}
}
```
