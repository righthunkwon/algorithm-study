package _20240313;

import java.util.*;
import java.io.*;

public class _7682_틱택토 {
	static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("end")) {
                break;
            }
            
            map = new char[3][3];
            
            int xCnt = 0; // X 총 몇개인지 세는거
            int oCnt = 0; // O 총 몇개인지 세는거
            int idx = 0; // tmp를 map에 입력하기 위한 idx

            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                	
                	// map에 입력값 넣어주고 X, O 개수를 각각 세줌
                    map[i][j] = tmp.charAt(idx++);
                    
                    if (map[i][j] == 'X') {
                        xCnt++;
                    }
                    else if (map[i][j] == 'O') {
                        oCnt++;
                    }
                }
            }
            // X가 이긴 경우(X가 먼저 두니까 X가 O보다 하나 더 둔 경우만 가능함)
            if (xCnt == oCnt+1) {
            	
            	// 판이 전부 차고 O가 빙고 아닐때
                if (xCnt + oCnt == 9 && !bingo('O')) {
                    sb.append("valid").append("\n");
                }
                // O가 빙고 아니고 X가 빙고일때
                else if (!bingo('O') && bingo('X')) {
                    sb.append("valid").append("\n");
                }
                // 그 외에는 유효하지 않은 경우임
                else {
                    sb.append("invalid").append("\n");
                }
            }
            
            // O가 이긴 경우(X가 먼저 두니까 X와 O의 개수가 같은 경우만 가능함)
            else if (xCnt == oCnt) {
            	
            	// X가 빙고 아니고 O만 빙고일 때
                if (!bingo('X') && bingo('O')) {
                    sb.append("valid").append("\n");
                }
                // 그 외에는 유효하지 않은 경우임
                else {
                    sb.append("invalid").append("\n");
                }
            }
            // 그 외에도 모두 유효하지 않은 경우
            else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb);
    }//main

    public static boolean bingo(char c) {
        // 가로
        for (int i=0;i<3;i++) {
            if (map[i][0]==c && map[i][1]==c && map[i][2]==c) {
                return true;
            }
        }
        // 세로
        for (int i=0;i<3;i++) {
            if (map[0][i]==c && map[1][i]==c && map[2][i]==c) {
                return true;
            }
        }
        // 대각선(우하향)
        if (map[0][0]==c && map[1][1]==c && map[2][2]==c) {
            return true;
        }
        // 대각선(우상향)
        if (map[0][2]==c && map[1][1]==c && map[2][0]==c) {
            return true;
        }
        return false;
    }//bingo
}
