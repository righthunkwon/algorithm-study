package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q20055_컨베이어_벨트_위의_로봇 {
	static int N,K,step;
	static int[]beltHP; //벨트 내구도 배열
	static boolean[]robot; //로봇 있는지 여부 확인용 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //칸 수
		K = sc.nextInt(); //내구도 0이 K개 되면 종료
		beltHP=new int[2*N];//벨트 내구도 배열 초기화
		robot=new boolean[2*N]; //로봇 있는지 여부 확인용 배열 초기화
		for(int i=0;i<2*N;i++) {
			beltHP[i]=sc.nextInt();
		}
		step=0; //몇단계째인지
		l:while(true) {
			step++;
			rotate();//회전
			robotmove();//로봇이동			
			int cnt = 0;
	        for(int i = 0 ; i < 2*N ; i++){
	            if(beltHP[i] == 0)
	                cnt++;
	            if(cnt>=K)break l;//내구도 0인 칸의 수가 K개되면 끝내기
	        }
		}
		System.out.println(step);//몇단계인지 출력
	}//main
	
	//벨트 회전
	public static void rotate() {
		//벨트 이동
		int tmp = beltHP[2*N-1];
		for(int i=2*N-1;i>0;i--) {
			beltHP[i]=beltHP[i-1];
		}
		beltHP[0]=tmp;
		
		//로봇도 같이 이동
		for(int i=N-1;i>0;i--) {
			robot[i]=robot[i-1];
		}
		robot[0]=false;
		robot[N-1]=false; //맨 끝 로봇 내리기
	}
	
	//로봇 전진
	public static void robotmove() {
		robot[N-1]=false; //맨 끝 로봇 내림
		//앞으로 전진이 가능하면 전진하기
		for(int i=N-2;i>=0;i--) {
			//현재 위치에 로봇이 있고, 앞에 로봇이 없고, 전진할 위치의 내구도가 0이 아니면 전진한다
			if(robot[i]&&!robot[i+1]&&beltHP[i+1]>0) {
				robot[i]=false;
				robot[i+1]=true;
				beltHP[i+1]--;//전진했으면 내구도 깎기
			}
		}
		//로봇 올려놓기
		if(!robot[0]&&beltHP[0]>0) {
			robot[0]=true;
			beltHP[0]--;
		}
	}
	
	
}//class
