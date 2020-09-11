# 문제 주소  
https://www.acmicpc.net/problem/10828

## 목표
Stack 구현하기

## 문제 해결
자바 Stack 클래스 사용
```
psuh(Element item) -> 데이터 추가
pop() -> 최근에 추가된(Top) 데이터 삭제
peek() -> 최근에 추가된(Top) 데이터 조회
empty() -> Stack의 값이 비었는지 확인, 비었으면 true, 아니면 false 반환
search(Object o) -> 인자값으로 받은 데이터의 위치 반환
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack <Integer> st = new Stack <Integer>();
		String command = new String();
		
		for(int i=0; i<n; i++) {
			command = sc.next();
			
			if(command.equals("push"))
				st.push(sc.nextInt());

			if(command.equals("top")) {
				if(st.isEmpty())
					System.out.println(-1);
				else
					System.out.println(st.peek());
			}
			
			if(command.equals("size")) 
				System.out.println(st.size());
			
			
			if(command.equals("empty")) {
				if(st.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			
			if(command.equals("pop")) {
				if(st.isEmpty())
					System.out.println(-1);
				else
					System.out.println(st.pop());
			}
		}
	}
}
```
