import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int testcase = Integer.parseInt(br.readLine());  // TestCase 수
      
      for(int i=0; i<testcase; i++) {
    	  /* 입력 부분 */
          char [] p = br.readLine().toCharArray();   // 수행할 함수
          int n = Integer.parseInt(br.readLine());   // 배열의 크기
          String arr_str = br.readLine();   // 배열 [X1, X2, ... , Xn]
        	  
          arr_str = arr_str.substring(1, arr_str.length()-1);
          String [] arr = arr_str.split(",");
          // 입력받은 배열 정리 -> arr[0] -> X1, arr[1] -> X2, ...
      
          LinkedList <Integer> q = new LinkedList<>();
          
          if(n != 0) {
              for(int j=0; j<arr.length; j++)
            	  q.offer(Integer.parseInt(arr[j]));
          }
          
          boolean isReverse = false;
          boolean isError = false;
          
          for(int j=0; j<p.length; j++) {
        	  if(p[j] == 'R')
        		  isReverse = !isReverse;
        	  
        	  if(p[j] == 'D') {
        		  if(!q.isEmpty()) {
            		  if(isReverse)
            			  q.removeLast();
            		  else
            			  q.removeFirst();
        		  }
        		  else {
        			  System.out.println("error");
        			  isError = true;
        			  break;
        		  }
        	  }
          }
          
          boolean isEmpty = true;
          
          if(!isError) {
        	  if(!isReverse) {
                  StringBuilder sb = new StringBuilder();
            	  sb.append("[");
                  while(!q.isEmpty()) {
                	  sb.append(Integer.toString(q.poll()) + ",");
                	  isEmpty = false;
                  }
                  if(!isEmpty)
                	  sb.delete(sb.length()-1, sb.length());
                  sb.append("]");
                  System.out.println(sb);
              }
              else {
            	  StringBuilder sb = new StringBuilder();
            	  sb.append("[");
                  while(!q.isEmpty()) {
                	  sb.append(Integer.toString(q.pollLast()) + ",");
                	  isEmpty = false;
                  }
                  if(!isEmpty)
                	  sb.delete(sb.length()-1, sb.length());
                  sb.append("]");
                  System.out.println(sb);
              }
          }
      }
   }
}
