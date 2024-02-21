package _20240221;

import java.util.*;
import java.io.*;

public class _9082_지뢰찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			// hint: 주변 지뢰 개수를 적은 것
			int[] hint = new int[N];
			String s = br.readLine();
			for(int i=0;i<N;i++) {
				hint[i] = Integer.parseInt(s.split("")[i]);
			}
			
			// real: 실제 지뢰 정보가 있는 배열 ->근데 이건 사용 안함
			char[] real = br.readLine().toCharArray();
			
			// cnt: 지뢰 개수 카운트
			int cnt=0;
			
			// 맨 앞, 맨 뒤의 경우를 제외하고
			// 지뢰가 있다는 건 결국 hint 배열에서 앞, 자신, 뒤 칸 세개가 모두 +1이란걸 뜻한다.
			// 이걸 이용해서 지뢰 하나를 세줄때마다 관련된 애들을 빼주면 real 정보없이도
			// 지뢰 개수를 카운트 할 수 있다.
			
			for(int i=0; i<N; i++) {
				
				// hint 맨 첫번째 칸에서
				// hint 첫번째, 두번째가 0이 아닐 경우 무조건 첫번째 칸은 지뢰란 뜻
				// 지뢰 카운트 해주고 카운트 해줬으니까 hint에서 카운트 한 걸 빼준다
                if (i ==0 && hint[i]!=0 && hint[i+1]!=0) {
                	hint[i] -= 1;
                	hint[i+1] -= 1;
                    cnt++;
                }
                
                // hint 맨 마지막 칸에서
                // hint 마지막 두번째, 마지막 칸이 0이 아닐 경우 무조건 마지막 칸은 지뢰란 뜻
                // 지뢰 카운트 해주고 카운트 해줬으니까 hint칸에서 카운트 한 걸 빼준다
                else if (i==(N-1) && hint[i-1]!=0 && hint[i]!=0) {
                	hint[i-1] -= 1;
                	hint[i] -= 1;
                    cnt++;
                }
                
                // hint 배열에서 앞의 두 경우를 뺀 나머지 경우에서
                // i-1, i, i+1 칸에서 모두 0이 아닐 경우
                // 지뢰 카운트 해주고 카운트 해줬으니까 hint칸에서 카운트 한 걸 빼준다
                else if (1<=i && i<=(N-2) && hint[i-1]!=0 && hint[i]!=0 && hint[i+1]!=0) {
                	hint[i-1] -= 1;
                	hint[i] -= 1;
                	hint[i+1] -= 1;
                    cnt++;
                }
            }
            System.out.println(cnt);
			
		}//T
		
	}//main
	

}
// https://velog.io/@xeropise1/%EB%B0%B1%EC%A4%80-9082-%EC%A7%80%EB%A2%B0%EC%B0%BE%EA%B8%B0
