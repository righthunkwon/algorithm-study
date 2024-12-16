const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_2304/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const N = +input[0];

// x좌표순으로 높이 정렬
const heigth = input.slice(1).map(v => v.split(' ').map(Number));
heigth.sort((a, b) => a[0] - b[0]);

let topIdx = 0;
let topHeight = 0;

// 가장 높은 높이 찾기
for(let i = 0; i < N; i++) {
    if(heigth[i][1] > topHeight) {
        topHeight = heigth[i][1];
        topIdx = i;
    }
}

// 왼쪽 넓이 계산
let left = 0; // 넓이
let top = 0; // 가장 높은 녀석
for(let i = 0; i < topIdx; i++) {
    const width = heigth[i + 1][0] - heigth[i][0];
    top = Math.max(top, heigth[i][1]);
    left += width * top;
}

// 오른쪽 넓이 계산
let right = 0;
top = 0;
for(let i = N - 1; i > topIdx; i--) {
    const width = heigth[i][0] - heigth[i - 1][0];
    top = Math.max(top, heigth[i][1]);
    right += width * top;
}

// 총 넓이
console.log(left + topHeight + right);
