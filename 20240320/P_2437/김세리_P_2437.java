package _20240320;

import java.util.*;
import java.io.*;

public class _2437_저울 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weights); // 무게추 정렬
		
		/*
		 * 전제: 측정 가능한 무게 a (1-a까지 측정 가능하다)
		 * 무게추 x를 더하려 한다.
		 * x를 추가하게 되면, 측정 가능한 무게는
		 * a개(1~a까지) + 1개(x무게) + a개(x+1 ~ x+a 까지) = 2a+1개 이다.
		 * 
		 * 근데 측정 가능한 무게는 1부터 시작하니까
		 * 2a+1개란 소리는 결국 측정 가능한 무게가 2a+1이란 소리이다.
		 * 
		 * 따라서 a+1이 b가 될 수 있는 최대수이다.
		 * 
		 * 그러므로 b <= a+1을 만족할 때 current_max값에 추가한다.
		 * 
		 */
        int current_max = 0;

        for (int weight : weights) {
            if (weight > current_max + 1) {
                break; // 측정할 수 없는 가장 작은 무게 찾음
            }
            current_max += weight;
        }

        System.out.println(current_max + 1);
        
	}//main
}
