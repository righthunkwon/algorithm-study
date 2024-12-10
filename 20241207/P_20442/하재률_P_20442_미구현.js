const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_20442/input.txt';
const input = fs.readFileSync(filePath).toString().trim();

console.log(input);

const n = input.length;

// 왼쪽 누적 K
const leftK = Array(n).fill(0);
let cnt = 0;
for(let i = 0; i < n; i++) {
    if(input[i] === 'K') cnt++;
    leftK[i] = cnt;
}

// 오른쪽 누적 K
const rightK = Array(n).fill(0);
cnt = 0;
for(let i = n - 1; i >= 0; i--) {
    if(input[i] === 'K') cnt++;
    rightK[i] = cnt;
}

console.log(leftK, rightK)

let ans = 0;
let l = 0, r = 0;

// while(l < n) {

// }

console.log(ans)
