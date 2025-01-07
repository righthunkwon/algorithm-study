const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_11404/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const n = +input[0]; // 도시의 개수
const m = +input[1]; // 버스의 개수

// dp배열 초기화 및 자기자신 비용 0
const dp = Array.from(Array(n+1), () => Array(n+1).fill(Infinity));
for(let i = 1; i <= n; i++) dp[i][i] = 0;

for(let i = 2; i < m + 2; i++) {
    const [a, b, c] = input[i].split(' ').map(Number);
    dp[a][b] = Math.min(dp[a][b], c);
}

for(let k = 1; k <= n; k++) { // 경유지
    for(let i = 1; i <= n; i++) { // 출발지
        for(let j = 1; j <= n; j++) { // 도착지
            if(dp[i][k] !== Infinity && dp[k][j] !== Infinity)
                dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
    }
}

const ans = dp.slice(1).map(row => row.slice(1).map(v => v === Infinity ? 0 : v).join(' ')).join('\n');

console.log(ans)
