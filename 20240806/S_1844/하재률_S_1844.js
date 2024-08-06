function solution(maps) {
    let answer = Infinity;
    const dx = [1, -1, 0, 0], dy = [0, 0, 1, -1];
    const n = maps.length, m = maps[0].length;
    const chk = Array.from(Array(n), () => Array.from(Array(m), () => false))
    const q = [[0, 0, 1]];
    chk[0][0] = true;
    
    while(q.length) {
        const size = q.length;
        for(let i = 0; i < size; i++) {
            const [x, y, c] = q.shift();
            for(let d = 0; d < 4; d++) {
                const nx = x + dx[d];
                const ny = y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] === 0 || chk[nx][ny]) continue;
                q.push([nx, ny, c+1]);
                chk[nx][ny] = true;
                if(nx === n-1 && ny === m-1) answer = Math.min(answer, c+1);
            }            
        }
    }
    
    return answer === Infinity ? -1 : answer;
}
