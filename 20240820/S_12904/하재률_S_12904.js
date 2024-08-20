function solution(s) {
    let ans = 1;

    // 홀수개 팰린드롬 짝수개 팰린드롬...
    
    // 홀수
    for(let i = 1; i < s.length; i++) {
        let cnt = 1;
        let [l, r] = [i-1, i+1];
        while(l >= 0 && r < s.length) {
            if(s[l] === s[r]) {
                cnt += 2;
                l--;
                r++;
            } else break;
        }
        ans = ans > cnt ? ans : cnt;
    }
    
    // 짝수
    for(let i = 0; i < s.length - 1; i++) {
        let cnt = 0;
        let [l, r] = [i, i+1];
        while(l >= 0 && r < s.length) {
            if(s[l] === s[r]) {
                cnt += 2;
                l--;
                r++;
            } else break;
        }
        ans = ans > cnt ? ans : cnt;
    }
    
    return ans;
}
