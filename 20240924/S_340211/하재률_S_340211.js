function solution(diffs, times, limit) {
    // 이분탐색 문제
    const isPossible = (level) => {
        // diffs[0]은 1 고정이니까 무조건 푼다
        let time = times[0];
        for(let i = 1; i < diffs.length; i++) {
            // 레벨이 난이도에 못미치면 전에거 풀고
            if(level < diffs[i]) time += (diffs[i] - level) * (times[i-1] + times[i]);
            // 이번문제 풀기
            time += times[i];
        }
        // 다 풀 수 있으면 true 뱉기
        return time <= limit;
    }
    
    // diffs[0]은 1
    let l = 1;
    let r = limit;
    
    // 이분탐색
    while(l < r) {
        let mid = Math.floor((l + r) / 2);
        
        // 풀 수 있으면 오른쪽 당기기
        if(isPossible(mid)) r = mid;
        // 못 풀면 왼쪽 당기기
        else l = mid + 1;
    }
    
    return l;
}
