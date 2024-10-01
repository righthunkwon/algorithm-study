function solution(a, b, g, s, w, t) {
    // 시간을 기준으로 이분탐색
    let l = 0;
    let r = 10 ** 16; // number 짱큰숫자
    let answer = r;
    
    // 운반 가능한지?
    const isPossible = (mid) => {
        // 총 자원량
        let gold = 0, silver = 0, total = 0;
        
        for(let i = 0; i < g.length; i++) {
            // mid시간 내에 움직일 수 있는 횟수
            // 왕복 몇 번 이동 가능한지
            let move = Math.floor(mid / (2 * t[i]));
            // 편도 이동 가능하면 +1
            if(Math.floor(mid / t[i]) % 2 === 1) move++;
            
            // 도시별 금, 은, 자원 계산
            let gg = Math.min(g[i], move * w[i]);
            let ss = Math.min(s[i], move * w[i]);
            let tt = Math.min(g[i] + s[i], move * w[i]);
            
            gold += gg;
            silver += ss;
            total += tt;
        }
        
        return total >= (a + b) && gold >= a && silver >= b;
    }
    
    // 이분 탐색
    while(l < r) {
        let mid = Math.floor((l + r) / 2);
        if(isPossible(mid)) {
            r = mid;
            answer = Math.min(answer, mid);
        } else l = mid + 1;
    }
    
    return answer;
}
