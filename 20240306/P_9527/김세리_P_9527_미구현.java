package _20240306;

import java.util.*;
import java.io.*;

public class _9527_1의개수세기 {
	
	static long[] DP = new long[55];// 1의 개수 누적합 저장
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        // 누적합 계산
        
        System.out.print(result);
    }
    
}
