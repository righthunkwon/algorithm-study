import java.io.*;
import java.util.*;

//본인 좌표 기준 y 작고, x가 작은 것 자식 중 왼쪽 노드
//                   , x가 큰 것 자식 노드 중 오른쪽 노드
//sort 하거나 pq 사용해보자
class Solution {
    public static class Node{
        private int x,y,n;
        public Node(int x,int y,int n){
            this.x=x;
            this.y=y;
            this.n=n;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        
        for(int i=0;i<nodeinfo.length;i++){
            Node node=new Node(nodeinfo[i][0],nodeinfo[i][1],i);
        }
        int[][] answer = {};
        
        return answer;
    }
 
}
