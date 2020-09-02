# 문제 주소  
https://www.acmicpc.net/problem/1920

## 목표
이분탐색(이진탐색)을 이용한 수 찾기
```
public BinarySearch(int Key, int Arr[]) {
		int mid;
		int left = 0;
		int right = Arr.length - 1;
		
		while(right >= left) {
			mid = (right + left) / 2;
			
			if(Key < Arr[mid])
				right = mid - 1;
			else if(Key > Arr[mid])
				left = mid + 1;
        }
```

## 문제 접근방법
배열 Arr 선언 이후 입력받은 Target 을 이용하여 이진탐색(BinarySearch)

### 소스코드
```
import java.util.*;

public class Main {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int [] Arr = new int[N];
		for(int i=0; i<N; i++)
			Arr[i] = sc.nextInt();
		
		Arrays.sort(Arr);
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int result = 0;
			int target = sc.nextInt();
			System.out.print(result + BinarySearch(target, Arr) + "\n");
		}	
		sc.close();
	}
	
	public static int BinarySearch(int Key, int Arr[]) {
		int mid;
		int left = 0;
		int right = Arr.length - 1;
		
		while(right >= left) {
			mid = (right + left) / 2;
			
			if(Key < Arr[mid])
				right = mid - 1;
			else if(Key > Arr[mid])
				left = mid + 1;
			else
				return 1;
		}
		return 0;
	}2
}
```
