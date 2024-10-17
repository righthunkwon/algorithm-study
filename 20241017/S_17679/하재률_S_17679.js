function solution(m, n, board) {
    board = board.map(v => v.split(''));
    
    while(true) {
        const tmp = [];
    
        // 2x2 찾아서 tmp에 넣기
        board.forEach((v, i) => {
            v.forEach((e, j) => {
                if(i < m - 1 && j < n - 1) {
                    const a = board[i][j];
                    const b = board[i][j+1];
                    const c = board[i+1][j];
                    const d = board[i+1][j+1];

                    if(a === b && b === c && c === d && a) {
                        // console.log(i + ', ' + j + ' 사각형 ' + board[i][j]);
                        tmp.push([i, j]);
                    }
                }
            })
        })
        
        if(!tmp.length) return board.flat().filter(v => !v).length;
        
        // 블럭 제거
        tmp.forEach(v => {
            const [x, y] = v;
            board[x][y] = 0;
            board[x][y+1] = 0;
            board[x+1][y] = 0;
            board[x+1][y+1] = 0;
        })
    
        // 아래로 내리기
        for(let i = m - 1; i > 0; i--) {
            if(board[i].every(v => v !== 0)) continue;
            
            for(let j = 0; j < n; j++) {
                for(let k = i - 1; k >= 0 && !board[i][j]; k--) {
                    if(board[k][j]) {
                        board[i][j] = board[k][j];
                        board[k][j] = 0;
                        break;
                    }
                }
            }
        }
    }
    
}
