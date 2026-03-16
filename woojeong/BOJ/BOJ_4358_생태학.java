import java.io.*;
import java.util.*;

public class BOJ_4358_생태학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeMap<String, Integer> map = new TreeMap<>();
        String tree;
        int total = 0;
        
        while((tree = br.readLine()) != null){
            total++;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
        }
        
        for(String key : map.keySet()){
            double percent = (map.get(key) * 100.0) / total;
            System.out.printf("%s %.4f\n", key, percent);
        }
    }
}
