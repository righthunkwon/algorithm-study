import java.util.*;

class Solution {
    public String solution(String number, int k) {
       // dfs에 백트래킹 실패
        // 최대 숫자를 찾고 그숫자를 기준으로 뒤만보자
        
        // 전체길이에서 k뺀것가지 중 큰 수 찾기
        String ans = "";
        int index = 0;
        for(int i = 0; i < number.length() - k; i++) {
			int tmp = 0;
            // index번째부터 일단 가장 큰 수 찾아 tmp에 저장
			for(int j = index; j <= i + k; j++) {
                // tmp와 수 비교해서 교체
				if(tmp < Integer.parseInt(number.substring(j,j+1))) {
					tmp = Integer.parseInt(number.substring(j,j+1));
					index = j + 1;
				}
                if(tmp == 9) break; // 백트래킹
			}
            // 가장 큰 수 하나씩 저장 
			ans += Integer.toString(tmp);
		}
        return ans;
    }
    
}
