import java.util.*;
import java.io.*;
class Solution {
    static int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        dfs(0,0,picks,minerals);
        
        return answer;
    }
    public void dfs(int depth,int total_stress,int[]picks,String[]minerals){
        //더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캤으면 return
        if(depth>=minerals.length || (picks[0]==0&&picks[1]==0&&picks[2]==0)){
            answer = Math.min(answer,total_stress);
            return;
        }
        
        //3가지 종류 곡괭이중 하나 선택해서 사용 못할때까지(최대 5번) 광물 캐기
        for(int i=0;i<3;i++){
            if(picks[i]>0){
                picks[i]--;
                int stress = total_stress;
                for(int j=depth;j<Math.min(depth+5,minerals.length);j++){
                    if(i==0){//다이아 곡괭이 사용
                        stress++;  
                    }else if(i==1){//철 곡괭이 사용
                        if(minerals[j].charAt(0)=='d'){
                            stress+=5;
                        }else{
                            stress++;
                        }  
                    }else{//돌 곡괭이 사용
                        if(minerals[j].charAt(0)=='d'){
                            stress+=25;
                        }else if(minerals[j].charAt(0)=='i'){
                            stress+=5;
                        }else{
                            stress++;
                        }  
                    }
                }//for j
                dfs(depth+5,stress,picks,minerals);
                picks[i]++;
            }
        }//for i  
    }
}
