const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1027/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 기울기 = y의 증가량 / x의 증가량 = (y2 - y1) / (x2 - x1)

const n = +input[0];
const arr = input[1].split(' ').map(Number);

let ans = 0;

for(let i = 0; i < n; i++) {
    let cnt = 0;

    // 왼쪽
    let left = Infinity;
    for(let j = i - 1; j >= 0; j--) {
        const tmp = (arr[j] - arr[i]) / (j - i);
        if(tmp < left) {
            left = tmp;
            cnt++;
        }
    }

    // 오른쪽
    let right = -Infinity;
    for(let j = i + 1; j < n; j++) {
         const tmp = (arr[j] - arr[i]) / (j - i);
         if(tmp > right) {
            right = tmp;
            cnt++;
         } 
    }

    ans = Math.max(ans, cnt);
}

console.log(ans)
