package _20240313;

import java.util.*;
import java.io.*;

public class _7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        // 나올 수 있는 a+b의 합을 저장하고, 그게 몇 번 나올 수 있는지 수를 센다
        HashMap<Integer, Integer> AB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
            	// a+b 값이 이미 존재하는 값이라면 a+b에 +1을 해서 다시 넣고,
            	// a+b 값이 존재하지 않는다면 0+1을 해서 넣는다
                AB.put(a+b, AB.getOrDefault(a+b,0) +1);
            }
        }
        // A+B+C+D가 0이 되려면 결국 a+b = -(c+d)여야 한다
        long count = 0;
        for (int c : C) {
            for (int d : D) {
            	// -(c+d) 값이 존재하는지 찾아서 그 값이 존재하면 count를 더하고,
            	// 없을 떈 0을 더한다
                count += AB.getOrDefault(-(c + d), 0);
            }
        }
        // count 값을 출력한다
        System.out.println(count);
    }//main
}
