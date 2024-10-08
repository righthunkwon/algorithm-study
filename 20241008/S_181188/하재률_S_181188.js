function solution(targets) {
    var answer = 0;
    // 끝점을 기준으로 정렬
    targets.sort((a, b) => a[1] - b[1]);
    // console.log(targets)
    
    let end = -1;
    for(let [s, e] of targets) {
        if(s >= end) {
            answer++;
            end = e;
        }
    }
    return answer;
}
