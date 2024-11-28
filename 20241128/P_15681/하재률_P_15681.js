const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_15681/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');
// console.log(input);

// n : 노드 수, r : 루트
const [n, r, _] = input[0].split(' ').map(Number);
const edges = input.slice(1, n); // 간선
const queries = input.slice(n).map(Number); // 쿼리

// 트리 만들기
const tree = Array.from(Array(n + 1), () => []);
edges.forEach((e => {
    const [u, v] = e.split(' ').map(Number);
    tree[u].push(v);
    tree[v].push(u);
}))

// 서브트리 크기
const sub = Array(n+1).fill(0);
const chk = Array(n+1).fill(false);

const dfs = (node) => {
    chk[node] = true;
    sub[node] = 1;

    for(const nn of tree[node]) {
        if(!chk[nn]) sub[node] += dfs(nn)
    }

    return sub[node];
}

dfs(r);

// console.log(sub);
const res = queries.map(q => sub[q]);

console.log(res.join('\n'))
