function solution(n, edge) {
    var answer = 0;
    const graph = Array.from(Array(n + 1), () => []);
    edge.forEach(v => {
        graph[v[0]].push(v[1]);
        graph[v[1]].push(v[0]);
    });
    
    // 방문배열 + depth 체크
    const chk = Array.from(Array(n + 1), () => 0);
    
    const q = [1];
    chk[1] = 1;
    
    while(q.length) {
        const cur = q.shift();
        graph[cur].forEach(v => {
            if(!chk[v]) {
                chk[v] = chk[cur] + 1;
                q.push(v);
            };
        });
    };
    
    // console.log(chk);
    const max = Math.max(...chk);
    chk.forEach(e => {
        if(e === max) answer++;
    });
    
    return answer;
}
