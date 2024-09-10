function solution(board, r, c) {
    const pairs = Array.from(Array(7), () => [null, null]);
    const cards = [];
    
    // 주어진 카드 위치 기록
    for(let i = 0; i < 4; i++) {
        for(let j = 0; j < 4; j++) {
            if(board[i][j]) {
                const [one, two] = pairs[board[i][j]];
                if(!one) {
                    pairs[board[i][j]][0] = [i, j];
                    cards.push(board[i][j]);
                } else pairs[board[i][j]][1] = [i, j];
            }
        }
    }

    const visited = Array.from(Array(cards.length), () => false);
    const cur = [];
    const minDist = [Infinity];
    
    const isValid = (x, y) => {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
    
    const bfs = (board, sx, sy, ex, ey) => {
        const dx = [1, -1, 0, 0], dy = [0, 0, -1, 1];
        const q = [[sx, sy]];
        const chk = Array.from(Array(4), () => Array.from(Array(4), () => false));
        
        chk[sx][sy] = true;
        
        let dist = 0;
        while(q.length) {
            const size = q.length;
            for(let i = 0; i < size; i++) {
                const [x, y] = q.shift();
                
                if(x === ex && y === ey) return dist;
                
                // 4방향 이동
                for(let k = 0; k < 4; k++) {
                    let nx = x + dx[k], ny = y + dy[k];
                    
                    
                    // 한 칸 이동
                    if(isValid(nx, ny) && !chk[nx][ny]) {
                        chk[nx][ny] = true;
                        q.push([nx, ny]);
                    }
                    
                    // ctrl 이동
                    while(isValid(nx, ny) && board[nx][ny] === 0) {
                        nx += dx[k];
                        ny += dy[k];
                    }
                    
                    // 경계 넘어간 경우 되돌리기
                    if(!isValid(nx, ny)) {
                        nx -= dx[k];
                        ny -= dy[k];
                    }
                    
                    if(!chk[nx][ny]) {
                        chk[nx][ny] = true;
                        q.push([nx, ny]);
                    }
                }
            }
            
            dist++;
        }
        
        return dist;
    }
    
    const sol = (board, cards, idx, r, c) => {
        if(idx === cards.length) return 0;
        
        const card = cards[idx];
        const [x1, y1] = pairs[card][0];
        const [x2, y2] = pairs[card][1];
        
        // 카드 쌍 선택하는 두가지 방법
        const d1 = bfs(board, r, c, x1, y1) + bfs(board, x1, y1, x2, y2);
        const d2 = bfs(board, r, c, x2, y2) + bfs(board, x2, y2, x1, y1);
        
        // 최소 이동 거리
        const dist = Math.min(d1, d2) + 2; // 카드 선택 이동 + 엔터 두 번
        board[x1][y1] = board[x2][y2] = 0; // 선택한 카드 제거
        
        // 다음 카드
        if(d1 < d2) return dist + sol(board, cards, idx + 1, x2, y2);
        else return dist + sol(board, cards, idx + 1, x1, y1);
    }
    
    // 모든 순열을 탐색
    const dfs = (depth, visited, cur, minDist) => {
        // 카드 선택하면 카드뒤집기
        if(depth === cards.length) {
            const tmp = board.map(r => [...r]);
            minDist[0] = Math.min(minDist[0], sol(tmp, cur, 0, r, c));
            return;
        }
        
        for(let i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cur.push(cards[i]);
                dfs(depth + 1, visited, cur, minDist);
                cur.pop();
                visited[i] = false;
            }
        }
    }
    
    dfs(0, visited, cur, minDist);
    
    return minDist[0];
}
