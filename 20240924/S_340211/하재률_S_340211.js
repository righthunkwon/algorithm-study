function solution(points, routes) {
    var answer = 0;
    // 최단 거리
    // 세로 -> 가로
    // 경로 저장해서 2개이상 같으면 충돌+
    
    const memo = [];
    
    // 현재 위치, 타겟 위치 넣으면 다음 좌표 뱉어라
    const getPosition = (r, c, targetR, targetC) => {
        if(r !== targetR) return r < targetR ? [r+1, c] : [r-1, c];
        if(c !== targetC) return c < targetC ? [r, c+1] : [r, c-1];
        return [r, c];
    }
    
    // 로봇 경로 순회
    routes.forEach((route, robotIdx) => {
        // 출발점
        let [curR, curC] = points[route[0] - 1];
        
        // 로봇 경로 저장용
        memo[robotIdx] = [[curR, curC]];
        
        route.slice(1).forEach(targetIdx => {
            const [targetR, targetC] = points[targetIdx - 1];
            
            while(curR !== targetR || curC !== targetC) {
                [curR, curC] = getPosition(curR, curC, targetR, targetC);
                memo[robotIdx].push([curR, curC]);
            }
        })
    })
    // console.log(memo)
    
    const max = Math.max(...memo.map(p => p.length));
    for(let i = 0; i < max; i++) {
        const map = new Map();
        
        for(let j = 0; j < routes.length; j++) {
            // 해당 시간대에 로봇 경로가 존재하면
            if(memo[j][i]) {
                const [r, c] = memo[j][i];
                const key = `${r}, ${c}`;
                
                map.set(key, (map.get(key) || 0) + 1);
            } 
        }
        
        // console.log(i+'초', map)
        map.forEach(cnt => {
            if(cnt > 1) answer++;
        })
    }
    
    
    return answer;
}
