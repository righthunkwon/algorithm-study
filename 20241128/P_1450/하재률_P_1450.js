const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1450/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 모든 부분집합 개수 2^30 10억...
// 두 개로 나눠서 한쪽을 기준으로 다른 한 쪽 이분탐색

// N: 물건 수, C: 최대 무게
const [N, C] = input[0].split(' ').map(Number);
const weights = input[1].split(' ').map(Number);

// 부분 집합 합 계산
const sol = (arr) => {
    const res = [];
    const n = arr.length;

    const dfs = (idx, sum) => {
        if(idx === n) {
            res.push(sum);
            return;
        }

        dfs(idx + 1, sum);
        dfs(idx + 1, sum + arr[idx])
    }

    dfs(0, 0);

    return res;
}

const left = sol(weights.slice(0, Math.floor(N / 2)));
const right = sol(weights.slice(Math.floor(N / 2)));

// console.log(left, right);
right.sort((a, b) => a - b);

let ans = 0;

for(const l of left) {
    if(l > C) continue;

    let st = 0;
    let end = right.length;

    while(st < end) {
        const mid = Math.floor((st + end) / 2);
        if(right[mid] + l <= C) st = mid + 1;
        else end = mid;
    }

    ans += st;
}

console.log(ans)
