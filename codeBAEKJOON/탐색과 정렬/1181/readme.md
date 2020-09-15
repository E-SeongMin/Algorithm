# 문제 주소  
https://www.acmicpc.net/problem/1181

## 목표
단어 정렬 프로그램 작성
```
우선순위 

1. 길이가 짧은 것부터
2. 사전순으로 
```

## 문제 해결
단어를 String 배열로 입력 받을 수 도 있지만 중복을 피해야하므로 HashSet 사용
```
HashSet <String> word_set = new HashSet <String> ();
```
Comparator 을 Override 하여 길이 비교를 가능하게 함
```
Arrays.sort(word, new Comparator<String>() {
	@Override
	public int compare(String o1, String o2) {
		return Integer.compare(o1.length(), o2.length());
	}
});
```
먼저 사전순으로 정렬 후 길이 순으로 정렬하면 길이 순이 1순위가 됨

## 소스코드
```
import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet <String> word_set = new HashSet <String> ();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			word_set.add(st.nextToken());
		}
		
		String [] word = new String [word_set.size()];
		
		word_set.toArray(word);
		
		Arrays.sort(word);
		
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		
		for(int i=0; i<word_set.size(); i++)
			bw.write(word[i] + "\n");
		
		bw.flush();
	}
}
```
