import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] order;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean[][] flag;
	static int num;
	static ArrayList<Integer> ax;
	static ArrayList<Integer> ay;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i =0;i<N;i++){
			String tmp = sc.next();
			for(int j =0;j<M;j++){
				String input = tmp.substring(j,j+1);
				if(input.equals("x")){
					arr[i][j] = 1;
				}
			}
		}
		// 미네랄이 있는자리는 일단 -1로 값 설정
		// 입력끝

		// 명령은 일단 입력받는 즉시 실행해도 될듯
		// 1. 일단 좌측 또는 우측에서 쏴서 미네랄 제거
		// 2. 클러스터 묶음 확인
		// 3. 만약 클러스터가 떠있으면 낙하 시키기 순서
		order = new int[sc.nextInt()];
		for(int i =0;i<order.length;i++){
			order[i] = N-sc.nextInt();
//			System.out.println(order[i]);
			// i가 만약 짝수면 좌측에서 시작
			// 홀수면 우측에서 미네랄 제거 시작
			if(i%2 == 0){ 
				left(order[i]);
			}
			else{ 
				right(order[i]); 
			}
			
			find();
		}
		// 다내리면 출력
		for(int i =0;i<N;i++){
			for(int j =0;j<M;j++){
				if(arr[i][j] !=0) {
					System.out.print("x");
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println();
		}


	}
	static int dx[] ={0,0,-1,1};
	static int dy[] = {1,-1,0,0};

	// 좌측에서 제거 시키는 메서드
	public static void left(int height){
		for(int i =0;i<M;i++){
			// 좌측에서 시작해서 만약 미네랄 만나면
			// 값을 0으로 바꿔주고 바로 return
			if(arr[height][i] != 0){
				arr[height][i] =0;
				return;
			}
		}
	}
	// 우측에서 제거 시키는 메서드
	public static void right(int height){
		for(int i =M-1;i>=0;i--){
			// 우측에서 시작해서 만약 미네랄 만나면
			// 값을 0으로 바꿔주고 바로 return
			if(arr[height][i] != 0){
				arr[height][i] =0;
				return;
			}
		}
	}
	// 미네랄 묶음 확인해서 묶음 별로 값 다르게 설정해주기
	public static void find() {
		num = 1; // 1부터시작해서 묶음 만날때마다 +1
		flag = new boolean[N][M]; // 방문처리 해줌
		for(int i =0;i<N;i++){
			for(int j =0;j<M;j++){
				if(arr[i][j] !=0 && !flag[i][j]){
					// 미네랄이며 아직 방문처리하지 않은
					// 클러스터를 발견하면 번호를 매기는 메서드 실행
					// 만약 번호 매기는 중간에
					// 미네랄 내리는 과정있으면 어차피 다 바뀌어야해서 return
					if(setnum(i,j,num)){
						return;
					}
					// 해당묶음 다 번호 매겼으면 num +1
					num ++;
				}
			}
		}
		// 번호다 매겼으면 공중에 떠있는지 확인
	}
	public static boolean setnum(int i, int j, int num) {
		qx = new LinkedList<>();
		qy = new LinkedList<>();
		ax = new ArrayList<>();
		ay = new ArrayList<>();
		// 큐에다가 x ,y 추가해서 묶음에 다 같은값 넣어주기
		qx.add(i);
		qy.add(j);
		int min =0; // 높이를 판단해야해서 min을 일단 0설정
		while(true) {
			if(qx.size()==0){
				// 번호다 매겼으니간 큐 사이즈 0 이면 return
				break;
			}
			// 큐에있는거 꺼내서
			int x = qx.poll();
			int y = qy.poll();
			// 4방향 탐색해서 방문안한 미네랄
			// 다 큐에 추가하고 값 num으로 바꾸기
			min = Math.max(min, x); // 높이가 값이 큰게 바닥에 있는거라 판단
//			System.out.println("min"+" "+min);
			for(int in = 0;in <4;in++){
				int nx = x+ dx[in];
				int ny = y+ dy[in];
				// 범위 벗어나거나 0이거나 방문했으면 맨위로
				if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny] ==0 || flag[nx][ny]){
					continue;
				}
				arr[nx][ny] = num;
				flag[nx][ny] = true;
				qx.add(nx);
				qy.add(ny);
				// 방문처리 + 번호 + 큐에 추가
			}
			// 현재 미네랄 좌표를 리스트에 넣음
			ax.add(x);
			ay.add(y);
		}
		// 이 과정 끝나면 같은 클러스트들은 현재 값이 설정되어있음
		// 이 클러스트들 min 값이 N-1이 아니면 떠있는거라
		// +1을 통해서 계속 내려주기
		if(min != N-1){
			down(ax ,ay);
			// 땅에 안붙은 경우
			return true;
		}
		return false;
	}

	//
	public static void down(ArrayList<Integer> arx , ArrayList<Integer> ary) {
		int tmp = 1;
		// 일단 현재 클러스터 전체를
		// 0으로 바꿈
		for(int i =0;i<arx.size();i++){
//			System.out.println(arx.get(i)+" "+ary.get(i)+"!");
			arr[arx.get(i)][ary.get(i)] = 0;
//			System.out.println(arx.get(i)+" "+ary.get(i)+"!");
		}
		// 얼마나 내려갈 수 있는지 판단 ㄱㄱ
		a: while(true) {
			for(int i =0;i<arx.size();i++){
				if(arx.get(i)+tmp == N || arr[arx.get(i)+tmp][ary.get(i)] !=0) {
					// 땅에 닿거나 미네랄을 만나면(다른 클러스터만) break
					tmp --;
					break a;
				}
			}
			tmp++;
		}
		// 이 과정끝나면 리스트에 있는것들 모두 tmp만큼 더해서 num으로 만들기
		for(int i =0;i<arx.size();i++){
//			System.out.println(arx.get(i)+" "+tmp);
			arr[arx.get(i)+tmp][ary.get(i)] = num;
		}


	}
}
