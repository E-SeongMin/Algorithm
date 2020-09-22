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
