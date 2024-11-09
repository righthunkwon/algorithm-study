class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 철수의 카드를 모두 나눌 수 있고 , 영희가 가진 카드들은 하나도 나눌 수 없는 수
        // 이거 또는 반대를 만족하는 수 a
        
        // 각자 수가 입력되었을 때 각 그룹을 나눌 수 있는 수를 찾자 -> 최대공약수
        // 우선 두개의 배열의 최대 공약수를 찾은 다음에
        // 그 수가 반대쪽에도 나눠지는지 확인
        int a = arrayA[0];
        int b = arrayB[0];
        for(int i = 1 ;i< arrayA.length;i++){
            a = dfs(a, arrayA[i]);
            b = dfs(b, arrayB[i]);
        }
        // 이렇게 하면 a와 b는 각각의 최대공약수이다.
        // 두개가 다른그룹에 나눠지는지 확인
        for(int i = 0 ;i<arrayA.length;i++){
            if(arrayA[i] % b == 0){
                break;
            }
            if(i == arrayA.length-1){
                answer = b;
            }
        }
        // 이제 a진행
         for(int i = 0 ;i<arrayB.length;i++){
            if(arrayB[i] % a == 0){
                break;
            }
            if(i == arrayB.length-1){
                answer = Math.max(answer,a);
            }
        }
        
        
        return answer;
    }
    public static int dfs(int a, int b){
        // a에서 b를 나눈 나머지가 0일 경우 b를 return하고
        // 아니면 b와 a%b로 계속 구하기
        if(a % b == 0){
            return b;
        }
        return dfs(b, a%b);
        
    }
}
