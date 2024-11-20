import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer,Integer.MAX_VALUE);
        /*
        012  X 기준으로 둘러싸고 있는 확장된 가상의 당구대를 만들어
        3X4  목적구를 대칭이동시켜서 복사한 좌표 8개를 구하고
        567  그 중 가장 가까운 거리를 구한다
        */
        int[][][]points = new int[balls.length][8][2];
        for(int i=0;i<balls.length;i++){
            int X = balls[i][0];
            int Y = balls[i][1];
            //가로 m 세로 n
            points[i][0]=new int[]{-X,2*n-Y};//왼쪽위
            points[i][1]=new int[]{X,2*n-Y};//위
            if(startX==X && startY<Y){ 
                //목적구가 일직선 위쪽에 있으면 예외처리
                points[i][1][0]=3000;
                points[i][1][1]=3000;
            }
            points[i][2]=new int[]{2*m-X,2*n-Y};//오른쪽위
            points[i][3]=new int[]{-X,Y};//왼쪽
            if(startY==Y&&startX>X){ 
                //목적구가 일직선 왼쪽에 있으면 예외처리
                points[i][3][0]=3000;
                points[i][3][1]=3000;
            }
            points[i][4]=new int[]{2*m-X,Y};//오른쪽
            if(startY==Y&&startX<X){ 
                //목적구가 일직선 오른쪽에 있으면 예외처리
                points[i][4][0]=3000;
                points[i][4][1]=3000;
            }
            points[i][5]=new int[]{-X,-Y};//왼쪽아래
            points[i][6]=new int[]{X,-Y};//아래
            if(startX==X && startY>Y){ 
                //목적구가 일직선 아래에 있는 경우 예외처리
                points[i][6][0]=3000;
                points[i][6][1]=3000;
            }
            points[i][7]=new int[]{2*m-X,-Y};//오른쪽아래
            
            //원쿠션 최소거리 계산
            for(int j=0;j<8;j++){
                int a = points[i][j][0]-startX;
                int b = points[i][j][1]-startY;
                answer[i] = Math.min(answer[i],a*a+b*b);
            }

        }

        return answer;
    }
}
