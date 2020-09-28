import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int a=0; a<testcase; a++) {
			LinkedList<Integer> priority = new LinkedList<Integer>();
			Queue<Integer> Q = new LinkedList<Integer>();
			int count = 0;
			boolean isMax;
			
			String[] input = br.readLine().split(" ");
			String[] priority_str = br.readLine().split(" ");
			
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]) + 1;
			
			for(int i=0; i<n; i++)
				priority.add(Integer.parseInt(priority_str[i]));
			
			for(int i=0; i<n; i++)
				Q.offer(i+1);
		
			for(int i=0; !Q.isEmpty(); ) {
				isMax = true;
				for(int j=i; j<Q.size(); j++) {
					if(priority.get(i) < priority.get(j)) {
						priority.offer(priority.poll());
						Q.offer(Q.poll());
						
						isMax = false;
						break;
					}
				}
				
				if(isMax) {
					count++;
					priority.poll();
					if(Q.poll() == m) {
						System.out.println(count);
						break;
					}
				}
			}
		}
	}
}
