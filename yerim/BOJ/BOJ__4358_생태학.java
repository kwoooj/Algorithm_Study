20260315
백준 실버2 4358 생태학

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<String, Integer> m = new HashMap<>();
		String tree;
		int size = 0;
		
		while ((tree = br.readLine()) != null) {
			m.put(tree, m.getOrDefault(tree, 0) + 1);
			size++;
		}
		
		ArrayList<String> list = new ArrayList<>(m.keySet());
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		
		for (String k : list) {
			int count = m.get(k);
			double avg = (double) count * 100 / size;
			sb.append(k + " " + String.format("%.4f", avg) + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
