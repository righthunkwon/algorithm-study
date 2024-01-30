package _20240131;

import java.io.*;
import java.util.*;

public class _4307_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int minTime = 0;
            int maxTime = 0;
            for (int i = 0; i < n; i++) {
                int pos= Integer.parseInt(br.readLine());
                int timeToRight = l-pos;
                int timeToLeft = pos;
                // 막대 위에서의 개미가 있냐 없냐로 구분하는 거니까
                // 개미 하나하나의 움직임을 관찰해서 추적할 필요가 없다.
                
                // 개미 각각의 위치에서 막대 끝까지 도달하는 최소, 최대 시간을 구해서
                // 그 시간만큼 결국 가는 것이기 때문에 각각의 값을 구한 것중에
                // 최소 시간이 전체 막대에서 개미가 없어지는 데까지 걸리는 최소 시간이고,
                // 최대 시간이 전체 막대에서 개미가 없어지는 데까지 걸리는 최대 시간이다

                // 최소 시간 계산
                minTime = Math.max(minTime, Math.min(timeToLeft, timeToRight));

                // 최대 시간 계산
                maxTime = Math.max(maxTime, Math.max(timeToLeft, timeToRight));
            }
            System.out.println(minTime + " " + maxTime);
        }
    }
}
