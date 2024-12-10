const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_13251/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 조합 nCr = n! / (r! * (n-r)!) => 5C3 = (5 * 4 * 3) / (3 * 2 * 1)

// n개중에 r개 뽑는 경우의 수
const sol = (n, r) => {
    if(n < r) return 0;
    let res = 1;
    for(let i = 0; i < r; i++) {
        res *= (n - i);
        res /= (i + 1);
    }
    return res;
}

const M = Number(input[0]);
const stone = input[1].split(' ').map(Number);
const K = Number(input[2]);

// 전체 돌 개수
const num = stone.reduce((acc, cur) => acc + cur, 0);

let ans = 0;

// 모두 같은 색일 확률들 모두 더해주기
for(let i = 0; i < M; i++) {
    if(stone[i] >= K) {
        const color = sol(stone[i], K); // 특정 색에서 K개 뽑는 경우
        const total = sol(num, K); // 전체에서 K개 뽑는 경우
        ans += color / total;
    }
}

console.log(ans.toFixed(9));
