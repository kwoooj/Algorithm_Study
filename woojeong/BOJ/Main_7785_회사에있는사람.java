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
		
		//역순으로 출력 -> 스택 써서 뒤에서부터 꺼냄(어차피 Tree 써서 사전 순 정렬 되어있는 상태니까)
		Stack<String> inCom = new Stack<>();
		for(String stay : company.keySet()) {
			inCom.add(stay);
		}
		
		
		while(!inCom.isEmpty()) {
			System.out.println(inCom.pop());
		}
	}
}
