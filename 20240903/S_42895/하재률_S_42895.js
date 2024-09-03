function solution(N, number) {
    // 더하기 빼기 곱하기 나누기 합치기
    const dfs = (cur, cnt) => {
        // 8보다 크면 -1 리턴
        if(cnt > 8) return -1;
        
        if(cur === number) return cnt;
        
        let res = Infinity;
        let tmp = N;
        for(let i = 1; i + cnt <= 8; i++) {
            const num = [
                dfs(cur + tmp, cnt + i),
                dfs(cur - tmp, cnt + i),
                dfs(cur * tmp, cnt + i),
                dfs(Math.floor(cur / tmp), cnt + 1)
            ];
            
            for(const n of num)
                if(n !== -1) res = Math.min(res, n);
            
            tmp = tmp * 10 + N;
        }
        
        return res === Infinity ? -1 : res;
    }
    
    return dfs(0, 0);
}
