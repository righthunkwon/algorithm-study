import java.util.*;

class Solution {
    public int solution(int[] a) {
        // 생각해보면 한번 작은 풍선을 터트릴 수 있다는 것은
        // 1. 양쪽 수가 나보다 크다 --> 기회 안써도 둘다 제거 가능 -> 가능
        // 2. 둘 중 하나의 수가 크다 --> 작은것은 기회, 큰것은 그냥 제거 -> 가능
        // 3. 양쪽 수가 나보다 작다 --> 하나만 제거하고 하나는 불가능 --> 불가능
        
        // 가능한 방법은 왼쪽수가 크거나 or 오른쪽수가 작아야함 
        // 하지만 중간에 터져서 작은숫자가 올 수 있기떄문에 
        // -> 나를 기준으로 왼쪽전체가 작거나 , 오른쪽 전체가 작아야함
        // 시간아끼기 위해 i를 기준으로 왼쪽 오른쪽 최솟값 기록하자
        
        // 어차피 끝수는 살아남기가능 
        int answer = 2;
        // a가 1개면 그냥 리턴
        if(a.length == 1){
            return 1;
        }
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];
      
        int tmp = Integer.MAX_VALUE; 
        for(int i = 0 ;i<a.length;i++){
            // 최솟값 갱신 
            if(a[i] < tmp){
                tmp = a[i];
            }
            // 현재까지의 최솟값 기록
            left[i] = tmp;
        }
        
        // 오른쪽도  똑같이
        tmp = Integer.MAX_VALUE;
        for(int i = a.length-1;i>=0;i--){
            if(a[i] < tmp){
                tmp = a[i];
            }
            right[i] = tmp;
        }
        
        // 이제 지나가면서 값이 현재위치까지 최솟값 둘중 하나라도 작으면
        // answer ++ 
        for(int i = 1 ;i<a.length-1;i++){
            // 값이 같다는 것은 내가 최소값이라 가능하다는 의미 !!!
            // System.out.println(a[i] +" "+left[i] +" "+right[i]);
            if(a[i] <= left[i] || a[i] <= right[i]){
                answer ++;
            }
        }
        
        return answer;
    }
}
