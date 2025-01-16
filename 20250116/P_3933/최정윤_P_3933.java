import java.io.*;
import java.util.*;
public class Main{
public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    
    while(true){
        int n=sc.nextInt();
        if(n==0) break;
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(i*i==n){
                cnt++;
                break;
            }else if(i*i>n)break;
            
            for(int j=i;j<=Math.sqrt(n);j++){
                if(i*i+j*j==n){
                    cnt++;
                    break;
                }else if(i*i+j*j>n)break;
                
                for(int k=j;k<=Math.sqrt(n);k++){
                    if(i*i+j*j+k*k==n){
                        cnt++;
                        break;
                    }else if(i*i+j*j+k*k>n)break;
                    
                    for(int l=k;l<=Math.sqrt(n);l++){
                        if(i*i+j*j+k*k+l*l==n){
                            cnt++;
                            break;
                        }else if(i*i+j*j+k*k+l*l>n)break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
}