function solution(rectangle, characterX, characterY, itemX, itemY) {
    var answer = 0;
    // 길이 1로 패여있는부분 쭉 가버리는거 해결해야함... => 2배로 확장
    const size = 102;
    const map = Array.from(Array(size), () => Array(size).fill(0));
    
    rectangle.forEach(([x1, y1, x2, y2]) => {
        x1 *= 2; y1 *= 2; x2 *= 2; y2 *= 2;
        for(let i = x1; i <= x2; i++) {
            for(let j = y1; j <= y2; j++) {
                // 경계
                if(i === x1 || i === x2 || j === y1 || j === y2){
                    if(map[i][j] === 0) map[i][j] = 1;              
                }
                // 내부
                else map[i][j] = -1;
            }
        }
    })
    
    // bfs
    const q = [[characterX * 2, characterY * 2, 0]];
    const chk = Array.from(Array(size), () => Array(size).fill(false));
    chk[characterX * 2][characterY * 2] = true;
    
    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];
    
    while(q.length) {
        const [x, y, dis] = q.shift();
        
        // 도착
        if(x === itemX * 2 && y === itemY * 2) return dis / 2;
        
        // 네방향
        for(let d = 0; d < 4; d++) {
            const nx = x + dx[d];
            const ny = y + dy[d];
            
            if(nx >= 0 && nx < size && ny >= 0 && ny < size && !chk[nx][ny] && map[nx][ny] === 1) {
                chk[nx][ny] = true;
                q.push([nx, ny, dis + 1]);
            }
        }
    }
    return -1;
}
