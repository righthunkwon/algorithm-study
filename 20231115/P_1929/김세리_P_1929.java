package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1929_소수구하기 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
        int M= Integer.parseInt(s.split(" ")[0]);
        int N= Integer.parseInt(s.split(" ")[1]);
        
        boolean[] prime = new boolean[N+1];
        prime[0]=prime[1]=true;
        // 그냥 풀면 시간초과나서
        // 에라토스테네스의 체를 이용해서 구해야 한다
        for(int i=2;i*i<N+1;i++) {
        	if(!prime[i]) {
        		for(int j=i*i;j<=N;j+=i) {
        			prime[j]=true;
        		}
        	}
        }
        for(int i=M;i<=N;i++) {
        	if(!prime[i]) System.out.println(i);
        }

        //시간초과 코드ㅜㅜ
//        for(int i=M;i<=N;i++) {
//        	int cnt=0;
//        	out: for(int j=2;j<=N;j++) {
//        		if(i%j==0) cnt++;
//        		if(i<j) break out;
//        	}
//        	if(cnt==1) System.out.println(i);
//        }
    }//main

}
