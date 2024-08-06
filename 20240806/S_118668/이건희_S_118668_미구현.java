// 못 풀었습니다 ㅠㅡㅜ
import java.util.*;
// 알고리즘과 코딩 능력을 향상시켜 모든 주어진 코딩 문제를 풀 수 있는 최소 시간을 구하는 문제
class Node{
    int alp, cop, cost;
    Node(int alp, int cop, int cost){
        this.alp = alp;
        this.cop = cop;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = Integer.MIN_VALUE, maxCop = Integer.MIN_VALUE;
        int[][] v = new int[1000][1000];

        for(int i=0; i<problems.length; i++){
            if(maxAlp<problems[i][0]){
                maxAlp = problems[i][0];
            }
            if(maxCop<problems[i][1]){
                maxCop = problems[i][1];
            }
        }

        for(int i=0; i<v.length; i++){
            for(int j=0; j<v[0].length; j++){
                v[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.cost<n2.cost){
                    return -1;
                }else if(n1.cost>n2.cost){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        pq.add(new Node(alp,cop,0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.alp >= maxAlp && n.cop >= maxCop){
                return n.cost;
            }
            if(v[n.alp+1][n.cop]>n.cost+1){
                pq.add(new Node(n.alp+1,n.cop,n.cost+1));
                v[n.alp+1][n.cop] = n.cost+1;
            }
            if(v[n.alp][n.cop+1]>n.cost+1){
                pq.add(new Node(n.alp,n.cop+1,n.cost+1));
                v[n.alp][n.cop+1] = n.cost+1;
            }
            for(int i=0; i<problems.length; i++){
                if(n.alp>=problems[i][0]&&n.cop>=problems[i][1]&&v[n.alp+problems[i][2]][n.cop+problems[i][3]]>n.cost+problems[i][4]){
                    pq.add(new Node(n.alp+problems[i][2],n.cop+problems[i][3],n.cost+problems[i][4]));
                    v[n.alp+problems[i][2]][n.cop+problems[i][3]]=n.cost+problems[i][4];
                }
            }
        }
        return answer;
    }
}
