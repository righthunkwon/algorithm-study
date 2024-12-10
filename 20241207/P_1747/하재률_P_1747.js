const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1747/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const isP = (num) => {
    const str = num.toString();
    return str === str.split('').reverse().join('');
}

const isPrime = (num) => {
    if(num < 2) return false;
    for(let i = 2; i * i <= num; i++)
        if(num % i === 0) return false;

    return true;
}

let n = Number(input[0]);

while(true) {
    if(isP(n) && isPrime(n)) {
        console.log(n);
        return;
    }
    n++;
}
