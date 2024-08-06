import java.util.*;
import java.io.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        //같은 문제 여러번 풀 수 있음
        
        //모든 문제들을 풀 수 있는 알고력, 코딩력 "얻는" 최단시간 
        //-> 가장 어려운 알고,코딩 문제 풀 수 있어지면 끝내기
        
        //선택지
        //1. 알고 공부 (시간당 알고력1 증가)
        //2. 코딩 공부 (시간당 코딩력1 증가)
        //3. 문제하나 골라서 풀기 (problem[i][4]시간당 problem[i][2]알고력,problem[i][3]코딩력 증가 )
        
        //모든 문제의 난이도를 체크해서 필요한 가장 높은 알고력,코딩력을 체크
        int max_algo = alp; 
        int max_code = cop;
        
        for(int i=0;i<problems.length;i++){
            max_algo = Math.max(max_algo,problems[i][0]);
            max_code = Math.max(max_code,problems[i][1]);
        }
        
        if (alp >= max_algo && cop >= max_code) { //처음부터 다 풀 수 있었으면 0리턴
            return 0;
        }
        
        //dfs로 알고력 코딩력 늘어날때마다 체크..? -> 100^100.. 불가능할듯..
        
        //dp로 접근 -> dp[a][b] : 알고력 a, 코딩력 b 를 달성하기 위해 필요한 최소시간
        int[][]dp = new int[max_algo+2][max_code+2];
        
        //현재 alp나 cop이 max_algo나 max_code보다 클 수도 있으므로..
        //int[][] dp = new int[Math.max(alp, max_algo) + 2][Math.max(cop, max_code) + 2];
        
        //일단 큰값으로 다 채워두고 작은값으로 갱신
        for(int []a : dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        
        dp[alp][cop]=0; //현재 알고력,코딩력 달성하기 위한 시간 0필요
        
        for(int i=alp;i<=max_algo;i++){
            for(int j=cop;j<=max_code;j++){
                //알고력,코딩력 공부를 통해 1증가시킬 경우
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
                
                //해당 알고력,코딩력으로 풀 수 있는 문제를 풀었을 경우
                for(int[]problem : problems){
                    if(problem[0]<=i&&problem[1]<=j){
                        int nextAlgo = Math.min(i+problem[2],max_algo);
                        int nextCode = Math.min(j+problem[3],max_code);
                        dp[nextAlgo][nextCode]=Math.min(dp[nextAlgo][nextCode],dp[i][j]+problem[4]);
                        
                    }
                }
            }
        }
        
      
        return dp[max_algo][max_code];
    }
}
