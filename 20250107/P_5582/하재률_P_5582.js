const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_5582/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const str1 = input[0];
const str2 = input[1];

const dp = Array.from(Array(str1.length + 1), () => Array(str2.length + 1).fill(0));
let ans = 0;

for(let i = 1; i <= str1.length; i++) {
    for(let j = 1; j <= str2.length; j++) {
        if(str1[i-1] === str2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
        ans = ans > dp[i][j] ? ans : dp[i][j];
    }
}

console.log(ans)
