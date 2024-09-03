class Solution {
    static int [] answer;
    static int diceNum;
    static List<int[]> aCombinations = new ArrayList<>(); //a주사위 조합 리스트
    static List<int[]> bCombinations = new ArrayList<>(); //b주사위 조합 리스트
    public int[] solution(int[][] dice) {
        diceNum=dice.length;//주사위 수
        answer = new int[diceNum/2];
        
        //A의 주사위 조합을 구하면, 나머지는 자동으로 B주사위 조합이 됨
        //각각의 주사위 조합으로 만들 수 있는 모든 점수를 배열로 만듬
        //배열 크기는 6^(diceNum/2)
        //각 경우의 승리 횟수를 구해 승리 횟수가 커지면 답 갱신..
        
        return answer;
    }
    
    //이긴 횟수 카운트용 메서드
    public int winCount(int[] score1, int[] score2) {
        int cnt = 0;
        for(int i=0; i<score1.length; i++) {
            for(int j=0; j<score2.length; j++) {
                if(score1[i] > score2[j]) {
                    cnt++;
                } else break;
            }
        }
        return winCount;
    }
    
    
    
}
