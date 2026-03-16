import java.io.*;
import java.util.*;

public class Main_7785_회사에있는사람 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //버퍼리더에서 int형 입력 받기
		TreeMap<String, String> company = new TreeMap<>();
		for(int i = 0; i<N; i++) {
			String file = br.readLine();
			String[] in = new String[2];
			in = file.split(" "); 
			
			if(in[1].equals("enter")) {
				company.put(in[0], "enter");
			} else {
				company.remove(in[0]);
			}
		}
		
		//역순으로 출력?
		for(String stay : company.keySet()) {
			System.out.println(stay);
		}
		
	}
}
