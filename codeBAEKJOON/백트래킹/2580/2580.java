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
