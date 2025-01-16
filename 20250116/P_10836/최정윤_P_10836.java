import java.io.*;
import java.util.*;
//700*700
//1000000
//증가값을 한번에 모아놓고 돌려야 시간초과 안ㄴ날듯???.
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int M= Integer.parseInt(st.nextToken());
        int N= Integer.parseInt(st.nextToken());
        
        int[][] arr= new int[M][M];
        int[][] grow = new int[M][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int zero=Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            //ㅈㅏㄹㅏㄴㅡㄴ ㄱㅏㅂㅅ ㅅㅔㅌㅣㅇ
            for(int j=M-1;j>=0;j--){
                if(zero>0){
                    zero--;
                }else if(one>0){
                    grow[j][0]+=1;
                    one--;
                }else{
                    grow[j][0]+=2;
                    two--;
                }
            }
            for(int j=1;j<M;j++){
                if(zero>0){
                    zero--;
                }else if(one>0){
                    grow[0][j]+=1;
                    one--;
                }else{
                    grow[0][j]+=2;
                    two--;
                }
            }      
        }
        
        for(int i=1;i<M;i++){
            for(int j=1;j<M;j++){
                grow[i][j]=Math.max(Math.max(grow[i-1][j],grow[i][j-1]),grow[i-1][j-1]);
            }
        }
        
        //ㅈㅓㅇㄷㅏㅂㅊㅜㄹㄹㅕㄱ
        //sysout으로 하면 83점
		//sb로 하니까 맞았따..
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                sb.append((grow[i][j]+1)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}