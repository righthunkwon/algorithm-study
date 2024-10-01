function solution(prices) {
    var answer = [];
    prices.forEach((v, idx) => {
        // 현재가격보다 비쌀때가 있나? 확인
        for(let i = idx + 1; i < prices.length; i++) {
            // 비쌀 때가 있으면 기록하고 다음
            if(v > prices[i]) {
                answer.push(i - idx);
                return;
            }
        }
        // 현재 가격보다 비싼게 없으면
        answer.push(prices.length - 1 - idx);
    })
    return answer;
}
