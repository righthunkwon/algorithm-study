class Solution {
    public int[] solution(int e, int[] starts) {
        //숫자의 등장횟수 = 해당 숫자의 약수의 개수 -> 각 숫자의 약수 개수 미리 구해놓고
        //범위 내에 있는 수 중 약수 개수 가장 많은 것 리턴하기
        
        int[] answer = new int[starts.length];
        
        int[]cnt = new int[e+1]; //약수의 개수 저장하는 배열
        for(int i=1;i<=e;i++)cnt[i]++; //1은 모든 수의 약수
        for(int i=2;i<=e;i++){
            for(int j=1;i*j<=e;j++){
                cnt[i*j]++; //각 숫자의 배수에 해당하는 인덱스의 배열에 1씩 더해줌
            }
        }
        
        //뒤에서부터 순회하면서 i이상 e이하 수 중 가장 약수 개수 많은 숫자를 저장
        int maxIdx = e;
        int [] max = new int [e+1];
        for(int i=e;i>0;i--){
            if(cnt[i]>=cnt[maxIdx])maxIdx = i;
            //크거나 같을때 갱신해서 약수 가장 많은 수가 여러 개라면 그 중 가장 작은 수가 저장되게함
            max[i]=maxIdx;
        }
        
        for(int i=0;i<starts.length;i++){
            answer[i]=max[starts[i]];
        }

        return answer;
        
    }
}
