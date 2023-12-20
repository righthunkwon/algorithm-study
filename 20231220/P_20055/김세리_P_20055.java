package _20231220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055_컨베이어벨트위의로봇 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[2*N];
        boolean[] robo = new boolean[N];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < 2 * N; i++) {
            int a = Integer.parseInt(st.nextToken());
            belt[i]=a;
            if (a == 0) cnt++;
        }

        while (cnt < K) {
            ans++;

            // 컨베이어 벨트와 로봇 이동
            int tmp = belt[2*N-1];
            for(int i=2*N-1;i>0;i--) {
            	belt[i]=belt[i-1];
            }
            belt[0]=tmp;
            for(int i=N-1;i>0;i--) {
            	robo[i]=robo[i-1];
            }
            robo[0]=false;
            robo[N-1]=false;
            
            // 로봇 이동
            for(int i=N-1;i>0;i--) {
                if (robo[i-1] && !robo[i] && belt[i]>0) {
                    robo[i-1] = false;
                    robo[i] = true;
                    belt[i]--;
                    robo[N-1] = false;
                }
            }

            // 로봇 올리기
            if (belt[0] > 0) {
                robo[0]=true;
                belt[0]--;
            }
            //0세기
            cnt=0;
            for(int i=0;i<2*N;i++) {
            	if(belt[i]==0) cnt++;
            }
//            if(cnt>=K) break;
        }

        System.out.println(ans);
    }
}
