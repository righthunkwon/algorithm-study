// 문제: 172927번 (광물 캐기)
// 등급: Level 2
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927
// [풀이]
// 곡괭이를 한 번 고르면 5개 부술 때까지 계속 사용
// 사용 할 수 있는 곡괭이의 갯수는 문제 초반에 지정
// 정지 조건 모든 광물 캐기 or 곡괭이 다 쓰기
// 완탐을 할 수 밖에 없는 문제라고 생각, picks가 3종류 이고 미네랄이 최대 50개라 곡괭이를 최대 10개 사용 가능
// => DFS시 3^10 =~ 5만 
// 2차 코드
class Solution {
    int answer;
    int[][] tool = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    int remainingTools; // 전체 남은 곡괭이 수를 추적

    public int solution(int[] picks, String[] minerals) {
        answer = 25 * 50 + 1;
        remainingTools = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                remainingTools--;
                DFS(picks, minerals, i, 0, 0);
                picks[i]++;
                remainingTools++;
            }
        }
        return answer;
    }

    public void DFS(int[] picks, String[] minerals, int pickIdx, int mineralIdx, int sum) {
        int cnt = 0;
        while (cnt < 5 && mineralIdx < minerals.length) {
            if (minerals[mineralIdx].equals("diamond")) {
                sum += tool[pickIdx][0];
            } else if (minerals[mineralIdx].equals("iron")) {
                sum += tool[pickIdx][1];
            } else {
                sum += tool[pickIdx][2];
            }
            cnt++;
            mineralIdx++;
        }
        if (remainingTools == 0 || mineralIdx == minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                remainingTools--;
                DFS(picks, minerals, i, mineralIdx, sum);
                picks[i]++;
                remainingTools++;
            }
        }
    }
}
// 1차 코드
class Solution {
    int answer;
    int[][] tool = {{1, 1, 1},{5, 1, 1},{25, 5, 1}};
    public int solution(int[] picks, String[] minerals) {
        answer = 25*50+1;
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                picks[i]--;
                DFS(picks, minerals, i, 0, 0);
                picks[i]++;
            }
        }
        return answer;
    }
    public void DFS(int[] picks, String[] minerals, int pickIdx, int mineralIdx, int sum){
        int cnt = 0;
        while(cnt < 5 && mineralIdx < minerals.length){
            if(minerals[mineralIdx].equals("diamond")){
                sum += tool[pickIdx][0];
            }else if(minerals[mineralIdx].equals("iron")){
                sum += tool[pickIdx][1];
            }else{
                sum += tool[pickIdx][2];
            }
            cnt++;
            mineralIdx++;
        }
        int tmp = 0;
        for(int el : picks){
            tmp += el;
        }
        if(tmp == 0 || mineralIdx == minerals.length){
            answer = Math.min(answer, sum);
        }
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                picks[i]--;
                DFS(picks, minerals, i, mineralIdx, sum);
                picks[i]++;
            }
        }
    }
}