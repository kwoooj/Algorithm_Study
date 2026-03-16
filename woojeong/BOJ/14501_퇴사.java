//260304

import java.util.*;

public class BOJ_14501_퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] per = new int[N + 1];  // 기간
        int[] money = new int[N + 1];  // 금액
        int[] pro = new int[N + 2]; // 최대 수익

        for (int i = 1; i <= N; i++) {
            per[i] = sc.nextInt();
            money[i] = sc.nextInt();
        }
        //각 pro[i]에는 i까지 올 수 있는 최대 수익이 저장
        for (int i = 1; i <= N; i++) {
            // 상담 안 하는 경우(최대수익 유지)
            pro[i + 1] = Math.max(pro[i + 1], pro[i]); 

            // 상담 하는 경우
            int end = i + per[i]; //상담 끝난 다음 날 

            if (end <= N + 1) { //N+1(상담 끝난 다음 날 최대)
                pro[end] = Math.max(pro[end], pro[i] + money[i]);
            }
        }

        System.out.println(pro[N + 1]);
    }
}
