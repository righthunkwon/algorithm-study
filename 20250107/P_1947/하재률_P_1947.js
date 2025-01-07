const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1947/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 1명 => 0가지
// 2명 => A B 서로 교환 1가지
// n명 => 
    // A가 (n-1)명 중 한 명에게 선물을 주고, 나머지 사람끼리 정하는 방법: dp[n-1]
    // A가 (n-1)명 중 한 명과 선물을 교환하고, 나머지 사람끼리 정하는 방법: dp[n-2]

// dp[n] = (n-1) * (dp[n-1] + dp[n-2])

const n = +input[0];

const dp = Array(1_000_001).fill(0);

dp[2] = 1;

for(let i = 3; i <= n; i++)
    dp[i] = ((i - 1) * (dp[i-1] + dp[i-2])) % 1_000_000_000;

console.log(dp[n]);
