function solution(n) {
    const ans = Array.from(Array(n), () => Array(n).fill(0));
    
    // 오 아래 왼 위
    const dx = [0, 1, 0, -1];
    const dy = [1, 0, -1, 0];
    
    let x = 0;
    let y = 0;
    let dd = 0;
    let num = 1;
    
    while(num <= n * n) {
        ans[x][y] = num++;
        
        let nx = x + dx[dd];
        let ny = y + dy[dd];
        
        if(nx < 0 || nx >= n || ny < 0 || ny >= n || ans[nx][ny] !== 0) {
            dd = (dd + 1) % 4;
            nx = x + dx[dd];
            ny = y + dy[dd];
        }
        
        x = nx;
        y = ny;
    }
    
    return ans;
}
