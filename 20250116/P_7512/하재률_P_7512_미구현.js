const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_7512/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const lim = 10 ** 7;

// 에라토스테네스의 체
const isPrime = Array(lim + 1).fill(true);
isPrime[0] = isPrime[1] = false;
const primes = [];

for(let i = 2; i * i <= lim; i++) {
    if(!isPrime[i]) continue;
    primes.push(i);
    for(let j = i * i; j <= lim; j += i) isPrime[j] = false;
}

const sol = (sum, s, e) => {
    while(true) {
        if(e + 1 >= primes.length || s >= primes.length) throw new Error('왜 끝까지 돌지');

        sum += primes[e++ + 1] - primes[s++];

        if(isPrime[sum]) break;
    }

    return [sum, s, e];
}

const T = +input[0];
let idx = 1;

for(let t = 1; t <= T; t++) {
    console.log(`Scenario ${t}:`)
    const m = +input[idx];
    const nn = input[idx + 1].split(' ').map(Number);
    idx += 2;

    const res = [];

    for(const n of nn) {
        let sum = primes.slice(0, n).reduce((acc, cur) => acc + cur, 0);
        let s = 0;
        let e = n - 1;
        if(isPrime[sum]) res.push([sum, s, e]);
        else res.push(sol(sum, s, e));
    }

    while(true) {
        let flag = true;
        for(let i = 0; i < res.length - 1; i++) {
            if(res[i][0] !== res[i + 1][0]) {
                flag = false;
                const [sum, s, e] = res[i];
                res[i] = sol(sum, s, e);
                break;
            }
        }
        if(flag) {
            console.log(res[0][0]);
            break;
        }
    }

}
