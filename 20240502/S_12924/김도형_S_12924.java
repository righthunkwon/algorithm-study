import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                
                if(sum > n){ //합이 n보다 커지면 그만
                    break;
                }else if(sum==n){ //합이 딱 n이면 정답+1
                    answer++;
                }
            }
        }   

        return answer;
    }
}
