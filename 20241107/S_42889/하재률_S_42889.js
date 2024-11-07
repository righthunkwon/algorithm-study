function solution(N, stages) {
    // 실패율 저장 배열
    const fail = [];
    // 플레이어 수
    let player = stages.length;
    
    for(let i = 1; i <= N; i++) {
        // 해당 스테이지 도달
        const failPlayer = stages.filter(s => s === i).length;
        // 실패율
        const rate = player === 0 ? 0 : failPlayer / player;
        // {stage: 스테이지, rate: 실패율}
        fail.push({ stage: i, rate: rate });
        // 스테이지 통과한 사람들 수
        player -= failPlayer;
    }
    
    // 실패율 기준 내림차순, 스테이지 기준 오름차순
    fail.sort((a, b) => b.rate - a.rate || a.stage - b.stage);
    // console.log(fail)
    

    return fail.map(v => v.stage);
}
