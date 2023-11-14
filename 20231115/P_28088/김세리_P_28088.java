package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _28088_응애_EASY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);
        int K = Integer.parseInt(s.split(" ")[2]);
        
        int[] arr = new int[N];
        int[] arrCopy = new int[N];
        for(int i=0;i<M;i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a]=1;
        }
        int cnt=0;
        while(cnt<K) {
            arrCopy = arr.clone();
            for(int i=0;i<N;i++) {
                if(arr[i]==1) arrCopy[i]=0;
            }
            for(int i=1;i<N-1;i++) {
                if(arr[i-1]==1 || arr[i+1]==1) arrCopy[i]=1;
                if(arr[i-1]==1 && arr[i+1]==1) arrCopy[i]=0;
            }
            if(arr[N-1]==1 || arr[1]==1) arrCopy[0]=1;
            if(arr[N-1]==1 && arr[1]==1) arrCopy[0]=0;
            
            if(arr[N-2]==1 || arr[0]==1) arrCopy[N-1]=1;
            if(arr[N-2]==1 && arr[0]==1) arrCopy[N-1]=0;
            arr = arrCopy.clone();
            cnt++;
        }
        int ans=0;
        for(int i=0;i<N;i++) {
            ans += arr[i];
        }
        System.out.println(ans);
    }//main

}
