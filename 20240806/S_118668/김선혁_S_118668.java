class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        // dp로 푸는거구나..
        // 일단 al과 co의 최대점을 구해서(목표값)
        // al과 co부터 dp를 통해 
        
        int maxAlp = alp;
        int maxCop = cop;
        for(int i=0;i<problems.length;i++) {
			if(maxAlp < problems[i][0])
				maxAlp = problems[i][0];
			if(maxCop < problems[i][1])
				maxCop = problems[i][1];
		}
        // 최대값은 두개 모두 찾았고
        // 배열을 모두 maxvalue로 갱신먼저
		int[][] dp = new int[maxAlp + 1][maxCop + 1];
		for(int i=alp;i<=maxAlp;i++){
			for(int j=cop;j<=maxCop;j++){
				dp[i][j] = Integer.MAX_VALUE;
            }
        }   
                
		dp[alp][cop] = 0;
        // 시작점은 alp, cop부터
        // 먼저 한칸앞을 +1씩 갱신해놓고 시작
        for(int i=alp;i<=maxAlp;i++) {
			for(int j=cop;j<=maxCop;j++) {
				// 알고리즘 공부
				if(i + 1 <= maxAlp){
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
				// 코딩 공부
				if(j + 1 <= maxCop){
					dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

				// 풀수있는 문제가 나오면
                // 해당 문제를 풀었을 때의
                // 알고와 코딩 지점에 시간을 기록해서 최소값 갱신
				for(int k=0;k<problems.length;k++) {
					if(problems[k][0] <= i && problems[k][1] <= j) {
						int inAlp = problems[k][2];
						int inCop = problems[k][3];
						int h = problems[k][4];
						// 최대 범위를 넘은 경우 최대범위로 조정
						if(i + inAlp > maxAlp) 
							inAlp = maxAlp - i;
						if(j + inCop > maxCop)
							inCop = maxCop - j;

						dp[i + inAlp][j + inCop] = Math.min(dp[i + inAlp][j + inCop], dp[i][j] + h);
					}
				}
			}
		}
        
        return dp[maxAlp][maxCop];
    }
}
