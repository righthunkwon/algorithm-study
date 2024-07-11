function solution(n, times) {
    let l = 1n;
    let r = BigInt(1e18);
    
    while(l <= r) {
        const mid = (l + r) / 2n;
        const cnt = times.reduce((acc, cur) => acc + mid / BigInt(cur), 0n);
        if(cnt < n) l = mid + 1n;
        else r = mid - 1n;
    }
    
    return l;
}
