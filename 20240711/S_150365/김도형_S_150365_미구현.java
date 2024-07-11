import java.util.*;
import java.io.*;

class Solution {
    
    //아래 , 왼쪽, 오른쪽, 위 순서가 알파벳순
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int stx,sty,edx,edy;
    static int [][]map;
    static int move;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        move = k; //반드시 총 k번 이동해야만 함
        stx=x; //시작점
        sty=y;
        edx=r; //도착점
        edy=c;
        
        map = new int[n][m];
        
        //일단 탈출 가능 여부 확인
        int dist = distance(stx,sty,edx,edy);
        //최단 거리가 k보다 멀거나, k번 이동(와리가리쳐서)해서 도착 불가하면
        if (distance > k || (k - distance) % 2 == 1) return "impossible";
        
        String answer = "";
        return answer;
    }
    
    //거리 측정 메서드
    static int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
    
    
    
}
