import java.io.*;
import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
    
        double[]answer = new double[ranges.length];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);
        while(k!=1)
        {
            if(k%2==0)k /= 2;
            else{
                k=k*3+1;
            }
            list.add(k);
        }
        
        //넓이 저장
        double[] cal = new double[list.size()-1];
        
        for(int i=0; i<list.size()-1; i++)
        {
            cal[i] = (double)(list.get(i)+list.get(i+1))/2; //사다리꼴 넓이 공식
        }
        
         for(int i=0; i<ranges.length; i++)
        {
            double ans = 0;
            int st = ranges[i][0];
            int ed = list.size()+ranges[i][1]-1;
            
            if(st>ed)
            {
                answer[i] = -1;
            }
            else
            {
                for(int j=st; j<ed; j++)
                {
                    ans += cal[j];
                }
                answer[i] = ans;
            }
        }
        
        return answer;
    }
}
