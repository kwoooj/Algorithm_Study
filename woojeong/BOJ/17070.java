//260303
import java.util.*;

public class 17070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] house = new int[N+1][N+1];
		int[][][] pipe = new int[N+1][N+1][3]; // [N+1]은 각각 파이프 r,c 끝 좌표 //0: 가로, 1: 세로 2: 대각선
		
		
		for (int r = 1; r<N+1; r++) {
			for(int c = 1; c<N+1; c++) {
				house[r][c] = sc.nextInt();
			}
		}
		
		pipe[1][2][0] = 1; //처음 파이프 이동 시작
		
		for(int r = 1; r<= N; r++) {
			for(int c = 2; c<=N; c++) {
				
				if (house[r][c] ==1) continue; // 벽 있으면 
				
				if(c+1<=N && house[r][c+1] == 0) { // 가로 일단 같은 방향(c+1)으로 한 칸 밀고
					pipe[r][c+1][0] += pipe[r][c][0]; // 가로 -> 가로 
					pipe[r][c+1][0] += pipe[r][c][2]; // 대각선 -> 가로
					
				} 
				if (r+1 <=N && house[r+1][c] == 0) { //세로 같 방 밀기
					pipe[r+1][c][1] += pipe[r][c][1]; //세로 -> 세로
					pipe[r+1][c][1] += pipe[r][c][2]; //대각선 -> 세로
					
				} 
				if (c+1<=N && r+1 <=N && house[r][c+1] == 0 && house[r+1][c] == 0 && house[r+1][c+1] == 0) {//대각선
					pipe[r+1][c+1][2] += pipe[r][c][0]; //가로 -> 대각선
					pipe[r+1][c+1][2] += pipe[r][c][1]; //세로 -> 대각선
					pipe[r+1][c+1][2] += pipe[r][c][2]; //대각선 -> 대각선
				}
			}
		}
		
		System.out.println(pipe[N][N][0] + pipe[N][N][1] + pipe[N][N][2]); //좌표들은 누적합으로 해당 좌표에 올 수 있는 경우의 수를 더한 값들임(마지막 좌표에서 각 방향별 경우의 수를 다 더한 값이 답)
		
	}
}
