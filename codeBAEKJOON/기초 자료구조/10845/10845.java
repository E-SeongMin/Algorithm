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
