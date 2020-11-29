# 문제 주소  
https://www.acmicpc.net/problem/2580

## 목표
백트래킹을 이용한 스도쿠 만들기

## 문제 해결
스도쿠에는 3가지 제약이 있음
```
1. 같은 가로줄끼리는 1부터 9까지의 숫자가 한 번씩만 나타나야 함
2. 같은 세로줄끼리는 1부터 9까지의 숫자가 한 번씩만 나타나야 함
3. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 함
```
다음 제약들을 "arr[row][column] == 0" 일때 확인
```
for(int i=0; i<9; i++) {  // 행 확인
  if(arr[row][i] == num)
	  return false;
}

for(int i=0; i<9; i++) {  // 열 확인
	if(arr[i][column] == num)
		return false;
}

int square_row = (row/3) * 3;
int square_column = (column/3) * 3;
		
for(int i=square_row; i<square_row+3; i++) {  // 3x3 확인
	for(int j=square_column; j<square_column+3; j++) {
		if(arr[i][j] == num)
			return false;
	}
}
```
위의 세 가지 제약을 모두 통과할 경우 True를 Return

## 소스코드
```
import java.io.*;
import java.util.*;

public class Main {
	public static int arr[][] = new int [9][9];
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Backtracking(0, 0);
	}
	
	public static void Backtracking(int row, int column) {
		if(column == 9) {
			Backtracking(row+1, 0);
			return;
		}
		
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++)
					sb.append(arr[i][j]).append(" ");
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		if(arr[row][column] == 0) {
			for(int i=1; i<=9; i++) {
				if(findNum(row, column, i)) {
					arr[row][column] = i;
					Backtracking(row, column + 1);
				}
			}
			arr[row][column] = 0;
			return;
		}
		
		Backtracking(row, column + 1);
	}
	
	public static boolean findNum(int row, int column, int num) {
		for(int i=0; i<9; i++) {  // 행 확인
			if(arr[row][i] == num)
				return false;
		}
		
		for(int i=0; i<9; i++) {  // 열 확인
			if(arr[i][column] == num)
				return false;
		}
		
		int square_row = (row/3) * 3;
		int square_column = (column/3) * 3;
		
		for(int i=square_row; i<square_row+3; i++) {  // 3x3 확인
			for(int j=square_column; j<square_column+3; j++) {
				if(arr[i][j] == num)
					return false;
			}
		}
		
		return true;
	}
}
```
