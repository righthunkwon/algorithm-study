class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        w2=w;
        //n 2억 한번에 돌아야함 
        //visited 만들어서 t처리 하고 안된 것들 채우면 시간초과,,
        for(int i=0;i<stations.length;i++){
           int cnt=0;
           if(i==0){
               cnt=stations[i]-w-1;
           }else{
               cnt=stations[i]-w-(stations[i-1]+w)-1;
           }          
           answer+=cal(cnt); 
        }
        
        //마지막 빈 곳 채우기는 따로 뺌
        int cnt=n-(stations[stations.length-1]+w);
        answer+=cal(cnt);
        return answer;
    }
    static int w2;
    public static int cal(int cnt){
        if(cnt<=0) return 0;
        if(cnt%(2*w2+1)==0) return cnt/(2*w2+1);
        else return cnt/(2*w2+1)+1; 
    }
}
