import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = sc.nextInt();
        }
        sc.close();
        
        int[] sushiCnt = new int[d + 1]; 
        int cnt = 0;
        int maxCnt = 0;
        
        for (int i = 0; i < k; i++) {
            if (sushiCnt[belt[i]] == 0) cnt++;// 새로운 초밥
            sushiCnt[belt[i]]++;
        }
        maxCnt = cnt + (sushiCnt[c] == 0 ? 1 : 0);// 쿠폰 대상 없으면 추가
        
        for (int i = 0; i < N; i++) {
            int removeIndex = belt[i % N];
            sushiCnt[removeIndex]--;
            if (sushiCnt[removeIndex] == 0) cnt--;
            
            int addIndex = belt[(i + k) % N];
            if (sushiCnt[addIndex] == 0) cnt++;
            sushiCnt[addIndex]++;
        
            int curCnt = cnt + (sushiCnt[c] == 0 ? 1 : 0);// 쿠폰
            maxCnt = Math.max(maxCnt, curCnt);
        }
        
        System.out.println(maxCnt);
    }
}