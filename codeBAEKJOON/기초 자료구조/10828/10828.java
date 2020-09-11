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
