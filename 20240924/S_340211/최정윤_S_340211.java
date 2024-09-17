import java.io.*;
import java.util.*;

class Solution {
    static int[] dr,dc;    
    static int[][] points,routes;
    static Map<Integer,Integer>[][] arr;
    public int solution(int[][] points, int[][] routes) {
        //bfs 문제인줄 알았는데 그냥 r 움직이고 c 움직이면 되네 
        //2차원배열에 map 넣어놓고  depth를 저장
        dr=new int[]{-1,1,0,0};
        dc=new int[]{0,0,1,-1};
        this.points=points;
        this.routes=routes;
        arr=new HashMap[101][101];
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                arr[i][j]=new HashMap();
            }
        }
        for(int i=0;i<routes.length;i++){
            move(i);   
        }
        int answer = 0;
        //map 보면서 겹친거 찾기
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                for(Integer key:arr[i][j].keySet()){
                    if(arr[i][j].get(key)>1) { //같은 depth의 수가 2이상이면 겹친 것
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static void move(int i){
        int time=0;
        
        for(int j=0;j<routes[i].length-1;j++){
            int[] st=points[routes[i][j]-1];
            int[] ed=points[routes[i][j+1]-1];
            if(j==0){//출발지 넣어주기
                int cnt=arr[st[0]][st[1]].getOrDefault(time,0);
                arr[st[0]][st[1]].put(time,cnt+1);
                time++;
            }
            //r이동 겹치니까 출발지 빼고 넣기 
            if(st[0]>=ed[0]){
                for(int k=st[0]-1;k>=ed[0];k--){
                    int cnt=arr[k][st[1]].getOrDefault(time,0);
                    arr[k][st[1]].put(time,cnt+1);
                    time++;
                }
            }else{
                for(int k=st[0]+1;k<=ed[0];k++){        
                    int cnt=arr[k][st[1]].getOrDefault(time,0);
                    arr[k][st[1]].put(time,cnt+1);
                    time++;
                }
            }
            //c이동
            if(st[1]>=ed[1]){
                for(int k=st[1]-1;k>=ed[1];k--){
                    int cnt=arr[ed[0]][k].getOrDefault(time,0);
                    arr[ed[0]][k].put(time,cnt+1);
                    time++;
                }
            }else{
                for(int k=st[1]+1;k<=ed[1];k++){
                    int cnt=arr[ed[0]][k].getOrDefault(time,0);
                    arr[ed[0]][k].put(time,cnt+1);
                    time++;
                }
            }
        }
    }
}
