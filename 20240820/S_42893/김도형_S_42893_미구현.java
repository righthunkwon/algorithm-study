class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;

      
        
        return answer;
        
    }
    
    class Page{
        int idx; //페이지 인덱스
        int basicScore; //기본점수
        int outLinkCnt; //외부 링크 수
        double ScoreToLinkedPage; //basicScore ÷ outLinkCnt 해당 웹페이지가 
        List<Integer> linkedIndex; //외부 링크 리스트
        double linkScore; //링크점수
        double matchingScore; //매칭점수 (기본점수+링크점수)

    }
}
