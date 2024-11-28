const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1967/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);
// 임의의 노드에서 가장 먼 노드 -> 거기서 젤 먼 노드까지 거리 : 트리의 지름

const n = Number(input[0]); // 노드 수

// 노드 개수가 1개일때 예외처리
if(n === 1) {
    console.log(0);
    return;
}

// 트리 만들기
const tree = Array.from(Array(n+1), () => []);
for(let i = 1; i < input.length; i++) {
    const [p, c, w] = input[i].split(' ').map(Number);
    tree[p].push([c, w]);
    tree[c].push([p, w]);
}

const dfs = (node, chk) => {
    chk[node] = true;
    
    let tmp = node; // 가장 먼 노드
    let max = 0;

    for(const [next, we] of tree[node]) {
        if(!chk[next]) {
            const [tmpChild, dis] = dfs(next, chk);
            const total = dis + we;

            if(total > max) {
                max = total;
                tmp = tmpChild;
            }
        }
    }

    return [tmp, max];
}

const [start, _] = dfs(1, Array(n+1).fill(false));
const [__, res] = dfs(start, Array(n+1).fill(false));

console.log(res);
