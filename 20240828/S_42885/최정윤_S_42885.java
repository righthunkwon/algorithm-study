import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        //제일 큰 무게부터 작은 무게와 합하여 태우기
        int answer = 0;
        int idx=0; //아직 태우지 않은 제일 작은 idx
        for(int i=people.length-1;i>=idx;i--){
            //더했을 때 제한무게 체크
            if(people[i]+people[idx]<=limit) idx++;
            answer++;
        }
        return answer;
    }
}
