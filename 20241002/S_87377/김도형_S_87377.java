import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(int[][] line) {
        
        //그림 크기를 구하기 위해 
        long max_x = Long.MIN_VALUE;
        long min_x = Long.MAX_VALUE;
        long max_y = Long.MIN_VALUE;
        long min_y = Long.MAX_VALUE;
        
        //좌표 저장용 큐
        Queue<Long>qx = new LinkedList<>();
        Queue<Long>qy = new LinkedList<>();
        
        //직선 2개씩 골라 교점이 정수인 좌표 구하기 
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long adbc = a*d - b*c;
                if(adbc == 0)continue; //AD-BC=0인 경우 두 직선 평행 또는 일치
                
                long bfed = b*f - e*d;
                if(bfed % adbc != 0)continue;//안나눠떨어지면 정수좌표 아님
                
                long ecaf = e*c - a*f;
                if(ecaf % adbc != 0)continue;//안나눠떨어지면 정수좌표 아님
                
                long x = bfed / adbc;
                long y = ecaf / adbc;
                
                min_x = Math.min(min_x,x);
                max_x = Math.max(max_x,x);
                min_y = Math.min(min_y,y);
                max_y = Math.max(max_y,y);
                
                qx.add(x);
                qy.add(y);
            }
        }
        
        //그림판 생성
        boolean[][] map = new boolean[(int)(max_y - min_y +1)][(int)(max_x - min_x +1)];
 
        //별 그릴 곳만 true로 
        while(!qx.isEmpty()){
            long nx = qx.poll();
            long ny = qy.poll(); 
            int x= (int)(nx-min_x);
            int y= (int)(max_y-ny);
            map[y][x]=true;
        }
        
        String[] answer = new String[(int)(max_y - min_y +1)];

        //그림 그리기
        for(int i=0;i<(int)(max_y - min_y +1);i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<(int)(max_x - min_x +1);j++){
                if(map[i][j])sb.append("*");
                else sb.append(".");
            }
            answer[i]=sb.toString();
        }
        
        
        return answer;
    }
    
}
