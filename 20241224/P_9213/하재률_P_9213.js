const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_9213/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 약수의 합 미리 계산
const divSum = Array(1000001).fill(1); // 모든 수는 1을 약수로 가지니까
// 약수는 i
for(let i = 2; i <= 1000000/2; i++) {
    let tmp = i + i; // i의 배수 시작(자기 자신 제외)
    while(tmp <= 1000000) {
        divSum[tmp] += i; // tmp에 약수 i 더해주기
        tmp += i;
    }
}

input.forEach((v, idx) => {
    const [st, end, bad] = v.split(' ').map(Number);
    if(st === 0 && end === 0 && bad === 0) process.exit();

    let ans = 0;

    for(let i = st; i <= end; i++){
        if(Math.abs(i - divSum[i]) <= bad) ans++;
    }

    console.log(`Test ${idx+1}: ${ans}`)
})
