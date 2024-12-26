const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_17090/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const [n, m] = input[0].split(' ').map(Number);

const map = Array.from(Array(n), ()=> []);
input.slice(1).forEach((v, i) => {
    [...v].forEach(e => map[i].push(e))
})
// console.log(map)

// 방향
const dir = {
    U: [-1, 0],
    D: [1, 0],
    L: [0, -1],
    R: [0, 1]
};

const chk = Array.from(Array(n), () => Array(m).fill(false)); // 이 칸을 지나면 탈출이 가능하다 => 바로 true 리턴
const cycle = Array.from(Array(n), () => Array(m).fill(false)); // 사이클이 발생하면 탈출 불가능 => false 리턴
let ans = 0;

// 탈출 여부
const sol = (i, j) => {
    if(chk[i][j]) return true;
    if(cycle[i][j]) return false;

    cycle[i][j] = true;

    const [di, dj] = dir[map[i][j]];
    const ni = i + di;
    const nj = j + dj;

    // map 밖으로 나가면 탈출 성공
    if(ni < 0 || ni >= n || nj < 0 || nj >= m) {
        chk[i][j] = true;
        cycle[i][j] = false;
        return true;
    }

    // 다음 위치
    const next = sol(ni, nj);
    chk[i][j] = next;
    cycle[i][j] = false; // 아직은 사이클이 아니다

    return next;
}

for(let i = 0; i < n; i++) {
    for(let j = 0; j < m; j++) {
        if(sol(i, j)) ans++;
    }
}

console.log(ans)
