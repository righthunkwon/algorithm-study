class Solution {
    public int solution(int storey) {
        //일의 자리부터 올라가기
        int tot=0;
        while(true){
            int num=storey%10;
            int next=storey/10;
            if(num>5||(num==5&&next%10>=5)){//일의 자리가 5일 경우 다음 자리 수가 5이상이면 올림
                tot+=10-num;
                next+=1;
            }else{//다음 자리 수가 5보다 작으면 내림
                tot+=num;
            } 
            storey=next;
            if(storey<=0) break;
        }
        int answer = tot;
        return answer;
    }
}
