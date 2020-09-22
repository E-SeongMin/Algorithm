# 문제 주소  
https://www.acmicpc.net/problem/9012

## 목표
괄호만으로 이루어진 문자열 VPS 확인

## 문제 해결
VPS란 Valid PS 의 약자로 여는 괄호와 닫는 괄호가 한쌍을 이루는 문자열
```
for(int j=0; j<st.length(); j++) {
    if(c[j] == '(')
    	count++;
}

for(int j=0; j<st.length(); j++) {
   	if(c[j] == ')')
	    count--;
}
```
처음은 '(' 와 ')' 의 갯수를 비교하는 식으로 접근하였으나 '예제2'의 경우 오류가 발생
```
for(int j=0; j<st.length(); j++) {
  if(c[j] == '(')      
	  stack.push(c[j]);     // "(" 가 입력되면 Push
  else if(c[j] == ')') {    // ")" 가 입력됬을 때
	  if(!stack.isEmpty())    // 스택에 "(" 가 있으면    
		  stack.pop();        // 스택을 Pop
	  else {                  // 스택이 비었으면
		  VPS = false;        // VPS 상태를 false 로
		  break;              // 반복을 종료
	  }
  }
}  
```
따라서 스택 구조를 이용하여 문제를 풀었고 괄호 입력시 "("가 없을 때 ")" 가 들어오면 VPS 를 false
```
if(!stack.isEmpty())     // 입력이 끝나고도 "(" 가 남아있으면
  VPS = false;            // VPS 상태를 false 로
```
괄호 입력이 끝나고도 스택에 "(" 가 남아있을 시 VPS 를 false 주는 방법으로 해결

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int n = Integer.parseInt(br.readLine());
     
      for(int i=0; i<n; i++) {
    	  boolean VPS = true;
    	  String st = br.readLine();
    	  Stack <Character> stack = new Stack<>();
    	  char[] c = st.toCharArray();
    	  
    	  for(int j=0; j<st.length(); j++) {
    		  if(c[j] == '(')      
    			  stack.push(c[j]);     // "(" 가 입력되면 Push
    		  else if(c[j] == ')') {    // ")" 가 입력됬을 때
    			  if(!stack.isEmpty())    // 스택에 "(" 가 있으면    
    				  stack.pop();        // 스택을 Pop
    			  else {                  // 스택이 비었으면
    				  VPS = false;        // VPS 상태를 false 로
    				  break;              // 반복을 종료
    			  }
    		  }
    	  }  
    	  
    	  if(!stack.isEmpty())     // 입력이 끝나고도 "(" 가 남아있으면
    		  VPS = false;            // VPS 상태를 false 로
    	  
    	  if(VPS)
			  bw.write("YES\n");
    	  else
    		  bw.write("NO\n");
      }
      bw.close();   
   }
}
```
