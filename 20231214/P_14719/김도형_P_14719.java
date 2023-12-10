package AlgoStudy;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q14719_빗물 {
	
	static int[] arr; //블럭높이 저장 배열
	static int H,W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W]; //블록 높이 저장할 배열 초기화
		st = new StringTokenizer(br.readLine());
		int topH = -1; //가장 높은 블록 높이
		int topidx = -1; //가장 높은 블록 인덱스
		for(int i =0; i<W; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(topH<arr[i]) {
				topH=arr[i];
				topidx=i;  //가장 높은 블록이 있는 인덱스 저장
			}
		}//입력끝
		
//		System.out.println(topH);
//		System.out.println(topidx);
		
		int leftpoint = topidx;
		int rightpoint = topidx; //일단 처음구한 가장 높은 블록 높이가 기준이 됨
		
		int rainwater = 0; //정답(빗물) 초기화
		
		while(leftpoint>0) {
			int leftwall= topindex(0,leftpoint); //왼쪽 벽이 될 블럭 위치 구함
			int height = Math.min(arr[leftwall], arr[leftpoint]);//두 벽중 낮은 벽의 높이 -> 빗물 고이는 양 계산용
			for(int i=leftwall+1;i<leftpoint;i++) {
				rainwater+=height-arr[i];
			}
			leftpoint=leftwall; //빗물 더해주고나면 이제 왼쪽벽이 다시 기준점이 되고 반복..
		}
		
		
		while(rightpoint<W-1) {
			
			int rightwall=topindex(rightpoint+1,W); //오른쪽 벽이 될 블럭 위치 구함
			int height = Math.min(arr[rightwall], arr[rightpoint]); //두 벽중 낮은 벽의 높이
			for(int i=rightpoint+1;i<rightwall;i++) {
				rainwater+=height-arr[i];
			}
			rightpoint=rightwall;
		}
		
		System.out.println(rainwater);
	}//main
	
	//시작점과 끝점이 주어졌을 때 가장 높은 곳의 인덱스를 구하는 메서드
	private static int topindex(int st,int ed) {
		int max=-1;
		int maxidx=-1;
		for(int i=st;i<ed;i++) {
			if(arr[i]>=max) {
				max=arr[i];
				maxidx=i;
			}
		}
		return maxidx;
	}
	
	
}//class
