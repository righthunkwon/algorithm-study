package _20240103;

import java.util.*;
import java.io.*;

public class _2174_로봇시뮬레이션 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		// 일단 arr배열을 0으로 채우고 시작
		String[][] arr = new String[B][A];
		for(int i=0;i<B;i++) {
			Arrays.fill(arr[i], "0");			
		}
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//로봇의 개수
		int M = Integer.parseInt(st.nextToken());//명령의 개수
		String[] dir = {"N","E","S","W"};
		
		// 로봇 이름이 1부터니까 list크기도 N+1로 만들어준다
		List<int[]>[] robot = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String z = st.nextToken();
			// 주어진 x,y좌표값을 배열에 맞게 바꿔서 배열에 값(로봇의 위치)을 채워준다
			arr[B-y][x-1]=z;
			// 그리고 로봇 각각의 이름의 리스트에 로봇의 위치를 저장한다
			robot[i]=new ArrayList<>();
			robot[i].add(new int[] {B-y,x-1});
		}
		// 벽에 부딪힐 경우 wall은 true가 된다
		boolean wall=false;
		// 로봇과 부딪힐 경우 crush 값은 true가 된다
		boolean crush=false;
		// true가 되었을 때 X에 움직이던 로봇을 저장하고, Y에 부딪힌 로봇을 저장한다 
		int X = 0;
		int Y = 0;
		out: for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int robo = Integer.parseInt(st.nextToken()); //명령을 내리는 로봇
			String com = st.nextToken(); // 명령의 종류
			int rep = Integer.parseInt(st.nextToken()); // 명령의 반복 횟수
			// rep값 만큼 명령을 반복한다
			for(int z=0;z<rep;z++) {
				// 명령을 받은 로봇의 위치를 가져온다
				int[] curr = robot[robo].get(0);
				int r = curr[0]; //로봇의 행 값
				int c = curr[1]; //로봇의 열 값
				// 해당 로봇이 향하고 있는 방향의 dir 배열에서의 인덱스값
				int dirIdx = Arrays.asList(dir).indexOf(arr[r][c]);
				// 명령이 L일 경우 왼쪽으로 90도 회전한다
				if(com.equals("L")) {
					dirIdx=(dirIdx+3)%4;
				}
				// 명령이 R일 경우 오른쪽으로 90도 회전한다
				else if(com.equals("R")) {
					dirIdx=(dirIdx+1)%4;
				}
				// 명령이 F일 경우 방향에 따라 이동한다
				else if(com.equals("F")) {
					
					if(dir[dirIdx].equals("N")) r=r-1;
					else if(dir[dirIdx].equals("E")) c=c+1;
					else if(dir[dirIdx].equals("S")) r=r+1;
					else if(dir[dirIdx].equals("W")) c=c-1;
					
					// 이동했을 때 배열을 벗어나면 벽에 부딪히는 것이므로
					// wall을 true로 바꿔주고 그 당시의 로봇의 번호를 X에 저장하고 나간다
					if(r<0 || r>=B || c<0 || c>=A) {
						wall = true;
						X = robo;
						break out;
					}
					// 이동했을 때 값이 0이 아니라면 해당 위치에 다른 로봇이 있다는 것이므로
					// crush를 true로 바꾸고 그 당시의 로봇의 번호를 X에 저장한다
					if(!arr[r][c].equals("0")) {
						crush = true;
						X = robo;
						// 그리고 해당 r,c 위치에 있는 로봇을 찾아서 Y에 저장하고 나간다
						for(int j=1;j<=N;j++) {
							int[] tmp = robot[j].get(0);
							if(tmp[0]==r && tmp[1]==c) {
								Y=j;
								break out;
							}
						}
					}
				}
				// 각 명령에 따라 변화한 값을 arr, robot리스트에 반영해주고,
				// 로봇이 이동했을 경우 이동하기 전 arr값을 0으로 바꿔준다
				arr[curr[0]][curr[1]]="0";
				arr[r][c] = dir[dirIdx];
				robot[robo].get(0)[0]=r;
				robot[robo].get(0)[1]=c;
			}//rep
			
		}//M
		// 벽에 부딪힌 경우, 로봇에 부딪힌 경우, 둘 다 아닌 경우 각각에 따라 올바른 결과값을 출력한다
		if(wall) System.out.println("Robot "+X+" crashes into the wall");
		else if(crush) System.out.println("Robot "+X+" crashes into robot "+Y);
		else System.out.println("OK");
		
	}//main

}
