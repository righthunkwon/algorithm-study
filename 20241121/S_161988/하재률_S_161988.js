function solution(sequence) {
    const p1 = sequence.map((v, i) => v * (i % 2 === 0 ? 1 : -1));
    const p2 = sequence.map((v, i) => v * (i % 2 !== 0 ? 1 : -1));
    
    const max = (arr) => {
        let cur = 0;
        let sum = Number.MIN_SAFE_INTEGER;
        
        for(const n of arr) {
            cur = Math.max(n, cur + n) // 현재값 vs 합
            sum = Math.max(sum, cur) // 최대값 갱신
        }
        
        return sum;
    }
    
    // console.log(p1, p2)
    
    return Math.max(max(p1), max(p2));
}
