const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_3933/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n').map(Number);

// console.log(input);

const Max = 2 ** 15;
const dp = Array.from(Array(5), () => Array(Max+1).fill(0));

dp[0][0] = 1;

for(let i = 1; i * i <= Max; i++) {
    const tmp = i * i;
    for(let j = 1; j <= 4; j++) { // j개의 제곱수 사용
        for(let k = tmp; k <= Max; k++) {
            dp[j][k] += dp[j - 1][k - tmp];
        }
    }
}

input.forEach(v => {
    if(v === 0) return;
    let ans = 0;
    for(let i = 1; i <= 4; i++) ans += dp[i][v];
    console.log(ans)
})
