package _20231025;

import java.util.Scanner;

public class _11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
        int [] dp= new int[N+1];
        int [] dp2 = new int[N+1];
 
        int result = 0;
        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[j]>=dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
 
 
        for(int i=N-1; i>=0; i--){
            dp2[i]=1;
            for(int j=N-1; j>i; j--){
                if(arr[i]>arr[j] && dp2[j]>=dp2[i]){
                    dp2[i]=dp2[j]+1;
                }
            }
        }
 
        for(int i=0; i<N; i++){
            result = Math.max(dp[i]+dp2[i]-1,result);
        }
 
        System.out.println(result);
    }
}
// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-11054%EC%9E%90%EB%B0%94-java-%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EB%B0%94%EC%9D%B4%ED%86%A0%EB%8B%89-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4
 
