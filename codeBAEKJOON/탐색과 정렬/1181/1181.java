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
