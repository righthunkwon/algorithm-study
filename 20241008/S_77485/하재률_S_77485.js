function solution(rows, columns, queries) {
    var answer = [];
    const map = Array.from(Array(rows), (_, i) => Array.from(Array(columns), (_, j) => i * columns + j + 1))
    // console.log(map)
    
    queries.forEach((q => {
        const [x, y, xx, yy] = q.map(v => v-1);
        const stack = [];
        
        for(let i = y; i < yy; i++) stack.push(map[x][i]); // 위
        for(let i = x; i < xx; i++) stack.push(map[i][yy]); // 오른
        for(let i = yy; i > y; i--) stack.push(map[xx][i]); // 아래
        for(let i = xx; i > x; i--) stack.push(map[i][y]); // 왼
        
        // console.log(stack)
        // 가장 작은 수
        answer.push(Math.min(...stack));
        // 맨 뒤에거 빼서 앞으로 넣어주기
        stack.unshift(stack.pop());
        
        // 돌린거 채우기
        for(let i = y; i < yy; i++) map[x][i] = stack.shift(); // 위
        for(let i = x; i < xx; i++) map[i][yy] = stack.shift(); // 오른
        for(let i = yy; i > y; i--) map[xx][i] = stack.shift(); // 아래
        for(let i = xx; i > x; i--) map[i][y] = stack.shift(); // 왼
        
    }))
    
    return answer;
}
