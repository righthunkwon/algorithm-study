import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve(n, k, arr));
    }

    public static long solve(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 초기값: 누적합이 0인 경우
        int sum = 0;
        long count = 0;
        
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
//    public static long solve(int n, int k, int[] arr) {
//        long count = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += arr[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}