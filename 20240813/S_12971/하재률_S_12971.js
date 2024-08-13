function solution(sticker) {
    const size = sticker.length;
    if(size === 1) return sticker[0];
    
    const dp1 = [sticker[0], Math.max(sticker[0], sticker[1])];
    const dp2 = [0, sticker[1]];
    
    for(let i = 2; i < size; i++) {
        dp1[i] = dp1[i-2] + sticker[i] >= dp1[i-1] ? dp1[i-2] + sticker[i] : dp1[i-1];
        dp2[i] = dp2[i-2] + sticker[i] >= dp2[i-1] ? dp2[i-2] + sticker[i] : dp2[i-1];
    }
    
    // console.log(dp1, dp2)

    return dp1[size-2] >= dp2[size-1] ? dp1[size-2] : dp2[size-1];
}
