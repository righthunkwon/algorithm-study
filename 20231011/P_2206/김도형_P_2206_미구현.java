package AlgoStudy;

import java.util.Scanner;

public class BOJ_Q2206_벽_부수고_이동하기 {
	
	
	static int N,M;
	static int [][]map;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt(); // N*M 행렬 입력받기
        
        // 개행 문자 제거
        sc.nextLine();
        
        // 맵 정보를 입력
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String x = sc.nextLine(); //한줄 받아서
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(x.charAt(j))); //쪼개서 배열에 넣기
            }
        }//입력 끝
        
        
        
        
       
    }//main
    
    public static int bfs() {
    	int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
    	
    	
    	
    	
    	
    	return -1; //불가능하면 -1 출력
    	
    }
    
    
    
}//class
