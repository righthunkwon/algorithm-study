import java.util.*;

class Solution {
    static List<List<Integer>> ar;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 각수를 모두 리스트에 추가한다음
        // 1부터 꼬리물기 시작하면서  count 배열에 +1씩 값 넣어줌
        count = new int[n+1];
        ar = new ArrayList<>(n+1);
        // 리스트 먼저 초기화
        for (int i = 0; i <= n; i++) {
            ar.add(new ArrayList<>());
        }
        // 리스트에 값 모두 추가
        for (int[] e : edge) {
            ar.get(e[0]).add(e[1]);
            ar.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        count[1] = 0;  // 시작 count는 0부터
        int max = 0; // 최대값 갱신할 값
        
        while (true) {
            // 이제 큐에서 하나씩 꺼내서
            // 그점에서 연결된 점들을 하나씩 count배열 값 갱신
            // 그리고 큐에 추가하면서 꼬리물기
            if(q.size() ==0){
                break;
            }
            int number = q.poll();
            for (int tmp : ar.get(number)) {
                // 아직 수행하지 않은 것들만 
                // --> 수행했던것들은 최소값으로 갱신됬기때문에 할 필요 x
                if (count[tmp] == 0) {
                    count[tmp] = count[number] + 1;
                    max = Math.max(max, count[tmp]);
                    q.add(tmp);
                }
            }
        }
        // 2부터 제일먼것 발견하면 값 +1
        for (int i = 2; i <= n; i++) {
            if (count[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
