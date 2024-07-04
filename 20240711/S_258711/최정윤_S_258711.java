import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        //모양의 공통점을 찾고 dfs로 돌리면 알 수 있을 것 같다
        //방문하다가 나가는 선이 2개면 8
        //방문하다가 방문한 곳 다시 돌아오면 도넛 
        //일단 나한테 들어오는게 없고 나가는게 2개 이상이다 => 정점
        arr=new ArrayList[edges.length+2]; //간선이 3개면 최대 node가 4개, node 번호 1부터 시작
        for(int i=1;i<edges.length+2;i++){
            arr[i]=new ArrayList();
        }
        //들어오는 게 없는지 확인하는 배열
        boolean[] in=new boolean[edges.length+2];
        for(int i=0;i<edges.length;i++){
            arr[edges[i][0]].add(edges[i][1]);
            in[edges[i][1]]=true;
        }
        //무관한 정점 찾기
        int mid=-1;
        for(int i=1;i<edges.length+2;i++){
            if(!in[i]&&arr[i].size()>=2){
                mid=i;
                break;
            }
        }
        
        visited=new boolean[edges.length+2];
        int[] answer = new int[4];
        for(Integer n:arr[mid]){
            shape=-1;
            dfs(n);
            if(shape==0){
                answer[1]++;
            }else if(shape==8){
                answer[3]++;
            }else{
                answer[2]++;
            }
        }
 
        answer[0]=mid;
        return answer;
    }
    static List<Integer>[] arr;
    static boolean[] visited;
    static int shape;
    public static void dfs(int n){
        if(arr[n].size()==2){
            shape=8;
            return;
        }
        visited[n]=true;
        for(Integer node:arr[n]){
            if(visited[node]) {
                shape=0;
                return;
            }
            dfs(node);
        }
    }
}
