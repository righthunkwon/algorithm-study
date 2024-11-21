class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0) {
            int t=storey%10;
            storey/=10;
            if(t<5) answer+=t;
            else if(t>5) { answer+=10-t; storey++;}
            else {
                if(storey%10<5) answer+=t;
                else { answer+=10-t; storey++;}
            }
        }
        return answer;
    }
}
