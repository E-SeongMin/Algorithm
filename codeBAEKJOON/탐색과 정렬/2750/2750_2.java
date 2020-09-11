import java.util.*;
import java.io.*;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] Arr = new int[N];
		for(int i=0; i<N; i++) 
			Arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(Arr);
		
		for(int i=0; i<N; i++)
			System.out.println(Arr[i]);
	}
}
