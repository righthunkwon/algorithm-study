package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_Q17140_이차원_배열과_연산 {
	
	static int row,col;
	
	static class Number implements Comparable<Number>{
		int num; //숫자
		int cnt; //반복등장횟수
		public Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
		//등장횟수로 정렬하고, 등장횟수 같으면 숫자로 정렬
		@Override
		public int compareTo(Number o) {
			if(this.cnt==o.cnt) {
				return this.num - o.num; 
			}
			return this.cnt-o.cnt; 
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[100][100]; // 배열에 대한 정보 저장
		
		int ans = -1; //정답 초기값 -1
		row=3; //초기 행은 3
		col=3; //초기 열은 3
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		for(int i=0;i<100;i++) { //100초 진행
			if(arr[r][c]==k) {
				ans = i;
				break;
			}
			if(row>=col) {
				arr = rCal(arr); //행이 열보다 크거나 같으면 행 연산
			}else arr = cCal(arr); //열이 더 크면 열 연산
		}
		System.out.println(ans);
		
		
	}// main
	
	
	//행 연산
	public static int[][] rCal(int[][] a) {
		int[][] b = new int[100][100];
		int max = 0; //가장 긴 열 길이
		
		for(int i = 0; i < row; i++) {
			ArrayList <Number> l = new ArrayList<>();
			for(int j = 0; j < col; j++) {
				int num = a[i][j];
				if(num == 0) continue; //0 무시
				boolean flag = false; //리스트에 숫자 있는지 확인용 flag
				for(int k = 0; k < l.size(); k++) { //리스트 순회하면서 
					if(l.get(k).num == num) { //리스트에 현재 숫자 있는지 확인
						flag = true; 
						l.get(k).cnt++; //등장횟수 +1
						break;
					}
				}
				if(!flag) l.add(new Number(num, 1));//리스트에 숫자가 없으면 새로 숫자를 리스트에 추가
			}
			Collections.sort(l); //정렬
			int cnt = 0;
			for(int j = 0; j < l.size(); j++) {
				if(cnt > 99) break;
				b[i][cnt++] = l.get(j).num;
				b[i][cnt++] = l.get(j).cnt;
			}
			max = Math.max(max, 2 * l.size()); //최대 열 길이 갱신
		}
		col = max; //열 크기 갱신
		return b;
	}//rCal
	
	//열 연산
	public static int[][] cCal(int[][] a) {
		int[][] b = new int[100][100];
		int max = 0;
		
		for(int i = 0; i < col; i++) {
			ArrayList <Number> l = new ArrayList<>();
			for(int j = 0; j < row; j++) {
				int num = a[j][i];
				if(num == 0) continue;
				boolean flag = false;
				for(int k = 0; k < l.size(); k++) {
					if(l.get(k).num == num) {
						flag = true;
						l.get(k).cnt++;
						break;
					}
				}
				if(!flag) l.add(new Number(num, 1));
			}
			Collections.sort(l);
			int cnt = 0;
			for(int j = 0; j < l.size(); j++) {
				if(cnt > 99) break;
				b[cnt++][i] = l.get(j).num;
				b[cnt++][i] = l.get(j).cnt;
			}
			max = Math.max(max, 2 * l.size());
		}
		row = max;
		return b;
	}//cCal

}
