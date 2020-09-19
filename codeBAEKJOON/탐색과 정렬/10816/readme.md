# 문제 주소  
https://www.acmicpc.net/problem/10816

## 목표
중복빼고 정렬하기

## 문제 해결
백준 10815번 숫자카드(https://www.acmicpc.net/problem/10815)와 같은 문제지만 중복된 개수까지 구해야하므로 단순 이분 탐색을 이용하면 TLE가 발생
```
public static int Search(int key, int arr[]) {
    int low = Lower(arr, 0, arr.length, key);
    int high = Upper(arr, 0, arr.length, key);
    return high - low;
}
```
따라서 다음과 같이 이분탐색을 두번 사용함
```
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
```
Upper 클래스에서는 값을 탐색하더라도 "<=" 연산자를 이용하여 더 높은 값이
나오기전까지 탐색을 진행함
```
1   2   2   3   4

와 같은 배열의 경우에 중복되는 2 의 왼쪽 부분과 오른쪽 부분을 찾아
사이에 몇 번 반복되는지 찾는 방법임
```
## 소스코드
```
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
```
