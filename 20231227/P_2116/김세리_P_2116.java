package _20231227;

import java.util.*;
import java.io.*;

public class _2116_주사위쌓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][6];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// A(0), B(1), C(2), D(3), E(4), F(5)
		// A(0)-F(5), B(1)-D(3), C(2)-E(4) 는 각각 마주보는 위치임
		
		// 주사위의 위,아래가 정해져 있을 경우
		// 나머지 4개 면에 적힌 숫자 중 가장 큰 숫자를 더하면 결국 옆면의 숫자 합의 최대값을 구할 수 있음.
		
		// 임의로 맨 아래 숫자를 정하고 옆면의 숫자 합의 최대값을 구한 뒤
		// 맨 아래 숫자를 또 바꿔서 최대값을 구하고 그 전의 것과 비교하여 큰 수를 ans에 저장하는 식으로 해서
		
		// 6번 반복하면 결국 가장 큰 값을 구할 수 있다
		
		int ans=0;
		int cnt=0;
		while(cnt<6) {
			int start = arr[0][cnt];
			int sum =0;
				for(int i=0;i<N;i++) {
					out: for(int j=0;j<6;j++) {
						
						if(arr[i][j]==start) {
							if(j==0||j==5) {
								sum += Math.max(Math.max(arr[i][1], arr[i][3]), Math.max(arr[i][2], arr[i][4]));
								if(j==0) start = arr[i][5];
								else if(j==5) start = arr[i][0];
							}
							else if(j==1||j==3) {
								sum += Math.max(Math.max(arr[i][0], arr[i][5]), Math.max(arr[i][2], arr[i][4]));
								if(j==1) start = arr[i][3];
								else if(j==3) start = arr[i][1];
							}
							else if(j==2||j==4) {
								sum += Math.max(Math.max(arr[i][0], arr[i][5]), Math.max(arr[i][1], arr[i][3]));
								if(j==2) start = arr[i][4];
								else if(j==4) start = arr[i][2];
							}
							break out;
						}
						
					}
				
				}
			ans = Math.max(ans, sum);
			cnt++;	
			
			
		}
		System.out.println(ans);
	}//main

}
