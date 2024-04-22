class Solution {
    public String solution(String s) {
        String answer = "";      
        int min = Integer.MAX_VALUE;
        int max = -1 * Integer.MAX_VALUE;
        String arr[] = s.split(" ");
      // arr배열에 공백을 기준으로 입력받고
      // int로 바꿔줌
      for(int i = 0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            // 최소값 또는 최대값 갱신
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        answer = Integer.toString(min)+" "+Integer.toString(max);
        return answer;
    }
}
