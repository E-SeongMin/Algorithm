import java.io.*;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] Arr = new int[N];
		for(int i=0; i<N; i++) 
			Arr[i] = Integer.parseInt(br.readLine());
		
		Bubble_Sort(N, Arr);
		
		for(int i=0; i<N; i++)
			System.out.println(Arr[i]);
	}
	
	public static int[] Bubble_Sort(int N, int[] Arr) {
		int temp;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(Arr[j] > Arr[j+1]) {
					temp = Arr[j];
					Arr[j] = Arr[j+1];
					Arr[j+1] = temp;
				}
			}
		}
		return Arr;
	}
}
