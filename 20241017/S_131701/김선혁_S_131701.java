import java.util.*;

class Solution {
    static HashSet<Integer> hs = new HashSet<>();
    static int N;
    public int solution(int[] elements) {
        // 원형 수열의 연속하는 부분의 수열 합으로 만들 수 있는 수가 몇가지인지!!
        // 원형이라 끊기는 부분이 없다.
        
        // -> 첫번째 수부터 1~length까지의 숫자를 연속해서 더하는 과정 진행
        // 1번째숫자는 1, 2, 3, 4,5길이 순서대로 진행
        // 나머지 숫자도 똑같이 진행하는데 index의 경우가 length로 갈경우 중간에 0으로 초기화만 진행
        // 중복을 제거해야 하기 때문에 hashset에 넣어보자
        
        // 진행방식은 for문을 통해 0번째숫자부터 끝까지 진행
        N = elements.length;
        for(int i = 0 ; i < N;i++){
            solve(i, 1, elements[i], elements);
        }
        // 전부 진행했을 때 hs의 크기가 정답임
        return hs.size();
    }
    static void solve(int index, int cnt, int sum, int[] elements){
        // 이 메서드에서는 총 sum의 개수인 index가 N이랑 같을때까지 
        // 해당 숫자를 기준으로 다음 숫자 index로 진행
        hs.add(sum);
        if(cnt == N){
            return;
        }
        solve((index+1)%N , cnt+1, sum+elements[(index+1)%N], elements);
    }
    
}
