class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        // 각각 n명의 참가자들은 1부터 n까지 차레대로 배정받고 
        // 해당 번호에서 이기는 사람은 (해당번호+1)/2 번호로 이동하게 된다.
        
        // A번과 B번 참가자가 몇번째 라운드에서 만나는지 확인(이 두명은 무조건 이긴다)
        // 부전승이 없으므로 우선 현재 N을 기준으로 
        // 2로 나눴을때 두개가 다른 범위에 속해있다면 그때의 라운드를 그대로 출력
        // ex) n = 2의3승 , cnt =3 으로 놓고 // 8/2 = 4-> 4는 속하고 7은 안속함 --> 3그대로 return
        // -> 만약 2랑 3이라면 // cnt=3에서는 같이속하고 2에서는 4/2 =>2로 둘이 갈림
        int total = 0;// 2의 지수
        boolean flag = false;
        while(true){
            if(n == 1){
                break;
            }
            // 1이 될때까지 계속 2로나누면서 2의 몇 지수인지 파악하고
            // 중간에 만약 둘이 만나게 된다면 그때의 값을 먼저 answer에 넣어 놓는다.
            // 마지막에 total - answer이 정답이다.
            total ++;
            n /= 2;
            if(flag){
                continue;
            }
            int tmp1 = (a-1)/n;
            int tmp2 = (b-1)/n;
            if(tmp1 != tmp2){
                // 두개 다르면 끝
                flag = true;
                answer = total;
            }
            
        }
        
        System.out.println(answer + " "+total);
        

        return total + 1 - answer;
    }
}
