import java.util.*;
class Solution {
    static ArrayList<Long> number;
    static ArrayList<String> oper;
    static String[] prior = new String[3]; // 우선순위대로 담을 배열
	static boolean[] visit = new boolean[3]; 
	static String[] operation = { "+", "-", "*"};
    static long max = 0;
    public long solution(String expression) {
        // 숫자는 따로 배열에 담고
        // 기호도 따로 배열에 담고
        // 기호 우선순위는 dfs 실행
        
        // 먼저 expression 분리
        String tmp = "";
        number = new ArrayList<Long>();
        oper = new ArrayList<String>();
        for(int i = 0 ; i<expression.length();i++){
            String cut = expression.substring(i,i+1);
            if(cut.equals("+") || cut.equals("-") || cut.equals("*")){
                // 여태까지 숫자 배열에 추가
                number.add(Long.parseLong(tmp));
                tmp = "";
                oper.add(cut);
                continue;
            }
            tmp += cut;
        }
        // 다 끝나면 숫자만 남아 이 숫자도 add
        number.add(Long.parseLong(tmp));
        // 이제 부호 우선순위 정하자
        dfs(0);
        return max;
    }
    // 부호의 우선순위 정하는 메서드
    public static void dfs(int cnt){
        if (cnt == 3) {
            // 우선순위 다 정했으면 계산
            // System.out.println(solve());
			max = Long.max(solve(), max);
			return;
		}
        // 하나 선택안했으면 선택하고
        // 되있으면 다음거로
		for (int i = 0; i < 3; i++) {
			if (visit[i]){
                continue;
            }
            // 부호 하나 우선순위 설정하고
            // 방문처리 후 다음 번째꺼 설정
			prior[cnt] = operation[i];
			visit[i] = true;
			dfs(cnt + 1);
			visit[i] = false;
		}
    }
    
    public static Long solve(){
        // 부호 우선순위 대로 계산 해보자
        ArrayList<Long> tmpn = (ArrayList<Long>) number.clone();
		ArrayList<String> tmpo = (ArrayList<String>) oper.clone();
        // 부호 하나 찾아서 식에서 계산하고 다음거 계산
        	for (String operate : prior) {
                // 찾을때 식에서 부호 인덱스 찾으면
                // 그 인덱스의 숫자와 +1 숫자 계산 -> 클론떠서 해야함
			for (int i = 0; i < tmpo.size(); i++) {
				if (tmpo.get(i).equals(operate)) {
                    // 부호 찾으면 계산
					long tmp = 0;
					if (operate.equals("*")){
                    	tmp = tmpn.get(i) * tmpn.get(i + 1);
                    }
					else if (operate.equals("+")){
						tmp = tmpn.get(i) + tmpn.get(i + 1);
                    }
					else if (operate.equals("-")){
						tmp = tmpn.get(i) - tmpn.get(i + 1);
                    }
                    // 그 두개 계산한거 tmp에 저장하고
                    // 숫자 두개 빼버리고 tmp 그 자리에 추가
                    tmpn.set(i,tmp);
                    tmpn.remove(i+1);
                    // 부호는 그냥 제거
                    tmpo.remove(i);
					i -=1; // 다시 그자리부터 부호 탐색
				}
			} // for i
		}
        // 이렇게 계산다하면 tmpn의 맨첫배열이 최종 숫자되어있음
        // 절댓값 return
        if(tmpn.get(0) <0){
            tmpn.set(0, tmpn.get(0)*(-1));
        }
		return tmpn.get(0);
    }
    
}
