function solution(dice) {
    const n = dice.length;
    const comb = [];
    const tmp = [];
    
    // 주사위 조합 만들기
    const select = (idx) => {
        if(tmp.length === n / 2) {
            comb.push([...tmp]);
            return;
        }
        
        for(let i = idx + 1; i <= n; i++) {
            tmp.push(i);
            select(i);
            tmp.pop();
        }
    }
    
    select(0);
    
    // console.log(comb)
    
    // 고른 주사위 합 구하는 함수
    const sum = (sel) => {
        const res = [];
        const roll = (cnt, sum) => {
            if(cnt === sel.length) {
                res.push(sum);
                return;
            }
            const cur = dice[sel[cnt] - 1];
            for(let i = 0; i < 6; i++)
                roll(cnt + 1, sum + cur[i]);
        }
        
        roll(0, 0);
        
        return res;
    }
    
    // 이분탐색
    const sol = (arr, target) => {
        let l = 0;
        let r = arr.length;
        let res = -1;
        while(l <= r) {
            let mid = Math.floor((l + r) / 2);
            if(arr[mid] < target) {
                l = mid + 1;
                res = mid;
            } else r = mid - 1;
        }
        return res + 1;
    }
    
    // B의 합 정렬해서 A 승수 카운트
    const countWin = (sumA, sumB) => {
        sumB.sort((a, b) => a - b);
        let cnt = 0;
        for(let num of sumA) cnt += sol(sumB, num);

        return cnt;
    }
    
    const arr = Array.from(Array(n), (_, i) => i+1); // 전체 주사위
    let maxWin = -1;
    let maxIdx = -1;
    // 모든 주사위 조합 중에 승수만 판단
    for(let i = 0; i < comb.length; i++){
        const A = comb[i]; // A가 고른 주사위
        const set = new Set(A);
        const B = arr.filter(v => !set.has(v)); // 전체 주사위 - A 주사위

        const sumA = sum(A);
        const sumB = sum(B);
        
        const wins = countWin(sumA, sumB);
        
        if(wins > maxWin){
            maxWin = wins;
            maxIdx = i;
        }
    }
    
    return comb[maxIdx];
}
