const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_3107/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim();

// console.log(input);

// :: 를 기준으로 나눈다
const div = input.split('::');

const left = div[0] ? div[0].split(':') : [];
const right = div[1] ? div[1].split(':') : [];

// console.log(left)
// console.log(right)

// 생략된 0000 부분 개수 구하기
const zero = 8 - (left.length + right.length);

// 0000 붙이기
const arr = [
    ...left,
    ...Array(zero).fill('0000'),
    ...right,
]

// console.log(arr)

console.log(arr.map(v => v.padStart(4, '0')).join(':'));
