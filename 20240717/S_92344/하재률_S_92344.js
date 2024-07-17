function solution(board, skill) {
    let answer = 0;
    const x = board.length, y = board[0].length;
    const imos = Array.from(Array(x+1), () => Array(y+1).fill(0));
    
    /*
    imos법...
    
    0 0 0
    0 0 0
    0 0 0 과 같은 2차원 배열에 모두 n을 더하고 싶다면?
    
    임시 배열(row + 1 / col + 1 배열)을 만들어
    ***시작과 끝+1에 n과 -n을 기록***
    
    n  0 0 -n
    0  0 0  0
    0  0 0  0
    -n 0 0  n
    
    행 기준 누적합(가로로 쓸기) + 열 기준 누적합(세로로 쓸기)
    
    n n n 0
    n n n 0
    n n n 0
    0 0 0 0
    */
    
    // imos 배열 그리기
    skill.map(([type, x1, y1, x2, y2, deg]) => {
        const tmp = type === 1 ? -deg : deg;
        
        imos[x1][y1] += tmp;
        imos[x1][y2 + 1] -= tmp;
        imos[x2 + 1][y1] -= tmp;
        imos[x2 + 1][y2 + 1] += tmp;
    });

    // 행 기준 누적합
    imos.forEach(r => {
        // reduce(누적값, 현재값, 현재 인덱스, reduece 호출된 배열)
        r.reduce((acc, _, i, arr) => arr[i] += acc, 0);
    });
    
    // 열 기준 누적합
    for(let i = 0; i < y; i++) {
        let sum = 0;
        for(let j = 0;j < x; j++) {
            sum += imos[j][i];
            imos[j][i] = sum;
        }
    }
    
    // console.log(imos)
    
    return board.reduce((cnt, row, i) =>
            cnt + row.reduce((acc, _, j) =>
                acc + ((board[i][j] += imos[i][j]) > 0 ? 1 : 0), 0), 0);
}
