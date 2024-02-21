package _20240221;

import java.util.*;
import java.io.*;

public class _2879_코딩은예쁘게 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] current = new int[N]; // 지금 코드 인덴트
		int[] pretty = new int[N]; // 예쁜 코드 인덴트

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			current[i] = Integer.parseInt(st.nextToken());
			pretty[i] = Integer.parseInt(s.nextToken());
		}

		int cnt = 0;
        int i = 0;
        while (i < N) {
        	int chk = 0;
//        	System.out.println("current : "+Arrays.toString(current));
//        	System.out.println("pretty : "+Arrays.toString(pretty));
//        	System.out.println("i: "+i);
            if (current[i] != pretty[i]) {
                int startDiff = pretty[i] - current[i];
                int minDiff = Math.abs(startDiff);
                int j = i+1;

                // 연속된 줄의 최소 변화량 찾기, 없을 경우 i의 변화량이 최소로 유지됨
                while (j<N && Integer.signum(pretty[j]-current[j]) == Integer.signum(startDiff)) {
                    int diff = Math.abs(pretty[j] - current[j]);
                    minDiff = Math.min(minDiff, diff);
                    j++;
                }
                // 최소 변화량 만큼 cnt를 추가해주고,
                // current 배열에도 그 변화량을 반영해준다
                cnt += minDiff;
                for(int a=i;a<j;a++) {
                	
                	if(startDiff < 0) {
                		current[a] = current[a] - minDiff;
                	} else if(startDiff > 0) {
                		current[a] = current[a] + minDiff;
                	}
                }
                
            } else {
                i++;
                chk++;
                // chk를 이용해서 값이 같은 개수가 N만큼이면
                // pretty 배열과 인덴트가 모두 같다는 의미이므로 반복문을 나간다
                if(chk==N) break;
            }
        }

        System.out.println(cnt);

	}//main

}
