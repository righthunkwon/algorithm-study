// 풀다가 다른코드 보고품..

import java.util.*;

class Solution {
    static int n;                 
    static int maxWin;            
    static int bestSelected;      
    static int[][] dice;
    public int[] solution(int[][] dice) {
        n = dice.length;          
        this.dice = dice;       
        // 주사위를 먼저 선택을 한 후에
        // 각 주사위의 조합대로 진행을 할경우
        // 몇번을 이기는지해서 최대값 구하기... 노가다
        maxWin = 0;               
        bestSelected = 0;         
        getDice(0, 0);            
        // 위의 주사위를 최적으로 수행했을 때 
        // 인덱스를 저장
        int[] answer = new int[n / 2]; 
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if((bestSelected & (1 << i)) > 0) {
                // 선택된 주사위 인덱스 저장
                answer[idx++] = i + 1;  
            }
        }

        return answer;  
    }

    // 주사위를 선택하는 메서드
    private static void getDice(int idx, int selected) {
        if(idx == n) {
            // 모든 주사위를 탐색한 경우
            if(Integer.bitCount(selected) == n / 2) {
                calculateWinRate(selected);
            }
            return;
        }
        // 현재 주사위를 선택하지 않은 경우
        getDice(idx + 1, selected);                 
        // 현재 주사위를 선택한 경우
        getDice(idx + 1, selected + (1 << idx));    
    }

    // 선택된 주사위 조합에 대한 승수 계산
    static Map<Integer, Integer> scoreA;  // A 그룹 주사위 점수 <점수, 개수>
    static Map<Integer, Integer> scoreB;  // B 그룹 주사위 점수 <점수, 개수>
    private static void calculateWinRate(int selected) {
        // 각 그룹의 점수를 저장할 맵 초기화
        scoreA = new HashMap<>();
        scoreB = new HashMap<>();
        rollDice(0, selected, new int[n / 2]);  // 선택된 주사위를 굴려서 점수 계산

        int win = 0;  // 현재 조합에서의 승수 계산
        for (Map.Entry<Integer, Integer> entryA : scoreA.entrySet()) {
            int keyA = entryA.getKey();
            int valueA = entryA.getValue();
            for(Map.Entry<Integer, Integer> entryB : scoreB.entrySet()) {
                int keyB = entryB.getKey();
                int valueB = entryB.getValue();
                if(keyA > keyB) {
                    win += valueA * valueB;  // A 그룹이 B 그룹을 이긴 경우 승수 추가
                }
            }
        }

        // 최대 승수 갱신 및 최적 선택 조합 저장
        if(maxWin < win) {
            maxWin = win;
            bestSelected = selected;
        }
    }

    // 주사위를 굴려서 나온 점수를 맵에 저장하는 메서드
    private static void rollDice(int idx, int selected, int[] rolledDice) {
        if(idx == n / 2) {
            // 주사위 A 그룹과 B 그룹으로 나누기
            int[] diceA = new int[n / 2];
            int[] diceB = new int[n / 2];
            int idxA = 0;
            int idxB = 0;
            for(int i = 0; i < n; i++) {
                if((selected & (1 << i)) > 0) {
                    diceA[idxA++] = i;  // 선택된 주사위는 A 그룹에 추가
                } else {
                    diceB[idxB++] = i;  // 선택되지 않은 주사위는 B 그룹에 추가
                }
            }

            int sumA = 0;  // A 그룹의 점수 합산
            int sumB = 0;  // B 그룹의 점수 합산
            for(int i = 0; i < n / 2; i++) {
                int num = rolledDice[i];
                sumA += dice[diceA[i]][num];
                sumB += dice[diceB[i]][num];
            }

            // A 그룹과 B 그룹의 점수를 맵에 저장
            scoreA.put(sumA, scoreA.getOrDefault(sumA, 0) + 1);
            scoreB.put(sumB, scoreB.getOrDefault(sumB, 0) + 1);
            return;
        }

        // 각 주사위에 대해 6개의 면을 굴려서 가능한 모든 경우의 수 탐색
        for(int i = 0; i < 6; i++) {
            rolledDice[idx] = i;  
            // 다음 주사위로 이동
            rollDice(idx + 1, selected, rolledDice);  
        }
    }
    
    
}
