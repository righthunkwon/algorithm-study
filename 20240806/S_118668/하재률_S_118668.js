function solution(alp, cop, problems) {
    const maxAl = Math.max(...problems.map(p => p[0]));
    const maxCo = Math.max(...problems.map(p => p[1]));
    
    alp = alp >= maxAl ? maxAl : alp;
    cop = cop >= maxCo ? maxCo : cop;
    
    const dp = Array.from(Array(maxAl + 1), () => Array.from(Array(maxCo + 1), () => Infinity));
    dp[alp][cop] = 0;
    
    for(let i = alp; i <= maxAl; i++) {
        for(let j = cop; j <= maxCo; j++) {
            // 알고력 1 증가
            if(i + 1 <= maxAl) dp[i+1][j] = dp[i+1][j] <= dp[i][j] + 1 ? dp[i+1][j] : dp[i][j] + 1;
            // 코딩력 1 증가
            if(j + 1 <= maxCo) dp[i][j+1] = dp[i][j+1] <= dp[i][j] + 1 ? dp[i][j+1] : dp[i][j] + 1;
            
            // 각 문제
            for(const [areq, creq, arwd, crwd, cost] of problems) {
                if(i >= areq && j >= creq) {
                    const newAl = i + arwd <= maxAl ? i + arwd : maxAl;
                    const newCo = j + crwd <= maxCo ? j + crwd : maxCo;
                    dp[newAl][newCo] = dp[newAl][newCo] <= dp[i][j] + cost ? dp[newAl][newCo] : dp[i][j] + cost;
                }
            }
        }
    }
    
    // console.log(dp)
    
    return dp[maxAl][maxCo];
}


// 매번 sort로 재정렬 : O(M*N log N)
// 우선순위큐 구현 : O(M log M)
// 우선순위큐 구현... 3,4,10 시간초과
// class Pq {
//     constructor() {
//         this.q = [];
//     }
    
//     // 부모인덱스
//     getParentIdx(idx) {
//         return Math.floor((idx - 1) / 2);
//     }
    
//     // 왼자
//     getLeftChildIdx(idx) {
//         return 2 * idx + 1;
//     }
    
//     // 오자
//     getRightChildIdx(idx) {
//         return 2 * idx + 2;
//     }
    
//     // 스왑
//     swap(idx1, idx2) {
//         [this.q[idx1], this.q[idx2]] = [this.q[idx2], this.q[idx1]];
//     }
    
//     // 삽입
//     insert(e) {
//         this.q.push(e);
//         this.qUp();
//     }
    
//     // 위로올리기
//     qUp() {
//         let idx = this.q.length - 1;
//         while(idx > 0) {
//             const parentIdx = this.getParentIdx(idx);
//             if(this.q[parentIdx][0] > this.q[idx][0]) {
//                 this.swap(parentIdx, idx);
//                 idx = parentIdx;
//             } else break;
//         }
//     }
    
//     // 최소값 뽑기
//     getMin() {
//         if(this.q.length === 0) return null;
//         if(this.q.length === 1) return this.q.pop();
//         const min = this.q[0];
//         this.q[0] = this.q.pop();
//         this.qDown();
//         return min;
//     }
    
//     // 아래로 내리기
//     qDown() {
//         let idx = 0;
//         while(this.getLeftChildIdx(idx) < this.q.length) {
//             let smallerChildIdx = this.getLeftChildIdx(idx);
//             const rightChildIdx = this.getRightChildIdx(idx);
//             if(rightChildIdx < this.q.length && this.q[rightChildIdx][0] < this.q[smallerChildIdx][0]) smallerChildIdx = rightChildIdx;
//             if(this.q[idx][0] > this.q[smallerChildIdx][0]) {
//                 this.swap(idx, smallerChildIdx);
//                 idx = smallerChildIdx;
//             } else break;
//         }
//     }
    
//     isEmpty() {
//         return this.q.length === 0;
//     }
// }

// function solution(alp, cop, problems) {
//     const map = new Map();
//     const chk = new Set();
//     const pq = new Pq();
    
//     // 초기 상태 [알고력, 코딩력] : 비용
//     map.set([alp, cop].toString(), 0);
    
//     // 문제들의 비용과 요구 알고/코딩력, 보상 알고/코딩력 정리
//     problems = problems.map(e => 
//                     ({ cost: e[4], areq: e[0], creq: e[1], arwd: e[2], crwd: e[3]} ));
//     // 1의 비용으로 알고력 1 or 코딩력 1 증가 추가
//     problems.push({ cost: 1, areq: 0, creq: 0, arwd: 1, crwd: 0 });
//     problems.push({ cost: 1, areq: 0, creq: 0, arwd: 0, crwd: 1 })
//     // console.log(problems)
    
//     // 가장 높은 알고/코딩력 요구치
//     const maxAl = Math.max(...problems.map(p => p.areq));
//     const maxCo = Math.max(...problems.map(p => p.creq));
    
//     pq.insert([0, alp, cop]);
    
//     while(!pq.isEmpty()) {
//         const [x, al, co] = pq.getMin();
        
//         if(chk.has([al, co].toString())) continue;
//         else chk.add([al, co].toString());
        
//         for(const p of problems) {
//             const newAl = Math.min(al + p.arwd, maxAl);
//             const newCo = Math.min(co + p.crwd, maxCo);
//             const newX = x + p.cost;
            
//             const key = [newAl, newCo].toString();
            
//             if(al >= p.areq && co >= p.creq && (!map.get(key) || newX < map.get(key))) {
//                 map.set(key, newX);
//                 pq.insert([newX, newAl, newCo]);
//             }
//         }
        
//     }
    
//     // console.log(map)
//     return map.get([maxAl, maxCo].toString());
// }
