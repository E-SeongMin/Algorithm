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
