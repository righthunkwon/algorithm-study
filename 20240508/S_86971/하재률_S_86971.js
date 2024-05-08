function solution(n, wires) {
    var answer = Infinity;
    // n+1개의 노드를 만들기
    const map = Array.from({length: n+1}, () => []);
    
    for(const [a, b] of wires){
        map[a].push(b);
        map[b].push(a);
    }
    
    // bfs함수
    const bfs = (st, x) => {
        let cnt = 0;
        let queue = [st];
        let chk = Array.from({length: n+1}, () => false);
        
        chk[st] = true;
        
        while(queue.length) {
            let poll = queue.shift(); // pop()은 마지막 인덱스, shift()는 처음 인덱스
            // 꺼낸 노드에 연결된 노드들 중
            map[poll].forEach((e)=>{
                // 제외한 노드 아니고, 방문 X
                if(e !== x && chk[e] === false){
                    chk[e] = true; // 방문
                    queue.push(e); // 큐에 담기
                }
            });
            cnt++;
        }
        return cnt;
    }
    
    // 하나씩 끊으면서 차이 절대값 가장 작은걸 찾기~
    wires.forEach((e) => {
        let [a, b] = e;
        answer = Math.min(answer, Math.abs(bfs(a, b) - bfs(b, a)));
    })
    
    return answer;
}
