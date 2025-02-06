import java.io.*;
import java.util.*;

public class BOJ_G3_1022_소용돌이_예쁘게_출력하기 {

	static int[] dr = {0, -1, 0, 1}; //오른쪽,위,왼,아래 순서
    static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int[][]map = new int[r2-r1+1][c2-c1+1]; //소용돌이 출력할 부분 넣을 배열
		int full_cnt = (r2-r1+1)*(c2-c1+1); //배열 다 채우는 횟수
		int cnt = 0; //현재 배열 채운 횟수
		int num = 1;
		int r = 0;
		int c = 0;
		int dir = 0;//방향 오른쪽 시작
		
		int turn_cnt = 0;//두번 방향전환하면 직진거리 1씩 늘어남
		int st_cnt = 0; //직진한 거리
		int length = 1; //직진 거리 1 1 2 2 3 3 4 4 ... 이런식 
		while(cnt<full_cnt) {
			if(r>=r1 && c>=c1 && r<=r2 && c<=c2) {
				map[r-r1][c-c1]=num; //범위 안이면 채우고 채운횟수 카운트
				cnt++;
			}
			num++;
			
			r = r+dr[dir];
			c = c+dc[dir];
			st_cnt++;
			if(st_cnt==length) {
				dir=(dir+1)%4; //방향전환
				turn_cnt++; //방향전환 횟수 카운트
				st_cnt=0; //직진횟수 초기화
				if(turn_cnt==2) { //두번 방향전환 하면 직진거리 1 상승
					turn_cnt=0;
					length++;
				}
			}
		}
		
		num--; //마지막으로 입력된 숫자에 1더해졌던거 빼주기
		
		String str = Integer.toString(num);
		int max_len = str.length(); //가장큰 숫자의 길이
		
		//출력
		for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
            	String tmp = Integer.toString(map[i][j]);
            	int tmp_len = tmp.length();
            	int space_cnt = max_len - tmp_len;
            	for(int k=0;k<space_cnt;k++)System.out.print(" "); //자리수 부족한만큼 공백채우기
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

	}
	
}
