import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] point = new int [n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(point, new Comparator<int []>() {
			public int compare(int [] e1, int [] e2) {
				if(e1[1] == e2[1])
					return Integer.compare(e1[0], e2[0]);
				return Integer.compare(e1[1], e2[1]);
			}
		});
		
		for(int i=0; i<n; i++)
			bw.write(Integer.toString(point[i][0]) + " " + point[i][1] + "\n");
		
		bw.flush();
	}
}
