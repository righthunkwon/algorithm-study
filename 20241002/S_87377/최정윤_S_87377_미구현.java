import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        //1000C2
        list=new ArrayList();
        select=new int[2];
        this.line=line;
        max_x=Integer.MIN_VALUE;
        min_x=Integer.MAX_VALUE;
        max_y=Integer.MIN_VALUE;
        min_y=Integer.MAX_VALUE;
        select(0,0);
        String[] answer = new String[max_y-min_y+1];
        String[][] ans = new String[max_y-min_y+1][max_x-min_x+1];
        int zero_x=-min_x;
        int zero_y=-min_y;
        System.out.println(min_x+"sd"+min_y);
        for(int[] xy:list){
            System.out.println(xy[0]+"xy"+xy[1]);
             System.out.println(zero_y-xy[1]+"xsssssy"+zero_x+xy[0]);
            // ans[zero_y-xy[1]][zero_x+xy[0]]="*";
        }
        // for(int i=0;i<ans.length;i++){
        //     StringBuilder sb=new StringBuilder();
        //     for(int j=0;j<ans[0].length;j++){
        //         if(ans[i][j]!="*") sb.append(".");
        //         else sb.append("*");
        //     }
        //     answer[i]=sb.toString();
        // }
        return answer;
    }
    public static void select(int idx,int sidx){
        if(sidx>=2) {
            cross();
            return;
        }
        if(idx>=line.length) return;
        select[sidx]=idx;
        select(idx+1,sidx+1);
        select(idx+1,sidx);
    }
    public static void cross(){
        int[] line1=line[select[0]];
        int[] line2=line[select[1]];
        double x,y;
        if(line1[0]==0&&line1[1]!=0&&line2[0]!=0&&line2[1]==0){
            x=-line2[2]/line2[0];
            y=-line1[2]/line1[1];
            if(x%1==0&&y%1==0){//정수라면
            list.add(new int[]{(int)x,(int)y});
            System.out.println("x"+x+"y"+y+"!111");
            max_x=Math.max((int)x,max_x);
            max_y=Math.max((int)y,max_y);
            min_x=Math.min((int)x,min_x);
            min_y=Math.min((int)y,min_y);
                
        }
        }else if(line2[0]==0&&line2[1]!=0&&line1[0]!=0&&line1[1]==0){
             x=-line1[2]/line1[0];
             y=-line2[2]/line2[1];
            if(x%1==0&&y%1==0){//정수라면
            list.add(new int[]{(int)x,(int)y});
            System.out.println("x"+x+"y"+y+"2222");
            max_x=Math.max((int)x,max_x);
            max_y=Math.max((int)y,max_y);
            min_x=Math.min((int)x,min_x);
            min_y=Math.min((int)y,min_y);
        }
        }
        else if(line2[1]==0||line1[0]*line2[1]==line1[1]*line2[0]||line2[0]==0||line2[0]*line1[1]==line1[0]*line2[1]){}
        else{
         x= (-line1[2]+(line1[1]*line2[2])/(double)line2[1])*line2[1]/(line1[0]*line2[1]-line1[1]*line2[0]);
         y= (-line1[2]+(line1[0]*line2[2])/(double)line2[0])*line2[0]/(line2[0]*line1[1]-line1[0]*line2[1]);
            if(x%1==0&&y%1==0){//정수라면
            list.add(new int[]{(int)x,(int)y});
            System.out.println("x"+x+"y"+y);
            max_x=Math.max((int)x,max_x);
            max_y=Math.max((int)y,max_y);
            min_x=Math.min((int)x,min_x);
            min_y=Math.min((int)y,min_y);
                
        }
        }
        
        
    }
    static List<int[]> list;
    static int[] select; 
    static int[][] line;
    static int max_x,min_x,max_y,min_y;
}
