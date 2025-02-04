import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int r1=Integer.parseInt(st.nextToken());
        int c1=Integer.parseInt(st.nextToken());
        int r2=Integer.parseInt(st.nextToken());
        int c2=Integer.parseInt(st.nextToken());
        
        int[][] arr=new int[r2-r1+1][c2-c1+1];
        int num=1;
        int nr=0;
        int nc=0;
        int dir=0;
        int[] dr=new int[]{0,-1,0,1};//ㅇㅜ ㅅㅏㅇ ㅈㅗㅏ ㅎㅏ
        int[] dc=new int[]{1,0,-1,0};
        int depth=1;
        int max=0;
        //12345 ㄷㅜㅂㅓㄴㅆㅣㄱ
        h: while(true){
            for(int cnt=0;cnt<2;cnt++){
                for(int dep=0;dep<depth;dep++){
                    if(arr[0][0]!=0&&arr[r2-r1][0]!=0&&arr[0][c2-c1]!=0&&arr[r2-r1][c2-c1]!=0)
                        break h;
                    if(nr<=r2&&nr>=r1&&nc<=c2&&nc>=c1){//ㅂㅐㅇㅕㄹㅇㅔ ㄴㅓㅎㅇㅓㄹㅏ
                        arr[nr-r1][nc-c1]=num;
                        max=Math.max(max,String.valueOf(num).length());
                    }
                    nr+=dr[dir];
                    nc+=dc[dir];
                    num++;
                }
                dir=(dir+1)%4;
            }
            depth++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<r2-r1+1;i++){
            for(int j=0;j<c2-c1+1;j++){
                for(int k=0;k<max-String.valueOf(arr[i][j]).length();k++){
                    sb.append(" ");
                }
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}