import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args []) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] countArr = new int[10001];
		for(int i = 0; i < n; i++) 
			countArr[Integer.parseInt(br.readLine())-1]++;
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 10000; i++) {
			if(countArr[i] == 0)
				continue;
			else {
				for(int j = 0; j < countArr[i]; j++) {
					bw.write(i + 1 + "\n");
				}
			}
		}
		bw.flush();
	}
}
