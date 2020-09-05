import java.util.*;
import java.io.*;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		arr = Quick_Sort(arr, 0, N-1);
		
		for(int i=0; i<N; i++)
			System.out.println(arr[i]);
	}
	
	public static int [] Quick_Sort(int [] arr, int start, int end) {
		int p = partition(arr, start, end);
		if(start < p-1)
			Quick_Sort(arr, start, p-1);
		if(p < end)
			Quick_Sort(arr, p, end);
		return arr;
	}
	
	public static int partition(int [] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while(start <= end) {
			while(arr[start] < pivot)
				start++;
			while(arr[end] > pivot) 
				end--;
			if(start <= end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start++;
				end--;
			}
		}
		return start;
	}
}
