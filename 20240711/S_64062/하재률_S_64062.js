function solution(stones, k) {
    
    // 연속된 0 체크
    const chk0 = (mid) => {
        let cnt = 0;
        for(const n of stones) {
            if(n - mid <= 0) cnt++;
            else cnt = 0;
            if(cnt >= k) return false;
        }
        return true;
    }
    
    let l = 1, r = 200000000;
    
    while(l <= r) {
        const mid = Math.round((l+r)/2);
        if(!chk0(mid)) r = mid - 1;
        else l = mid + 1;
    }
    
    return l;
}
