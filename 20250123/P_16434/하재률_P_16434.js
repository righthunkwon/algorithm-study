const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_16434/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const [N, ad] = input[0].split(' ').map(Number);
const room = input.slice(1).map(v => v.split(' ').map(Number));

const sol = (maxHp) => {
    let curHp = maxHp;
    let curAd = ad;

    for(const [t, a, h] of room) {
        if(t === 1) {
            // 몬스터방(용사 공격 -> 몬스터 공격)
            const turn = Math.ceil(h / curAd);
            curHp -= a * (turn - 1);

            if(curHp <= 0) return false;
            
        } else {
            // 포션방
            curAd += a;
            curHp = Math.min(maxHp, curHp + h);
        }
    }

    return true;
}

// 이분 탐색
let l = 1;
let r = 10 ** 12 * N;

while(l <= r) {
    const mid = Math.floor((l + r) / 2);
    if(sol(mid))  r = mid - 1;
    else l = mid + 1;
}

console.log(l)
