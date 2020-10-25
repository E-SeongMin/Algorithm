# 문제 주소  
https://www.acmicpc.net/problem/1929

## 목표
M이상 N이하의 소수를 모두 출력하는 프로그램 작성

## 문제 해결
에라토스테네스의 체 (소수 구하는 알고리즘) 사용
```
알고리즘 진행

1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열
2. 제일 작은 수 2를 선택
3. 자기자신을 제외한 2의 배수를 모두 지움
4. 남아있는 수 가운데 제일 작은 수 3를 선택
5. 자기자신을 제외한 3의 배수를 모두 지움
...
위의 과정을 반복하면 구하는 구간의 모든 소수만 남음
```
해당 과정을 코드로 나타내면
```
for(int i=2; i<=n; i++) {
	if(!primeNum[i]) {
		for(int j=i+i; j<=n; j+=i)
			primeNum[j] = true;
	}
}
```
그 후 출력에서 primeNum[] 배열이 false인 index 값만 출력
```
for(int i=m; i<=n; i++) {
	if(!primeNum[i])
		System.out.println(i);
}
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean [] primeNum = new boolean [n+1];
		primeNum[0] = primeNum[1] = true;
		
		for(int i=2; i<=n; i++) {
			if(!primeNum[i]) {
				for(int j=i+i; j<=n; j+=i)
					primeNum[j] = true;
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(!primeNum[i])
				System.out.println(i);
		}
	}
}
```
