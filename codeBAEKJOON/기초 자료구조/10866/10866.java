import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int num = 0;
		
		Deque <Integer> dq = new LinkedList <Integer>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
			}
			
			if(str.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
			}
			
			if(str.equals("pop_front")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.pop()) + "\n");
			}
			
			if(str.equals("pop_back")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.removeLast()) + "\n");
			}
			
			if(str.equals("size")) 
				bw.write(Integer.toString(dq.size()) + "\n");
			
			if(str.equals("empty")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(1) + "\n");
				else
					bw.write(Integer.toString(0) + "\n");
			}
			
			if(str.equals("front")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.peekFirst()) + "\n");
			}
			
			if(str.equals("back")) {
				if(dq.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(dq.peekLast()) + "\n");
			}
			bw.flush();
		}
	}
}
