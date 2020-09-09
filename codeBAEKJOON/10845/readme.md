# 문제 주소  
https://www.acmicpc.net/problem/10845

## 목표
Queue 구현하기

## 문제 해결
자바 Queue 클래스 사용
```
offer(Object o) -> 해당 큐의 맨 뒤에 전달된 요소를 삽입함
poll() -> 해당 큐의 제일 먼저 저장된 요소를 반환하고, 해당 요소를 제거함
peek() -> 해당 큐의 제일 먼저 저장된 요소를 반환함
```
"back" 명령어는 메소드로 구현할 수 없으므로 "push" 명령 시 입력받은 값을 저장해놓고 사용해야함

## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue <Integer> q = new LinkedList<>();
		
		int n = sc.nextInt();
		int num = 0;
		
		for(int i=0; i<n; i++) {
			String command = sc.next();
			
			if(command.equals("push")) {
				num = sc.nextInt();
				q.offer(num);
			}
			
			if(command.equals("pop")) {
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
			}
			
			if(command.equals("size"))
				System.out.println(q.size());
			
			if(command.equals("empty")) {
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			
			if(command.equals("front")) {
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
			}
			
			if(command.equals("back")) {
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(num);
			}
		}
	}
}
```
