const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_2531/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// N: 접시 수, d: 초밥 가지 수, k: 연속해서 먹는 초밥 수, c: 쿠폰 번호
const [N, d, k, c] = input[0].split(' ').map(Number);

const sushi = input.slice(1).map(Number); // 초밥
const arr = sushi.concat(sushi); // 회전 초밥(2개 이어붙이기)

let cnt = new Map();
let ans = 0;

// 처음 k개 설정
for(let i = 0; i < k; i++) cnt.set(arr[i], (cnt.get(arr[i]) || 0) + 1);
ans = cnt.size + (cnt.has(c) ? 0 : 1);

for(let i = 0; i < N; i++) {
    // 왼쪽 녀석 빼기
    const l = arr[i];
    cnt.set(l, cnt.get(l) - 1);
    if(cnt.get(l) === 0) cnt.delete(l);

    // 오른쪽녀석 더하기
    const r = arr[i + k];
    cnt.set(r, (cnt.get(r) || 0) + 1);

    // 초밥 가짓수 카운트
    ans = Math.max(ans, cnt.size + (cnt.has(c) ? 0 : 1));
}

console.log(ans)
