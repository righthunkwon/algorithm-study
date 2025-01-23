const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_14567/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// N: 과목 수, M: 선수조건의 수
const [N, M] = input[0].split(' ').map(Number);

// 그래프와 진입차수 배열
const graph = Array.from(Array(N + 1), () => []);
const arr = Array(N + 1).fill(0);

for(let i = 1; i <= M; i++) {
    const [A, B] = input[i].split(' ').map(Number);
    graph[A].push(B);
    arr[B]++;
}

// 진입차수 0이면 q에 넣기
const q = [];
const ans = Array(N + 1).fill(0);

for(let i = 1; i <= N; i++) {
    if(arr[i] === 0) {
        q.push(i);
        ans[i] = 1; // 선수 과목 없으면 1학기
    }
}

// 위상 정렬
while(q.length) {
    const cur = q.shift();

    for(const next of graph[cur]) {
        arr[next]--;
        if(arr[next] === 0) {
            q.push(next);
            ans[next] = ans[cur] + 1; // 선수 과목 다음 학기에 수강
        }
    }
}

console.log(ans.slice(1).join(' '));
