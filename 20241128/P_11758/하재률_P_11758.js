const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_11758/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// CCW 알고리즘..
// (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1) 양수면 반시계 음수면 시계

const tmp = input.map(v => v.split(' ').map(Number));
// console.log(tmp)

const [x1, y1] = tmp[0];
const [x2, y2] = tmp[1];
const [x3, y3] = tmp[2];

const ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);

if(ccw > 0) console.log(1); // 반시계
else if(ccw < 0) console.log(-1); // 시계
else console.log(0); // 일직선
