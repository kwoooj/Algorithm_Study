import java.util.*;
import java.io.*;

class Problem implements Comparable<Problem> {
    int id, level;
    public Problem(int id, int level) {
        this.id = id;
        this.level = level;
    }
    // 정렬 기준 정의
    @Override
    public int compareTo(Problem o) {
        if (this.level == o.level) {
            return this.id - o.id; // 난이도 같으면 번호순
        }
        return this.level - o.level; // 난이도순
    }
}

public class Main_21939_문제추천시스템V1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeSet<Problem> set = new TreeSet<>(); //난이도 정렬 위함

        HashMap<Integer, Integer> map = new HashMap<>(); // 삭제 문제의 난이도 조회(set의 remove는 problem 객체 필요(해당 객체는 번호, 난이도 둘 다 필요))

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Problem(p, l));
            map.put(p, l);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    set.add(new Problem(p, l));
                    map.put(p, l);
                    break;
                case "recommend": 
                    int what = Integer.parseInt(st.nextToken());
                    if (what == 1) System.out.println(set.last().id);
                    else System.out.println(set.first().id);
                    break;
                case "solved":
                    int id = Integer.parseInt(st.nextToken());
                    set.remove(new Problem(id, map.get(id))); // TreeSet에서 삭제
                    map.remove(id);
                    break;
            }
        }
    }
}


