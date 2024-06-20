function solution(jobs) {
    const len = jobs.length;
    // 시작 시간 정렬
    jobs.sort(([a,],[b, ]) => a - b);
    // 대기열
    let wait = [];
    // 걸린 시간
    let answer = [];
    // 현재 시간
    let time = 0;
    
    // 작업이 남아있거나 대기 남아있으면
    while(jobs.length || wait.length) {
        // 시작시간이 현재 시간보다 작으면 대기열에 넣기
        while(jobs.length && jobs[0][0] <= time) {
            wait.push(jobs.shift()); // shift는 첫번째 요소 제거 후 반환
        }
        
        // 대기열에 들어간 게 없으면 시간만 늘리고 다시돌려
        if(!wait.length) {
            time++;
            continue;
        }
        // 대기열 작업시간 정렬
        wait.sort(([,a],[,b]) => a - b);
        
        // 대기열 있으면
        if(wait.length) {
            const [req, jobTime] = wait.shift();
            time += jobTime; // 작업 종료시간 구하기
            answer.push(time - req); // 요청부터 종료까지 걸린 시간 push
        }
    }
    
    // console.log(answer);
    // 소요 시간들 더해서 / 작업 수 ... 소수점 버리기
    return Math.floor(answer.reduce((acc, cur) => (acc + cur) , 0) / len);
}
