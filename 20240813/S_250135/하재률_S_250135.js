function solution(land) {
    const [n, m] = [land.length, land[0].length];
    
    const dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
    const oil = Array.from(Array(n), () => Array(m).fill(-1));
    const chk = Array.from(Array(n), () => Array(m).fill(false));
    let num = 0; // 오일번호
    const map = new Map(); // 오일번호붙이기 + 크기
    
    const bfs = (x, y, id) => {
        const q = [[x, y]];
        let tmp = 1;
        chk[x][y] = true;
        
        while(q.length) {
            const [a, b] = q.shift();
            // 오일번호 저장
            oil[a][b] = num;
            
            for(let d = 0; d < 4; d++) {
                const nx = a + dx[d];
                const ny = b + dy[d];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(chk[nx][ny] || !land[nx][ny]) continue;
                
                q.push([nx, ny]);
                chk[nx][ny] = true;
                tmp++;
            }    
        }
        return tmp;
    }
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(!land[i][j] || chk[i][j]) continue;
            const cnt = bfs(i, j, num);
            map.set(num, cnt);
            num++;
        }
    }
    
    // console.log(oil)
    // console.log(map)
    
    // 세로 한 줄씩 검사
    let ans = 0;
    for(let i = 0; i < m; i++) {
        let visited =[];
        let sum = 0;
        for(let j = 0; j < n; j++) {
            if(oil[j][i] >= 0 && !visited.includes(oil[j][i])) {
                const id = oil[j][i];
                visited.push(id);
                sum += map.get(id);
            }
        }
        ans = ans < sum ? sum : ans;
    }
    
    return ans;
}
