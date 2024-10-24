function solution(arr) {
    let ans = 0;
    
    // 큰 거에서 작은 거 빼야하는디
    // 구간의 합?
    const n = Math.floor((arr.length + 1) / 2);
    const max = Array.from(Array(n), () => Array(n).fill(-Infinity));
    const min = Array.from(Array(n), () => Array(n).fill(Infinity));
    
    for(let i = 0; i < n; i++) {
        max[i][i] = parseInt(arr[i * 2]);
        min[i][i] = parseInt(arr[i * 2]);
    }
    
    for(let len = 1; len <= n; len++) {
        for(let i = 0; i < n; i++) {
            const j = i + len;
            for(let k = i; k < j; k++) {
                const operator = arr[i * 2 + 1];
                
                if(operator === '+') {
                    max[i][j] = Math.max(max[i][j], max[k][i] + max[j][i]);
                    min[i][j] = Math.max(max[i][j], max[k][i] + max[j][i]);
                }
            }
        }
    }
    
    console.log(max, min)
    
    return ans;
}

// function solution(arr) {
    
//     const sol = (arr, start, end) => {
//         // 숫자가 하나
//         if(start === end) return [parseInt(arr[start])];

//         let res = [];

//         // + - 기준으로 왼 오 나눠서
//         for(let i = start + 1; i < end; i += 2) {
//             const operator = arr[i];
        
//             // 왼쪽 오른쪽 계산
//             const left = sol(arr, start, i - 1);
//             const right = sol(arr, i + 1, end);

//             for(let l of left) {
//                 for(let r of right) {
//                     if (operator === '+') res.push(l + r);
//                     else if (operator === '-') res.push(l - r);
//                 }
//             }
//         }
//         return res;
//     }
    
//     const ans = sol(arr, 0, arr.length - 1);
//     return Math.max(...ans);
// }
