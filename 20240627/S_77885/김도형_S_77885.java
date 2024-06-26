class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i =0;i<numbers.length;i++){
            
            //짝수인 경우 : +1 하면 됨
            if(numbers[i]%2==0){
                answer[i]=numbers[i]+1;
                continue;
            }
            String bitNum = Long.toString(numbers[i],2);
            //홀수인 경우 
            
            //1. 비트가 1로만 이루어진 경우
            //맨앞 1 대신 10을 넣으면 답 
            // 011111-> 101111
            
            //2. 비트가 1과 0으로 이루어진 경우
            //맨 끝 자리수부터 앞으로 탐색하면서 0 찾으면
            //0을 1로 바꾸고 그 뒤에 있던 1을 0으로 바꾸면 됨
            //  101 -> 110
            //  10001 -> 10010
            //  10011 -> 10101
            if(!bitNum.contains("0")){
                int len = bitNum.length(); //1의 개수
                String tmp = "10";
                for(int j=0;j<len-1;j++){
                    tmp= tmp+"1";
                }
                answer[i]=Long.parseLong(tmp,2);
            }else{
                int len = bitNum.length();
                
                String[]arr = new String[len];
                boolean flag = false; //0찾았는지 여부
                for(int j=len-1;j>=0;j--){
                    if(!flag){
                        if(bitNum.charAt(j)=='0'){
                            flag=true;
                            arr[j]="1";
                            arr[j+1]="0";
                        }else{
                            arr[j]="1";
                        }
                    }else{
                        arr[j]=bitNum.charAt(j)+"";
                    }                       
                }
                
                //배열 다시 합쳐서 답으로 반환
                String tmp = "";
                for(int j=0;j<len;j++){
                    tmp=tmp+arr[j];
                }
                answer[i]=Long.parseLong(tmp,2);
    
            }          

        }
        
        return answer;
    }
}
