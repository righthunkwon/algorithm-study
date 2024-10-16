import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] elements) {
      
        HashSet<Integer> set = new HashSet<>();
        int N = elements.length;
        int [] elem = new int[N*2];
        
        //elements를 두개 이어 붙인 elem 수열 생성
        for(int i=0;i<N;i++){
            elem[i]=elements[i];
            elem[i+N]=elements[i];
        }

        //각 원소로부터 N개까지 더해가면서 set에 합을 추가
        for(int i=0;i<N;i++){
            int sum = elem[i];
            for(int j=1;j<=N;j++){
                set.add(sum);
                sum+=elem[i+j];
            }
        }
        
        return set.size();

    }
}
