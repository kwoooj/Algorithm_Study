import java.util.*;

public class Main_13904_과제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//최대로 얻을 수 있는 과제 점수
		//하루에 한 과제 끝낼 수 있음
		int N = sc.nextInt(); //과제 개수
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
			a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]
	    );
		
		int deadline = 0;
		
		for(int i = 0; i<N; i++) {
			int day = sc.nextInt(); //과제마감일까지 남은 일수
			deadline = Math.max(deadline, day);
			int score = sc.nextInt(); //과제 점수
			
			pq.add(new int[] {day, score});
		}
		
		boolean[] schedule = new boolean[deadline+1]; //인덱스 값 맞춰주기 +1
		int max = 0;
		
		while(!pq.isEmpty()) {
			int d = pq.peek()[0];
			int s = pq.peek()[1];
			
			for(int i = d; i > 0; i--) {
				if(schedule[i] == false) {
					schedule[i] = true;
					max += s;
					break;
				}
			}
			pq.poll();
		}
		
		System.out.println(max);
	}
}
