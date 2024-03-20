package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_Q2342_Dance_Dance_Revolution {
	static List<Integer>nums;
	static int len;
	static int [][][]dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new ArrayList<>();
		while(true) {
			int a = Integer.parseInt(st.nextToken());
			if(a==0)break;
			nums.add(a);
		}
		len = nums.size(); 
		dp = new int[len+1][5][5];
		
		int ans = ddr(0,0,0);
		System.out.println(ans);
		
	}//main
	
	static int ddr(int idx, int l, int r) {
		
		//기저
		if(idx==len)return 0;
		
		//메모이제이션
		if(dp[idx][l][r]!=0) {
			return dp[idx][l][r];
		}
		
		//idx번째에 왼발을 움직일 경우
		int moveLeft = move(l,nums.get(idx))+ ddr(idx+1,nums.get(idx),r);
		//idx번째에 오른발을 움직이는 경우
		int moveRight = move(r,nums.get(idx))+ ddr(idx+1,l,nums.get(idx));
		
		dp[idx][l][r]=Math.min(moveLeft, moveRight);
		
		return dp[idx][l][r];
		
	}
	
	//from에 있던거 to로 옮기는데 드는 힘
	public static int move(int from, int to) {
		if(from==0)return 2;
		if(Math.abs(from-to)==2)return 4;
		if(from==to) return 1;
		else return 3;
	}
}//class
