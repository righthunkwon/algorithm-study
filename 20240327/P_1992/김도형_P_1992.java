package AlgoStudy;

import java.io.*;

public class BOJ_Q1992_쿼드트리 {
	
	static int N;
	static char[][]arr;
	static StringBuilder ans;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //배열의 크기
		arr = new char [N][N];
		for(int i=0;i<N;i++) {
			String str = new String(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		ans = new StringBuilder();
		
		recursion(0,0,N);
		
		System.out.println(ans.toString());
		
	}//main
	
	//정복 시작점 좌표(x,y)  정복할 배열 폭(=높이) : wid
	public static void recursion(int x, int y,int wid) {
		
		if(x==1) {
			ans.append(arr[x][y]);
			return;
		}
		
		char tmp = arr[x][y];
		boolean flag=true;
		for(int i=x;i<x+wid;i++) {
			for(int j=y;j<y+wid;j++) {
				if(arr[i][j]!=tmp) {
					//첫 시작점과 동일하지 않은 부분 나오면 4분할로 재귀
					ans.append("(");
					recursion(x,y,wid/2);
					recursion(x,y+wid/2,wid/2);
					recursion(x+wid/2,y,wid/2);
					recursion(x+wid/2,y+wid/2,wid/2);
					ans.append(")");
					return;
				}
			}
		}
		
		if(flag) {
			ans.append(tmp);
			return;
		}
		
	}
	
}//class
