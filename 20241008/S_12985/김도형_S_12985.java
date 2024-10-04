class Solution{
    public int solution(int n, int a, int b){
        int answer = 1; //1라운드로 초기화
        while(true){
            if(a%2==1)a++; //홀수->짝수로 통일(해당 라운드 조) ex)8강이면 2조,4조,6조,8조 존재
            if(b%2==1)b++;
            if(a==b)break; //같은 조면 루프 끝내기
            answer++; 
            a/=2; //ex) 2조,4조 였으면 -> 2조가 되고 6조,8조 였으면 4조가 됨
            b/=2;
        }
        return answer;
    }
}
