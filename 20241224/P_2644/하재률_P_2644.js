const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_2644/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const n = +input[0]; // 사람 수 n
const [x, y] = input[1].split(' ').map(Number); // 촌수 계산해야하는 두 사람
const m = +input[2]; // 관계의 개수 m
const relation = input.slice(3).map(v => v.split(' ').map(Number));

const graph = Array.from(Array(n+1), () => []);
relation.forEach(([a, b]) => {
    graph[a].push(b);
    graph[b].push(a);
})

// console.log(graph)

const bfs = (start, target) => {
    const q = [[start, 0]]; // [현재노드, 촌수]
    const chk = Array(n+1).fill(false); // 방문쳌
    chk[start] = true;

    while(q.length) {
        const [cur, cnt] = q.shift();

        if(cur === target) return cnt;

        for(const next of graph[cur]) {
            if(!chk[next]) {
                chk[next] = true;
                q.push([next, cnt + 1]);
            }
        }
    }
    return -1;
}

console.log(bfs(x, y));
