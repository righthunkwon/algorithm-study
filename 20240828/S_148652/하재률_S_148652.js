function solution(n, l, r) {
    var answer = 0;
    
    // f(0) = 1
    // f(1) = 11011 -> 1개수: 4^1개, 길이: 5^1 
    // f(2) = 11011 11011 00000 11011 11011 -> 1개수: 4^2, 길이: 5^2
    // f(3) = f(2) f(2) 0 25개 f(2) f(2)
    const F = [[1, 1]]; // [1개수, 길이]
    for(let i = 1; i <= n; i++) {
        const [a, b] = F[i-1];
        F[i] = [a*4, b*5];
    }
    
    // [1개수, 시작, 끝, 길이]
    const q = [[F[n][0], 1, F[n][1], n]];
    while(q.length) {
        const [cnt, left, right, depth] = q.shift();
        if(l <= left && right <= r) answer += cnt;
        else {
            if(depth===0)continue;
            const [a, b] = F[depth-1];
            // 5등분
            for(let i = 0; i < 5; i++) {
                const st = i * b + left;
                const end = (i+1) * b + left - 1;
                // 가운데 구간은 모두 0
                if(i === 2) continue;
                if(st > r || end < l) continue;
                q.push([a, st, end, depth-1]);
            }
        }
    }
    
    return answer;
}

// 이 풀이가 더 아름답다..
// function sol(n, l, r, st, en) {
//   if (r < st || l > en) return 0;
//   if (n == 0) return 1;

//   const len = Math.pow(5, n - 1);

//   return (
//     sol(n - 1, l, l + len - 1, st, en) + 
//     sol(n - 1, l + len, l + 2 * len - 1, st, en) +
//     sol(n - 1, l + 3 * len, l + 4 * len - 1, st, en) +
//     sol(n - 1, l + 4 * len, l + 5 * len - 1, st, en)
//   );
// }

// function solution(n, l, r) {
//   return sol(n, 0, Math.pow(5, n) - 1, l - 1, r - 1);
// }
