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
