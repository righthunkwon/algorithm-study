class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        //각 무게 별 사람 수 입력
        int [] man = new int [4001];
        for(int i=0;i<weights.length;i++)man[weights[i]]++;

        for(int i=100;i<=1000;i++){
            if(man[i]==0)continue;
            if (man[i] > 1)answer +=  ((long)man[i] * (long)(man[i] - 1)) / 2; //같은 무게 2명 이상
            if (i % 3 == 0)answer +=  ((long)man[i] * (long)man[(i / 3) * 4]); //3의배수
            if (i % 2 == 0)answer +=  ((long)man[i] * (long)man[(i / 2) * 3]); //2의배수
            answer +=  ((long)man[i] * (long)man[i * 2]);
        }
        return answer;
    }
}
        //1. 무게 같은 사람이 2명 이상(n명)일 경우 -> 짝꿍 수는 n(n-1)/2 쌍
        //2. 시소 중심부터 거리 차이로 계산되는 짝꿍 (각각 n명, m명) -> n*m 쌍
        //무게가 x인 사람의 짝이 될 수 있는 경우의 수(자신 기준으로 더 무거운 짝 찾기)
        //무게가 3의 배수라면 (x/3)*4
        //무게가 2의 배수라면 (x/2)*3
        //모든 무게에 대해  x*2
