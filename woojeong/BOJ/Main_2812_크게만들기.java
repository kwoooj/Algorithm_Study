import java.util.*;

public class Main_2812_크게만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Deque<Integer> max = new ArrayDeque<>();
		
		int cnt = 0;
		
		String ori = sc.next();
		for(int i = 0; i< N; i++) {
			int tmp = ori.charAt(i) -'0'; //char 형태를 정수로 변환
			System.out.println(tmp);
			
			while (max.size() > 0 && max.peekLast() < tmp && cnt < K) { //들어올 때마다 나보다 작은데 앞에 있는 놈들 제거
				max.pollLast();
				cnt++;
			}
			max.offerLast(tmp);
		}
		
		while(cnt < K) { //위에서 while로 연쇄적으로 나보다 작은 앞의 값들은 없애준 상태이므로 내림차순 상태 -> 따라서 뒤에서부터 제거하면 됨 
			max.pollLast();
			cnt++;
		}
		
		while(!max.isEmpty()) {
			System.out.print(max.pollFirst());
		}
	}
}
