import java.util.*;

class Assignment implements Comparable<Assignment> {
	int day;
	int score;
	
	Assignment(int day, int score){
		this.day = day;
		this.score = score;
	}

	@Override
	public int compareTo(Assignment o) {
		if(this.score == o.score) return o.day - this.day;
		else return o.score - this.score;
	};
}
public class Main_13904_과제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//최대로 얻을 수 있는 과제 점수
		//하루에 한 과제 끝낼 수 있음
		int N = sc.nextInt(); //과제 개수
		PriorityQueue<Assignment> pq = new PriorityQueue<>();
		
		int deadline = 0;
		
		for(int i = 0; i<N; i++) {
			int day = sc.nextInt(); //과제마감일까지 남은 일수
			deadline = Math.max(deadline, day);
			int score = sc.nextInt(); //과제 점수
			
			pq.add(new Assignment(day, score));
		}
		
		boolean[] schedule = new boolean[deadline+1]; //인덱스 값 맞춰주기 +1
		int max = 0;
		
		while(!pq.isEmpty()) {
			int d = pq.peek().day;
			int s = pq.peek().score;
			
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
