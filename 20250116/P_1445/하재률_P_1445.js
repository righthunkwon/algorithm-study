const fs = require('fs');
const { start } = require('repl');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1445/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map(v => v.split(''));

const dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];

// 쓰레기비용 1, 쓰레기 옆 비용 2로 설정
const cost = Array.from(Array(N), () => Array(M).fill(0));
for(let i = 0; i < N; i++) {
    for(let j = 0; j < M; j++) {
        if(map[i][j] === 'g') {
            cost[i][j] = 1;
            for(const [dx, dy] of dir) {
                const nx = i + dx;
                const ny = j + dy;
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] === '.')
                    cost[nx][ny] = 2;
            }
        }
    }
}

const sol = (startX, startY, endX, endY) => {
    const dist = Array.from(Array(N), () => Array.from(Array(M), () => [Infinity, Infinity]));
    const pq = [[0, 0, startX, startY]];
    dist[startX][startY] = 0;

    while(pq.length) {
        // 우선순위 큐처럼.. 정렬
        pq.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

        const [cost1, cost2, x, y] = pq.shift();

        // 도착
        if(x === endX && y === endY) return [cost1, cost2];

        for(const [dx, dy] of dir) {
            const nx = x + dx;
            const ny = y + dy;
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                const addCost1 = cost[nx][ny] === 1 ? 1 : 0;
                const addCost2 = cost[nx][ny] === 2 ? 1 : 0;
                const newCost1 = cost1 + addCost1;
                const newCost2 = cost2 + addCost2;
                if(newCost1 < dist[nx][ny][0] || 
                    (newCost1 === dist[nx][ny][0] && newCost2 < dist[nx][ny][1])
                ) {
                    dist[nx][ny] = [newCost1, newCost2];
                    pq.push([newCost1, newCost2, nx, ny]);
                }
            }
        }
    }

    return [-1, -1];
}

let startX, startY, endX, endY;
for(let i = 0; i < N; i++) {
    for(let j = 0; j < M; j++) {
        if(map[i][j] === 'S') {
            startX = i;
            startY = j;
        } else if(map[i][j] === 'F') {
            endX = i;
            endY = j;
        }
    }
}

const [cost1, cost2] = sol(startX, startY, endX, endY);
console.log(`${cost1} ${cost2}`);
