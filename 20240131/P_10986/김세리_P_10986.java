package _20240131;

import java.io.*;
import java.util.*;

public class _10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 나눌 수

        long[] sum = new long[N+1]; // 나머지의 누적합을 구한다
        long[] cnt = new long[M]; // 나머지를 계산해서 배열에 넣는다
        
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
        	// 누적합을 M으로 나눈 나머지를 구해서 sum에 넣는다
            sum[i] = (sum[i-1]+Integer.parseInt(st.nextToken()))%M;
            // 
            cnt[(int)sum[i]]++;
        }
        // 일단 나머지가 0인 경우는 무조건 부분배열의 합이 0인 경우가 있는 것이므로 결과값에 더해준다
        long result = cnt[0];
        
        // 그리고 나머지가 같은 경우에, 그 두 수 사이의 부분합은 M으로 나눠떨어진다는 것을 의미하므로,
        // (예를 들어, 나머지가 2인 수들이 있다면 나머지2인 수-나머지2인 수=나머지 0인 수가 된다)
        // 나머지가 같은 수들 중 2개를 선택하는 조합을 계산해서 result에 더해준다
        for (int i=0;i<M;i++) {
        	// 나머지가 i인 수가 2개상 존재할 경우에 2개씩 선택하는 조합을 계산해준다
            if (cnt[i]>1) {
                result +=(cnt[i]*(cnt[i]-1))/2;
            }
        }

        System.out.println(result);
    }
}
