package _20231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15684_사다리조작 {
    static int N,M,H,plus;
    static int[][] ladder;
    static boolean finish = false; // dfs에서 나가기 위한 boolean
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 세로선의 개수
        M = Integer.parseInt(st.nextToken()); // 가로선의 개수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수  있는 위치의 개수
        ladder = new int [H+1][N+1]; // 줄 수가 1부터 시작하기 때문에 배열을 1씩 크게 만든다
        // 놓여진 가로 선의 위치를 받아온다
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 가로 사다리 추가하는 것 위치에서 왼쪽은 1, 오른쪽은 2로 받아온다
            // 밑에서 사다리타기 할 때 1일 때 오른쪽으로 가고, 2일 때 왼쪽으로 갈거임
//            System.out.println(a +" "+b);
            ladder[a][b]=1;
            ladder[a][b+1]=2;
        }
//        System.out.println(Arrays.deepToString(ladder));
        for(int i=0;i<=3;i++) {
            plus = i; // 추가하는 사다리 개수
            dfs(1,0);
            if(finish) break; // finish가 true이면 그대로 나간다
            plus=-1; // i가 3까지 갔는데도 true안나오면 -1 출력해줘야 한다
        }
        System.out.println(plus);
    }//main
    static void dfs(int x,int cnt) {
    	if(finish) return;
        if(cnt == plus) { // cnt가 plus만큼 되었을 때
        	 // i2i가 true이면 사다리 조작이 잘 되었단 의미이므로 true finish를 true로 바꿔준다
            if(i2i()) finish = true;
            // 아닐땐 그냥 return
            return;
        }
        
        // 사다리를 추가로 놓아본다
        for(int i=x;i<=H;i++) {
        	
        	// 주어지는 숫자가 사다리 왼쪽 기준으로 주어지기 때문에 N은 포함시키지 않는다(범위조심)
            for(int j=1;j<N;j++) { 
            	// 사다리를 설치할 양 쪽 끝이 둘 다 0이면 설치 가능
                if(ladder[i][j]==0 && ladder[i][j+1]==0) {
                	// 왼쪽을 1로하고, 오른쪽을 2로 해서 사다리를 설치한다
                    ladder[i][j]=1;
                    ladder[i][j+1]=2;
//                    System.out.println(Arrays.deepToString(ladder));
//                    System.out.println(i+" "+ plus+" " + cnt);
                    // 또 사다리 설치한다
                    dfs(i,cnt+1);
                    
                    ladder[i][j]=0;
                    ladder[i][j+1]=0;
                }
            }
        }
        
    }//dfs
    
    // 사다리 출발과 도착이 원하는대로 가는지 확인
    static boolean i2i() {
        for(int i=1;i<=N;i++) {
        	// for 문이 돌 때 사다리 타기를 실행하는 변수를 설정
        	// x는 사다리타기 하는 깊이를 나타내고,
        	// y는 옆으로 사다리 타기하며 이동하는 것을 나타낸다.
            int x=1; int y=i;
            for(int j=0;j<H;j++) { // 가로로 이동하는건 사다리 개수는 H개 미만임
                // 사다리 번호가 1이면 오른쪽으로 한 칸 수평 이동
                // 사다리 번호가 2이면 왼쪽으로 한 칸 수평 이동
            	// 두 조건 중에 하나만 실행되어야 하니까 if/else if로 해준다
                if(ladder[x][y]==1) y++;
                else if(ladder[x][y]==2) y--;
                //그 다음으로 넘어갈 때 x도 밑으로 수직 한 칸 이동
                x++;
            }
            if (y!=i) return false; // 하나라도 i번째로 돌아오지 못하면 false 출력
        }
        return true; // 모든 i번째 사다리가 i번째로 다시 돌아와서 끝남
    }//i2i
    

}
