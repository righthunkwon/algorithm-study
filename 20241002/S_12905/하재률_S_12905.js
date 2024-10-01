function solution(board)
{

    let answer = 0;
    const r = board.length;
    const c = board[0].length;
    
    // 가장 큰 정사각형 길이 저장
    let len = 0;
    
    // 첫번째 행, 첫번째 열 1인경우 처리해주기
    for(let i = 0; i < r; i++) len = Math.max(len, board[i][0]);
    for(let i = 0; i < c; i++) len = Math.max(len, board[0][i]);
    
    // (1, 1)부터 정사각형 되는지 확인
    for(let i = 1; i < r; i++) {
        for(let j = 1; j < c; j++) {
            if(board[i][j]) {
                // 왼쪽위, 위, 왼 모두 0이 아니면 정사각형이니 그때마다 길이저장
                let ul = board[i-1][j-1];
                let u = board[i-1][j];
                let l = board[i][j-1];
                if(ul && u && l) board[i][j] = Math.min(ul, u, l) + 1;
                
                len = Math.max(len, board[i][j]);
            }
        }
    }
    // console.log(board)
    
    return len  ** 2;
}
