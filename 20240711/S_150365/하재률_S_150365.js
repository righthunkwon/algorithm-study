function solution(n, m, x, y, r, c, k) {
    
    const q = [[x-1, y-1, '']];
    const chk = Array.from(Array(n), () => 
                          Array.from(Array(m), () =>
                                    Array(k+1), () => false))
    chk[x-1][y-1][0] = true;
    // 사전순 .. d -> l -> r -> u
    const dir = ['d', 'l', 'r', 'u'];
    const dx = [1, 0, 0, -1], dy = [0, -1, 1, 0];
    
    while(q.length) {
        const [curX, curY, path] = q.shift();
        
        if(curX === r-1 && curY === c-1 && path.length === k) return path; 
        
        if(path.length === k) continue;
        
        for(let d = 0; d < 4; d++) {
            const nx = curX + dx[d];
            const ny = curY + dy[d];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m 
               || chk[nx][ny][path.length + 1]) continue;
            
            chk[nx][ny][path.length + 1] = true;
            q.push([nx, ny, path+dir[d]]);
        }
    }
    
    return 'impossible';
}
