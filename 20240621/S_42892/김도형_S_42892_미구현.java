import java.io.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        int[][] answer = {};
        return answer;
    }
    
    class Node{
        int x, y, num; //노드 x,y좌표와 번호
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
}
