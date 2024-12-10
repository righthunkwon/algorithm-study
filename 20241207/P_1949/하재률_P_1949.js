const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1949/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 우수마을 주민 수는 최대
// 우수마을은 인접 X
// 일반마을은 적어도 하나의 우수마을과 인접해야한다

const n = Number(input[0]);
const arr = [0, ...input[1].split(' ').map(Number)];

const tree = Array.from(Array(n+1), () => []);
for(let i = 2; i < input.length; i++) {
    const [a, b] = input[i].split(' ').map(Number);
    tree[a].push(b);
    tree[b].push(a);
}

const dp = Array.from(Array(n+1), () => [0, 0]);
const chk = Array(n+1).fill(false);

const dfs = (node) => {
    chk[node] = true;
    dp[node][0] = 0;
    dp[node][1] = arr[node];

    for(const t of tree[node]) {
        if(chk[t]) continue;
        dfs(t);

        // 현재 노드 일반 마을
        dp[node][0] += Math.max(dp[t][0], dp[t][1]);
        // 현재 노드 우수마을
        dp[node][1] += dp[t][0];
    }
}

dfs(1);

console.log(Math.max(dp[1][0], dp[1][1]))
