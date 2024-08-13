https://bellog.tistory.com/241 보고 품..

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int stSec = h1*3600+m1*60+s1;
        int edSec = h2*3600+m2*60+s2;
        
        int answer = count(edSec)-count(stSec);
        
        //시작 시점에 시침이나 분침과 겹칠 경우 1번 더해줌
        if(stSec*59%3600==0 || stSec*719%43200==0)answer+=1;
        
        return answer;
    }
    
     private int count(int s) {
        int mAlram = s * 59 / 3600; //s초 동안 분침 초침 겹치는 횟수
        int hAlram = s * 719 / 43200; //s초 동안 시침 초침 겹치는 횟수
         
        //0시 12시에는 시침 분침 초침 다 겹치니까 빼줘야함
        int mhAlram = 43200 <= s ? 2 : 1;
        
        return mAlram + hAlram - mhAlram;
    }
    
}
