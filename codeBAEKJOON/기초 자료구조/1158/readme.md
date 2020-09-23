# 문제 주소  
https://www.acmicpc.net/problem/1158

## 목표
요세푸스 순열 구하기 (원형 Queue의 삭제 활용)

## 문제 해결
Poll() -> 맨 앞의 값을 pop   /   Offer() -> 맨 뒤로 값을 push
```
while(!q.isEmpty()) {
   for(int i=1; i<=k; i++) {
     if(i == k) {
   	  result += Integer.toString(q.poll());
        result += ", ";
     }
     else 
   	  q.offer(q.poll());    
   }
}
```


## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      Queue <Integer> q = new LinkedList<>();
      
      for(int i=1; i<n+1; i++)
    	  q.offer(i);
      
      String result = new String();
      result += "<";
      
      while(!q.isEmpty()) {
    	  for(int i=1; i<=k; i++) {
    		  if(i == k) {
    			  result += Integer.toString(q.poll());
    			  result += ", ";
    		  }
    		  else 
    			  q.offer(q.poll());    
    	  }
      }
      
      result = result.substring(0, result.length()-2);
      result += ">";
      
      bw.write(result);
        
      bw.close();   
   }
}
```
