function solution(money) {
    // 첫집털기 dp1 마지막집털기 dp2
    const dp1 = [money[0], Math.max(money[0], money[1])];
    const dp2 = [0, money[1]];
    
    // 마지막-1까지 채우기
    for(let i = 2; i < money.length-1; i++) {
        dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
    }
    // 마지막집
    dp2[money.length-1] = Math.max(dp2[money.length - 3] + money[money.length - 1],dp2[money.length - 2])
    
    // console.log(dp1, dp2)
    
    return Math.max(dp1[money.length-2], dp2[money.length-1]);
}
