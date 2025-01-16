const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_10836/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const [M, N] = input[0].split(' ').map(Number);
const info = input.slice(1).map(v => v.split(' ').map(Number));

// 벌집 초기화
const map = Array.from(Array(M), () => Array(M).fill(1));
// 성장치 초기화
const growth = Array(M + M - 1).fill(0);

// 왼쪽줄 위쪽줄 성장치 합 구하기
for(let i = 0; i < N; i++) {
    const cnt = info[i];
    let idx = 0;

    for(let j = 0; j < cnt[0]; j++) growth[idx++] += 0;
    for(let j = 0; j < cnt[1]; j++) growth[idx++] += 1;
    for(let j = 0; j < cnt[2]; j++) growth[idx++] += 2;
}

// 왼쪽줄 위쪽줄 성장시키기
let idx = 0;
for(let i = M - 1; i >= 0; i--) map[i][0] += growth[idx++];
for(let i = 1; i < M; i++) map[0][i] += growth[idx++];

// 나머지 왼/왼위/위 중 큰 값으로 성장시키기
for(let i = 1; i < M; i++) {
    for(let j = 1; j < M; j++) {
        map[i][j] = Math.max(map[i-1][j], map[i-1][j-1], map[i][j-1]);
    }
}

console.log(map.map(row => row.join(' ')).join('\n'));
