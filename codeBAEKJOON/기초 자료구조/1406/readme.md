# 문제 주소  
https://www.acmicpc.net/problem/1406

## 목표
자료구조를 이용하여 에디터 구현하기

## 문제 해결
'Character'형 Stack 두개 활용
```
Stack <Character> left = new Stack <Character> ();
Stack <Character> right = new Stack <Character> ();
```
```
문자열 입력 이후 커서는 맨 오른쪽에 존재해야 하므로 FILO 구조인 스택으로
이를 구현해내기 위해 먼저 Left 스택에 문자열을 넣고, 왼쪽으로 커서 이동 시
이동한 커서의 오른쪽에 있는 문자는 Stack 에 임시로 저장해 두는 것이다.
```
## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();   // 문자열 입력
		char [] arr = str.toCharArray();
		int n = str.length();   // 문자열 길이
		int m = Integer.parseInt(br.readLine());   // 명령어 개수
		
		Stack <Character> left = new Stack <Character> ();
		Stack <Character> right = new Stack <Character> ();
		
		for(int i=0; i<n; i++)   // left 스택에 문자열 넣기
			left.push(arr[i]);
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("L")) {
				if(left.isEmpty())
					continue;
				else
					right.push(left.pop());
			}
			
			if(command.equals("D")) {
				if(right.isEmpty())
					continue;
				else
					left.push(right.pop());
			}
			
			if(command.equals("B")) {
				if(left.isEmpty())
					continue;
				else
					left.pop();
			}
			
			if(command.equals("P")) {
				char ch = st.nextToken().charAt(0);
				left.push(ch);
			}
			
		}
		
		while(!left.isEmpty())   // left를 pop하여 출력하면 거꾸로 나오기때문에 reverse
			right.push(left.pop());
		
		while(!right.isEmpty())   // reverse하여 문자열을 앞자리부터 출력
			bw.write(right.pop());
		
		bw.flush();
	}
}
```
