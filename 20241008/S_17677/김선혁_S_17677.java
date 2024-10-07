import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 자카드 유사도
        // 집합 간의 유사도를 검사
        // 유사도는 double 형식으로 교집합개수/합집합개수 , 두개 모두 공집합일 때에는 1로 정의
        
        //알파벳만 소문자 대문자 주의해서 계산
        // 우선 앞에꺼는 다 ar1 hm1에 추가한다.
        // 그 다음 두번째 str에 있는거를 hm2에 값 1씩 다 더한다.
        // -> 교집합의 경우 두개에 모두 속해있는것들 중 최소값이고
        // -> 합집합은 hm1꺼를 hm2와 겹치는 부분 포함 전부 더하고, hm2에만 있는거 더하기
        
        // 주의해야할 것이 2글자씩 끊었을 때 a~z까지만 사용함!!!
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        // 우선 알파벳먼저 소문자로 바꿔줌
        str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
        for(int i = 0 ;i<str1.length()-1;i++){
            String tmp = str1.substring(i,i+2);
            // a~z는 char로 97~122까지
            if((int)tmp.charAt(0) >= 97 && (int) tmp.charAt(1) >= 97 && (int) tmp.charAt(0) <=122 && (int) tmp.charAt(1) <=122){
                // hm에 넣음 (기존 개수 +1로 넣음)
                hm1.put(tmp, hm1.getOrDefault(tmp, 0)+1);
            }

        }
        // 이과정을 거치면 str1에 있는 것들은 모두 완료
        // 이제 str2 진행
        for(int i = 0 ;i<str2.length()-1;i++){
            String tmp = str2.substring(i,i+2);
            if((int)tmp.charAt(0) >= 97 && (int)tmp.charAt(1) >= 97 && (int)tmp.charAt(0) <=122 && (int)tmp.charAt(1) <=122){
                int cnt = hm2.getOrDefault(tmp, 0);
                hm2.put(tmp, cnt + 1);
            }
        }
        
        int ans1 = 0;
        int ans2 = 0;        
        // 1. 우선 교집합의 경우는 hm1의 key가 2에서도 있을 때
        // 두개중의 최소값의 개수만 더함
        // 2. 합집합은 hm1과 hm2 동시에 있는거는 최대값 더하고, 각자 하나씩 더하면됨
        
        // 교집합 먼저
        for(String key : hm1.keySet()){
             if (hm2.containsKey(key)) {
                ans1 += Math.min(hm1.get(key), hm2.get(key));
            }
        }
        
        // 합집합 계산
        for (String key : hm1.keySet()) {
            ans2 += Math.max(hm1.get(key), hm2.getOrDefault(key, 0));
        }        
        // hm1꺼는 모두 더했고 hm2꺼 더하기
        for (String key : hm2.keySet()) {
            if (!hm1.containsKey(key)) {
                ans2 += hm2.get(key);
            }
        }
        
        // 두개모두 0이면 65536 출력
        if(ans1 == 0 && ans2 == 0){
            return 65536;
        }
        double ans = (double)ans1 / (double)ans2;
        answer = (int)(ans*(65536));
        System.out.println(ans1+" "+ ans2+" "+answer);
        
        return answer;
    }
    
}
