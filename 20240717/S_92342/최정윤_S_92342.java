import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        //10점부터 어피치가 맞힌 개수+1 만큼으로 dfs 
        n2=n;
        info2=info;
        max=0;
        answer = new int[11];
        li=new int[11];
        dfs(n,0);
        if(max==0) answer=new int[]{-1};
        return answer;
    }
    
    public static void dfs(int cnt,int num){
        if(cnt==0){ //화살을 다 썼다면
            int tot=cal();
            if(max<tot){
                max=tot;
                answer=li.clone();
            }else if(max==tot){//점수는 같다면 낮은 점수 많은 배열을 선택
                for(int i=10;i>=0;i--){
                    if(li[i]>answer[i]){
                        answer=li.clone();
                        break;
                    }else if(li[i]<answer[i]) break;
                }
            }
            return;
        }
        else if(cnt<0) return;//범위초과
        if(num==11) return;
        if(cnt-info2[num]>0){//이길 만큼의 활이 있다면
            li[num]=info2[num]+1;
            dfs(cnt-li[num],num+1);
        }else{//활이 부족하다면 그만큼이라도 쏘기
            li[num]=cnt;
            dfs(0,num+1);
        }
        li[num]=0;//활 쏜 개수 제자리
        dfs(cnt,num+1);//안쏘고 다음 점수로 
    }
    public static int cal(){//점수 계산하기
        int tot=0;
        for(int i=0;i<11;i++){
            if(li[i]>info2[i]) tot+=(10-i);
            else if(li[i]==0&&info2[i]==0) tot+=0; 
            else tot-=(10-i);
        }
        return tot;
    }
    static int n2,max;
    static int[] info2,answer,li;
}
