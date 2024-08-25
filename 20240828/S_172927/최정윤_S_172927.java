import java.util.*;
import java.io.*;

class Solution {
    public static class Five implements Comparable<Five>{
        int sum;
        List<String> list;
        public Five(int sum,List<String> list){
            this.sum=sum;
            this.list=list;
        }
        public int compareTo(Five f){//내림차순
           return f.sum-this.sum;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        //길이 50, 무조건 5개씩
        //다이아 25 철 5 돌 1
        //처음에 곡괭이로 캘 수 있는 광물 수만큼만 담기
        
        List<Five> group_list=new ArrayList();
        int sum=0;
        List<String> list=new ArrayList();
        int end=minerals.length;
        if(minerals.length>(picks[0]+picks[1]+picks[2])*5){
            end=(picks[0]+picks[1]+picks[2])*5;
        }
        for(int i=0;i<end;i++){
            if(minerals[i].equals("diamond")){
                sum+=25;
                list.add("diamond");
            }
            else if(minerals[i].equals("iron")){
                sum+=5;
                list.add("iron");
            }
            else {
                sum+=1;
                list.add("stone");
            }
            if(i%5==4){
                group_list.add(new Five(sum,list));
                list=new ArrayList();
                sum=0;
            }
        }
        if(sum!=0) group_list.add(new Five(sum,list));
        
        Collections.sort(group_list);
        int answer = 0;
        //가장 높은 것부터 꺼내서 다이아부터 지정
        int idx=0;
        for(int i=0;i<group_list.size();i++){
         
            //picks 선택
            while(true){
                if(idx==3) return answer;
                else if(picks[idx]==0) idx++;
                else {
                    picks[idx]--;
                    break;
                }
            }
            //피로도 계산하기
            Five f=group_list.get(i);
            for(String str:f.list){
                if((idx==1&&str.equals("diamond"))||(idx==2&&str.equals("iron")))answer+=5;
                else if(idx==2&&str.equals("diamond"))answer+=25;
                else answer+=1;
                // System.out.println("무슨일이지!!"+answer);
            }   
        }   

        return answer;
    }
}
