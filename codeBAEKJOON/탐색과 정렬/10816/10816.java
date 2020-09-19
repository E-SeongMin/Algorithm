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
      
      for(int i=0; i<m; i++)
         bw.write(Search(search[i], card) + " ");
      
      bw.close();   
   }
   
   public static int Search(int key, int arr[]) {
      int low = Lower(arr, 0, arr.length, key);
      int high = Upper(arr, 0, arr.length, key);
      return high - low;
   }
   
   public static int Lower(int arr[], int left, int right, int key) {
      int mid;
      while(left < right) {
         mid = (left + right) / 2;
         if(arr[mid] < key)
            left = mid + 1;
         else
            right = mid;
      }
      return right;
   }
   
   public static int Upper(int arr[], int left, int right, int key) {
      int mid;
      while(left < right) {
         mid = (left + right) / 2;
         if(arr[mid] <= key)
            left = mid + 1;
         else
            right = mid;
      }
      return right;
   }
}
