# 문제 주소  
https://www.acmicpc.net/problem/1874

## 목표
1 부터 n 까지의 수를 스택에 Push 했다가 Pop 함으로써 입력받은 값과 같은 수열을 만들수 있는지 알아내기

## 문제 해결
Stack 의 Top 부분과 입력된 수열의 n 부분이 같을 경우 해당 부분의 Top을 Pop
```
for(int i=1; i<n+1; i++) {
  stack.push(i);
  arrl.add("+");
  while(!stack.isEmpty() && arr[j] == stack.peek()) {
     stack.pop();
	  arrl.add("-");
	  j++;
  }
}
```
다음 n 자리의 수열과 같은지 확인하며 Pop하다 다를경우 다시 Push 작업 시작

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int n = Integer.parseInt(br.readLine());
      int [] arr = new int [n+1];
      int num = 0;
	   Stack <Integer> stack = new Stack<>();
	   ArrayList <String> arrl = new ArrayList<>();
	  
      for(int i=0; i<n; i++)
    	  arr[i] = Integer.parseInt(br.readLine());
      
      int j = 0;
      
      for(int i=1; i<n+1; i++) {
    	  stack.push(i);
    	  arrl.add("+");
    	  while(!stack.isEmpty() && arr[j] == stack.peek()) {
    		  stack.pop();
    		  arrl.add("-");
    		  j++;
    	  }
      }
      
      if(!stack.isEmpty())
    	  bw.write("NO\n");
      else {
    	  for(int i=0; i<arrl.size(); i++)
    		  bw.write(arrl.get(i) + "\n");
      }
      
      bw.close();   
   }
}
```
