const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_2015/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const [N, K] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

// sum[i]은 0 ~ i번째까지 누적합
// 특정 구간 i ~ j 의 누적합은 sum[j] - sum[i-1]
// sum[j] - sum[i-1] = K
// sum[i-1] = sum[j] - K

// 누적합
let sum = 0;
let cnt = 0;
const hashMap = new Map();
hashMap.set(0, 1);

for(let i = 0; i < N; i++) {
    sum += arr[i];

    if(hashMap.has(sum - K)) cnt += hashMap.get(sum - K);

    hashMap.set(sum, (hashMap.get(sum) || 0) + 1);
}

console.log(cnt)
