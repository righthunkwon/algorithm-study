class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            String bi= "0"+Long.toBinaryString(numbers[i]);
            if(numbers[i]%2==1){//홀수
               for(int j=bi.length()-1;j>=0;j--){
                   if(bi.charAt(j)=='0'){       
                       bi=bi.substring(0,j)+"10"+bi.substring(j+2);
                       break;
                   }
               }  
            }else{//짝수
              bi=bi.substring(0,bi.length()-1)+"1";  
            }
            answer[i]=Long.parseLong(bi,2);
        }
        return answer;
    }
} 
