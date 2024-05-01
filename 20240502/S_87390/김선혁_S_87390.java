class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) ((right-left)+1)];
        
        // 2차원배열 만들면 시간초과 뜰듯
        
        // right - left사이만 생각해보자
        // left가 몇행에 속할지 생각? , 2는 2/3 = 0 , 2%3 = 2 // 5는 5/3 = 1, 5%3 = 2
        // 0,2 = 3(2+1) // 1,0 = 2(1+1) // 1,1 = 2(1+1)
        int index = 0 ;
        for(long i = left;i<=right;i++){
            // 몫과 나머지중 큰 값 +1을 return 하는듯
            long a = i/n;
            long b=  i%n;
            if(a>b){
                answer[index++] = (int)a+1; 
            }
            else{
                answer[index++] = (int)b+1;
            }
        }
        
        return answer;
        
        
    }
}
