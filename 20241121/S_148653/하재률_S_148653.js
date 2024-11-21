function solution(storey) {
    var answer = 0;
    let tmp = 0;
    [...storey.toString()].reverse().forEach(((v, idx, arr) => {
        let cur = +v + tmp;
        if(cur > 5 || cur === 5 && +arr[idx+1] >= 5) {
            answer += 10 - cur;
            tmp = 1;
        } else {
            answer += cur;
            tmp = 0;
        }
    }))
    
    if(tmp > 0) answer += tmp;
    
    return answer;
}
