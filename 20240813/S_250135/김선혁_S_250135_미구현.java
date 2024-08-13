class Solution {
    static class node{
        int h;
        int m;
        int s;
        
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        // 시간의 위치를 일자로 표현해서
        // 지나간다 생각
        // 일단 1분이 증가하면 무조건 2번 울림
        
        // 1분증가할때마다 분침은 +1, 시침은 1/60
        // 1분증가할때마다 분이랑 초는 분은 1/60 위치만큼 전진하고 1번씩 울림 , 시간은 (1/60)60 만큼 움직임 
        // 1시간이 증가하면 -> 분은 60번 울리고 , 60
        
        // 클래스 하나만들어서 각각 초로 변환한후 각도 판단
        
        
        
        
        return answer;
    }
}
