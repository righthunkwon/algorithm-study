import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
// 한번에 왼쪽 배열에 ++하고
        // 오른쪽 배열에서 시작해서 count하면서
        // 그 이전 left배열의 숫자랑 같다면 answer ++
         int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            hash.add(topping[i]);
            left[i] = hash.size();
        }
        // 좌측 배열에는 숫자 모두 입력 완료
        hash = new HashSet<>();
        
        for (int i = topping.length - 1; i >= 0; i--) {
            hash.add(topping[i]);
            right[i] = hash.size();
        }
        // 우측배열도 세팅 끝
        // 이제 left 배열과 right배열에서 같은지점 만나면 +1
       for (int i = 0; i < topping.length - 1; i++) {
            if (left[i] == right[i + 1]) {
                answer++;
            }
        }
    return answer;    
    
    
    
    }
}
