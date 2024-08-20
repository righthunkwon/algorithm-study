function solution(weights) {
    var answer = 0;
    
    // 2 3/2 4/3
    const tmp = [2, 3/2, 4/3];
    const cnt = {};
    weights.forEach((e) => {
        if(!cnt[e]) cnt[e] = 1;
        else cnt[e]++;
    })
    
    Object.values(cnt).forEach((e) => {
        if(e > 1) answer += (e * (e-1)) / 2;
    })
    weights.forEach((e) => {
        for(const t of tmp) {
            if(cnt[e * t] > 0) {
                answer += cnt[e*t];
                // console.log(e*t)
            }
        }
    })
    
    return answer;
}
