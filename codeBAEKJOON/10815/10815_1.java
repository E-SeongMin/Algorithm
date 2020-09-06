import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int []card = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) 
			card[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(card);
		
		int m = Integer.parseInt(br.readLine());
		int []search = new int[m];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int i=0; i<m; i++)
			search[i] = Integer.parseInt(st2.nextToken());
		
		br.close();
		
		for(int i=0; i<m; i++)
			bw.write(0 + BinarySearch(search[i], card) + " ");
		
		bw.close();	
	}
	
	public static int BinarySearch(int key, int arr[]) {
		int mid;
		int left = 0;
		int right = arr.length-1;
		
		while(right >= left) {
			mid = (right + left) / 2;
			
			if(key < arr[mid])
				right = mid - 1;
			else if(key > arr[mid])
				left = mid + 1;
			else
				return 1;
		}
		return 0;
	}
}
