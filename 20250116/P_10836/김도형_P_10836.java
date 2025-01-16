import java.io.*;
import java.util.*;

public class BOJ_G3_10836_여왕벌 {

	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //가로세로 크기
        int n = Integer.parseInt(st.nextToken()); //날짜 수
		
        int[][] grow = new int[m][m];
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int cnt_0 = Integer.parseInt(st.nextToken());
        	int cnt_1 = Integer.parseInt(st.nextToken());
        	int cnt_2 = Integer.parseInt(st.nextToken());
        	
        	//왼쪽아래->왼쪽맨위 증가량 구하기
        	for(int j = m-1;j>=0;j--) {
        		if(cnt_0>0) {
        			cnt_0--;
        		}else if(cnt_1>0) {
        			grow[j][0]++;
        			cnt_1--;
        		}else {
        			grow[j][0]+=2;
        			cnt_2--;
        		}
        	}
        	
        	//(0,1)->오른쪽맨위까지 증가량 구하기
        	for(int j=1;j<m;j++) {
        		if(cnt_0>0) {
        			cnt_0--;
        		}else if(cnt_1>0) {
        			grow[0][j]++;
        			cnt_1--;
        		}else {
        			grow[0][j]+=2;
        			cnt_2--;
        		}
        	}

        }
        
        //나머지부분 증가량 구하기
    	for(int j=1;j<m;j++) {
    		for(int k=1;k<m;k++) {
    			grow[j][k]=Math.max(grow[j-1][k], Math.max(grow[j-1][k-1], grow[j][k-1]));
    		}
    	}
        
        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
        	for(int j=0;j<m;j++) {
        		sb.append((grow[i][j]+1)+" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}

}
