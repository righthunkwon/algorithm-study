package _20231018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2502_떡먹는호랑이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int D = Integer.parseInt(s.split(" ")[0]);
		int K = Integer.parseInt(s.split(" ")[1]);
		
		// a 배열은 a앞 계수들의 배열이고, b는 b앞 계수들의 배열이다
		int[] a = new int[D+1];
		int[] b = new int[D+1];
		
		// 3일째일때는 무조건 a를 1로 하고, b를 K-1로 출력되도록 한다
        if(D==3) {
			System.out.println(1);
			System.out.println(K-1);
		}else{
        
		//a[1] = 1;  b[1] = 0;
		a[2] = 0;  b[2] = 1;
		a[3] = 1;  b[3] = 1;
		a[4] = 1;  b[4] = 2;
//		a[5] = 2;  b[5] = 3;
		
		// 계수들 각각 피보나치 형태를 보인다
		for(int i=5;i<D+1;i++) {
			a[i]=a[i-1]+a[i-2];
			b[i]=b[i-1]+b[i-2];
		}
		
		// 결국 D째날 떡의 개수 K = a[D]*첫째날 떡의 개수 + b[D]*둘째날 떡의 개수로 표현할 수 있다
		// 첫째날의 떡이 더 작은 수 이므로, 이걸 이용해서 떡의 개수를 구한다
		int tteok1=0, tteok2=0;
		
		for(int i=1;;i++) {
			int tmp = K-a[D]*i;
			if(tmp % b[D]==0) {
				tteok1 = i;
				tteok2 = tmp / b[D];
				break;
			}
		}
		
		System.out.println(tteok1);
		System.out.println(tteok2);
        }
	}//main

}
