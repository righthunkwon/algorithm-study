function solution(n, info) {
    let answer = [-1];
    
    // 어피치 라이언 점수 비교
    const scoreCalc = (a, r) => {
        let sumA = 0, sumR = 0;
        for(let i = 0; i < r.length; i++) {
            // 둘다 0발
            if(a[i] === 0 && r[i] === 0) continue;
            if(a[i] > r[i]) sumA += 10 - i;
            else sumR += 10 - i;
        }
        return sumR - sumA;
    }
    
    // 라이언 화살 상태
    let ryan = Array.from(Array(info.length), () => 0);
    // 점수 차이 저장용
    let res = 0;
    
    const dfs = (cnt, rest) => {
        // 화살 다 떨어졌을때 점수계산
        if(cnt === info.length || rest === 0) {
            // 남은 화살 모두 0점
            ryan[10] += rest;
            
            let tmp = scoreCalc(info, ryan);
            if(tmp >= res) {
                res = tmp;
                answer = ryan.slice();
            }
            // 0점 추가했던 화살 제거
            ryan[10] -= rest;
            
            return;
        }
        
        // 어피치 이기기
        let arrow = info[cnt] + 1;
        // 남은 화살이 있을때 재귀돌리기
        if(rest >= arrow) {
            ryan[cnt] = arrow;
            dfs(cnt + 1, rest - arrow);
            ryan[cnt] = 0;
        }
        
        dfs(cnt + 1, rest);
    }
    
    dfs(0, n);
    
    return answer;
}
