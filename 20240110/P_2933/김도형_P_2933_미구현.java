package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Q2933_미네랄 {
	static char[][]cave;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행(row)과 열(column) 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 미네랄 정보 입력 받기
        char[][] cave = new char[R][C];
        for (int i = 0; i < R; i++) {
            cave[i] = br.readLine().toCharArray();
        }
        
        int N = Integer.parseInt(br.readLine());
        int[]chang=new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	chang[i]=Integer.parseInt(st.nextToken());
        }
        
        static void throwChang(int height, boolean left) {
            if (left) {
                for (int j = 0; j < cave[0].length; j++) {
                    if (cave[height][j] == 'x') {
                        cave[height][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j = cave[0].length - 1; j >= 0; j--) {
                    if (cave[height][j] == 'x') {
                        cave[height][j] = '.';
                        break;
                    }
                }
            }
        }
        
        
    }
}
