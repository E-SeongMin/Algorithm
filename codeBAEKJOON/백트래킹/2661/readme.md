# 문제 주소  
https://www.acmicpc.net/problem/2661

## 목표
임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 없도록 하는 좋은 수열 찾기

## 문제 해결
동일한 숫자를 찾아내는 것이므로 수열을 String으로 정의함
```
public static void Backtracking(String s) {
	if(end)	return;
	if(s.length() == n) {
		System.out.println(s);
		end = true;
		return;
	}
	for(int i=1; i<=3; i++) {
		if(isGood(s + i))
			Backtracking(s + i);
	}
}
```
인접한 두 개의 부분 수열을 front_str 과 end_str로 나누고 equals()함수로 동일한지 확인
```
public static boolean isGood(String s) {
		String front_str, end_str;
		for(int i=1; i<=s.length()/2; i++) {
			front_str = s.substring(s.length()-2*i, s.length()-i);
			end_str = s.substring(s.length()-i, s.length());
			if(front_str.equals(end_str))
				return false;
		}
		return true;
	}
```
제일 작은 수 부터 확인하므로 첫번째 좋은 수열이 가장 작은 수가 됨
```
if(s.length() == n) {
	System.out.println(s);
	end = true;
	return;
}
```
end 변수를 false로 걸면 해당 조건문에서 백트래킹 종료
```
if(end)	return;
```

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static boolean end = false;
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		Backtracking("");
	}
	
	public static void Backtracking(String s) {
		if(end)	return;
		if(s.length() == n) {
			System.out.println(s);
			end = true;
			return;
		}
		for(int i=1; i<=3; i++) {
			if(isGood(s + i))
				Backtracking(s + i);
		}
	}
	
	public static boolean isGood(String s) {
		String front_str, end_str;
		for(int i=1; i<=s.length()/2; i++) {
			front_str = s.substring(s.length()-2*i, s.length()-i);
			end_str = s.substring(s.length()-i, s.length());
			if(front_str.equals(end_str))
				return false;
		}
		return true;
	}
}
```
