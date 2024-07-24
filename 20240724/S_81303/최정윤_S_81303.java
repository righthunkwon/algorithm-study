import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        boolean[] remove=new boolean[n]; //지우면 true
        int now=k;
        int last=n-1; //가장 마지막 idx 저장
        int tot=0;
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<cmd.length;i++){
            String[] arr=cmd[i].split(" ");
            String alpa=arr[0];
            int cnt=0;
            if(arr.length>1) {
                cnt=Integer.parseInt(arr[1]);
            }

            switch(alpa){
                case "D": //u,d 이 연속으로 나오면 숫자만 쌓기 , 한번에 계산 , 이거 안하면 시간초과
                    tot+=cnt;
                    break;
                case "U":
                    tot-=cnt;
                    break;
                case "C": //c와 z가 나오면 미리 저장해놓은 움직이는 거 먼저 수행 후 지우거나 살려라
                    while(tot>0){
                        now++;
                        if(!remove[now]) tot--;
                    }                  
                    while(tot<0){
                        now--;
                        if(!remove[now]) tot++;
                    }
                    remove[now]=true;
                    stack.add(now);
                    int idx=now;
                    if(now==last){
                          while (remove[now]) now--;
                          last = now; 
                    }
                    else{
                         while (remove[now]) now++;
                    }
                    break;
                case "Z":
                     while(tot>0){
                        now++;
                        if(!remove[now]) tot--;
                    }                  
                    while(tot<0){
                        now--;
                        if(!remove[now]) tot++;
                    }
                    int re=stack.pop();
                    remove[re]=false;
                    last=Math.max(last,re);
                    result++;
                    break;
            }
        }
        
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++){
            if(remove[i])sb.append("X");
            else sb.append("O");
        }
        String answer = sb.toString();
        return answer;
    }
}
