class Solution {
    public int solution(int n, int[] tops) {
        //dp 못풀겠어서 블로그 도움을 ...
       // https://m.blog.naver.com/klaridoo/223343860460 참고
        int[] dp1=new int[n]; //겹치는 타일이 있게 끝나는 경우
        int[] dp2=new int[n]; //없게 끝나는 경우
        
        dp1[0]=1;
        dp2[0]=2+tops[0];
        
        for (int i=1; i<n; i++) {
            dp1[i] = (dp1[i-1] + dp2[i-1]) % 10007;
            dp2[i] = ((dp1[i-1] * (1+tops[i])) + 
                      (dp2[i-1] * (2+tops[i]))) % 10007;
        }
        
        return (dp1[n-1] + dp2[n-1]) % 10007;

    }
}
