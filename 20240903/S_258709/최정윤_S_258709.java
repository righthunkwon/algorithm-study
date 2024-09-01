import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        //완탐+백트래킹해야할 것 같은디?
        //먼저 n/2개 셀렉
        //6의 10제곱 * 10C5=60,466,176*252 엥 시간초과 안나나?
        this.dice=dice;
        n=dice.length;
        my_dice=new boolean[n];
        max=0;
        answer = new int[n/2];
        select(0,0);     
        return answer;
    }
    public static void select(int idx, int cnt){//A주사위 조합
        if(cnt==n/2){
            count();
            return;
        }
        if(idx>=n) return;
        my_dice[idx]=true;
        select(idx+1,cnt+1);
        my_dice[idx]=false;
        select(idx+1,cnt);
    }
    public static void count(){ //A가 이기는 수 구하는 메소드
        //주사위 n개의 index를 다 접근하는 것은 비효율... 
        //주사위합 구하기
        A_list= new ArrayList();
        B_list= new ArrayList();
        sum(0,true,0,0);
        sum(0,false,0,0);
        Collections.sort(B_list);
        int cnt=0;
        for(int i=0;i<A_list.size();i++){
            int A=A_list.get(i);
            //A가 B보다 큰 것 찾아야함 
            int st=0;
            int ed=B_list.size()-1;
            int mid;
            int ans=-1;
            while(st<=ed){
                mid=(st+ed)/2;
                if(B_list.get(mid)<A){ //A보다 B가 작다면 일단 저장 idx키워본다.
                    ans=Math.max(mid,ans);
                    st=mid+1;
                }else{
                    ed=mid-1;
                }
            }
            cnt+=ans+1;
        }
        if(cnt>max){
            max=cnt;
            int idx=0;
            for(int i=0;i<n;i++){
                if(my_dice[i]) {
                    answer[idx]=i+1;
                    idx++;
                }
            }
            
        }
    }
    public static void sum(int idx,boolean tf,int cnt,int sum){//A주사위 합 경우의 수, B주사위 합 경우의 수 구하는 메소드
        if(cnt==n/2&&tf) {//A 주사위면
            A_list.add(sum);
            return;
        }
        if(cnt==n/2&&!tf){//B 주사위면
            B_list.add(sum);
            return;
        }
        if(my_dice[idx]==tf){
            for(int j=0;j<6;j++){
                sum(idx+1,tf,cnt+1,sum+dice[idx][j]);
            }
        }else{
            sum(idx+1,tf,cnt,sum);
        }
    }
    static boolean[] my_dice;
    static int[] answer;
    static int[][] dice;
    static int n, max;
    static List<Integer> A_list,B_list;
}
