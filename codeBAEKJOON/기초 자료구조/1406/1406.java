import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();   // 문자열 입력
		char [] arr = str.toCharArray();
		int n = str.length();   // 문자열 길이
		int m = Integer.parseInt(br.readLine());   // 명령어 개수
		
		Stack <Character> left = new Stack <Character> ();
		Stack <Character> right = new Stack <Character> ();
		
		for(int i=0; i<n; i++)   // left 스택에 문자열 넣기
			left.push(arr[i]);
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("L")) {
				if(left.isEmpty())
					continue;
				else
					right.push(left.pop());
			}
			
			if(command.equals("D")) {
				if(right.isEmpty())
					continue;
				else
					left.push(right.pop());
			}
			
			if(command.equals("B")) {
				if(left.isEmpty())
					continue;
				else
					left.pop();
			}
			
			if(command.equals("P")) {
				char ch = st.nextToken().charAt(0);
				left.push(ch);
			}
			
		}
		
		while(!left.isEmpty())   // left를 pop하여 출력하면 거꾸로 나오기때문에 reverse
			right.push(left.pop());
		
		while(!right.isEmpty())   // reverse하여 문자열을 앞자리부터 출력
			bw.write(right.pop());
		
		bw.flush();
	}
}
