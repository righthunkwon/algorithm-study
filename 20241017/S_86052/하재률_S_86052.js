function solution(grid) {
    var answer = [];
    const dir = [[-1, 0], [0, -1], [1, 0], [0, 1]]; // 위왼아래오
    const [n, m] = [grid.length, grid[0].length];
    const chk = Array.from(Array(n), () => Array.from(Array(m), () => Array(4).fill(false)));
    
    const move = (x, y, d)  => {
        let cnt = 0;
        
        while(true) {
            // 이미 방문한 경우
            if(chk[x][y][d]) break;
            chk[x][y][d] = true;
            cnt++;
            
            // 이동
            x = (x + dir[d][0] + n) % n;
            y = (y + dir[d][1] + m) % m;
            
            // 방향 전환
            if(grid[x][y] === 'L') d = (d + 3) % 4; // 좌회전
            else if(grid[x][y] === 'R') d = (d + 1) % 4; // 우회전
        }
        
        return cnt;
    }
    
    const cycle = [];
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            for(let d = 0; d < 4; d++) {
                if(!chk[i][j][d]) cycle.push(move(i, j, d));
            }
        }
    }
    
    // console.log(cycle)
    
    return cycle.sort((a, b) => a - b);
}
