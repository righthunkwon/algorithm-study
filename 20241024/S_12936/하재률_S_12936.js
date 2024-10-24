function solution(n, k) {
    const ans = [];
    
    // 총 순열 개수 n!
    // 첫번째 자리 기준 남은걸로 (n-1)! 개씩
    // 첫번째 자리 : Math.floor(k / (n-1)!)
    // 다음 자리 : k % ((n-1)!) 번째 그룹?
    
    const num = Array.from(Array(n), (_, i) => i + 1);
    k--; // num 배열 인덱스로 할거니까
    let fac = num.reduce((a, b) => a * b, 1);
    
    for(let i = n; i > 0; i--) {
        fac /= i; // (n-1)!
        const idx = Math.floor(k / fac); // num의 몇 번째 숫자인지
        // console.log(num[idx], idx, fac)
        ans.push(num[idx]);
        num.splice(idx, 1); // 지우기
        k = k % fac;
    }
    
    return ans;
}

// 순열 다 구하면 시간초과 나넹
// function solution(n, k) {
//     const sol = (arr) => {
//         const res = [];
//         if(arr.length === 1) return [arr];
        
//         for(let i = 0; i < arr.length; i++) {
//             const cur = arr[i];
//             const remain = arr.slice(0, i).concat(arr.slice(i + 1));
//             const tmp = sol(remain);
//             for(let t of tmp) res.push([cur].concat(t));
//         }
        
//         return res;
//     }
    
//     const num = Array.from(Array(n), (_, i) => i + 1);
//     const ans = sol(num);
    
//     return ans[k-1];
// }
