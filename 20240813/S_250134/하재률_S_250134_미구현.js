function solution(maze) {
    // 범위 밖, 방문체크, 같은 칸에 동시에, 스위칭 X, 도착칸에 도달했으면 움직임X
    
    const [n, m] = [maze.length, maze[0].length];
    const dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
    const chk = Array.from(Array(n), () =>
                   Array.from(Array(m), () => [false, false]));
    const end = { red: false, blue: false };
    
    let red = [0, 0], blue = [0, 0];
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(maze[i][j] === 1) red = [i, j];
            else if(maze[i][j] === 2) blue = [i, j];
        }
    }
    
    chk[red[0]][red[1]][0] = true;
    chk[blue[0]][blue[1]][1] = true;
    
    const dfs = (r, b, cnt) => {
        // 둘 다 도착
        if(end.red && end.blue) return cnt;
        
        let ans = Infinity;
        // console.log(r, b, cnt)
        
        // red blue 독립적인 4 * 4 경우의수 다 해봐야할듯
        for(let i = 0; i < 4; i++) {
            for(let j = 0; j < 4; j++) {
                const nRed = !end.red ? [r[0] + dx[i], r[1] + dy[i]] : r;
                const nBlue = !end.blue ? [b[0] + dx[j], b[1] + dy[j]] : b;
                
                // 범위 밖, 벽 continue
                if(nRed[0] < 0 || nRed[0] >= n || nRed[1] < 0 || nRed[1] >= m
                    || nBlue[0] < 0 || nBlue[0] >= n || nBlue[1] < 0 || nBlue[1] >= m
                    || maze[nRed[0]][nRed[1]] === 5 || maze[nBlue[0]][nBlue[1]] === 5)
                    continue;
                
                // 같은 칸 동시에
                if(nRed[0] === nBlue[0] && nRed[1] === nBlue[1]) continue;
                
                // 스위칭
                if((r[0] === nBlue[0] && r[1] === nBlue[1]) && 
                    (b[0] === nRed[0] && b[1] === nRed[1])) continue;
                
                // 방문체크
                if((!end.red && chk[nRed[0]][nRed[1]][0]) 
                   || (!end.blue && chk[nBlue[0]][nBlue[1]][1])) continue;
                
                chk[nRed[0]][nRed[1]][0] = true;
                chk[nBlue[0]][nBlue[1]][1] = true;
                
                const prevEnd = {...end};
                
                if(maze[nRed[0]][nRed[1]] === 3) end.red = true;
                if(maze[nBlue[0]][nBlue[1]] === 4) end.blue = true;
                
                ans = Math.min(ans, dfs(nRed, nBlue, cnt + 1));
                
                chk[nRed[0]][nRed[1]][0] = false;
                chk[nBlue[0]][nBlue[1]][1] = false;
                end.red = prevEnd.red;
                end.blue = prevEnd.blue;
            }
        }
        return ans;
    }
    
    const res = dfs(red, blue, 0);
    
    return res === Infinity ? 0 : res;
}
