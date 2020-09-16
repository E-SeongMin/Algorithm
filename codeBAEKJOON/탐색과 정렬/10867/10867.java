import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		bw.write(Integer.toString(arr[0]) + " ");
		for(int i=1; i<n; i++) {
			if(arr[i-1] != arr[i])
				bw.write(Integer.toString(arr[i]) + " ");
			else
				continue;
		}
		bw.flush();
	}
}
