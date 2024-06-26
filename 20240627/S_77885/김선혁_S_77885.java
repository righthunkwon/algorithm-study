class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
         // 2진수로 전환해서 
        // 일단짝수는 맨뒷자리가 0이라
        // +1해준값 return
        for(int i = 0 ;i<numbers.length;i++){
             if(numbers[i] % 2 == 0){
                 answer[i] = numbers[i] +1;
                 continue;
             }   
            // 홀수는 맨뒷자리부터 잘라서 0만나면 그 숫자 1로 바꾼 숫자로 전환
            String line = "0" + Long.toBinaryString(numbers[i]);
            // 만약 다 1이면 앞에 1을 10으로 전환해야하니 미리 0붙임
            for(int j = line.length()-1;j>=0;j--){
                String tmp = line.substring(j,j+1);
                if(tmp.equals("0")){
                    // 0을 1로 교체하는데 가장 작은수가 필요하므로 0다음 수를 0으로 교체
                    String word = line.substring(0,j)+"10"+line.substring(j+2);
                    answer[i] = Long.parseLong(word,2);
                    break;
                }
                if(j == 0){
                    // i가 0이 된것은 0이 없는경우로 10으로 전환
                    answer[i] = Long.parseLong("10" + line.substring(2),2);
                }
            }   // i
            
        }
        return answer;
    }
}
