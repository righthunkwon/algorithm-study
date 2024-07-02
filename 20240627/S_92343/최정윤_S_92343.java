import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        info2=info;
        arr=new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            arr[i]=new ArrayList();
        }
        for(int i=0;i<edges.length;i++){
            int n1=edges[i][0];
            int n2=edges[i][1];
            arr[n1].add(n2);
           
        }
        cnt=0;
        List<Integer> list=new ArrayList();
        list.add(0);
        dfs(0,0,0,list);
        answer=cnt;
        return answer;
    }
    static List<Integer>[] arr;
    static int cnt;
    static int[] info2;
    public static void dfs(int n,int s, int w,List<Integer> list){
        if(info2[n]==0)s++;
        else if(info2[n]==1) w++;
        if(s<=w) {        
            return;
        }
        cnt=Math.max(s,cnt);
        List<Integer> newList=new ArrayList(list);
        newList.addAll(arr[n]);
        newList.remove(Integer.valueOf(n));
        //integer.valueOf 인덱스 삭제 안하려면 object로 줘야해서 ..
        for(Integer num:newList){
            dfs(num,s,w,newList);
        }
    }
}
