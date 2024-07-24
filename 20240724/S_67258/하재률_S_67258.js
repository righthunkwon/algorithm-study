function solution(gems) {
    // 서로 다른 보석의 개수 구하기 Set
    const num = new Set(gems).size;
    let ans = [1, gems.length];
    let l = 0, r = 0;
    const map = new Map();
    
    while(r < gems.length) {
        // 오른쪽 보석 추가
        map.set(gems[r], (map.get(gems[r]) || 0) + 1);
        
        // 보석 모두 포함하면
        while(map.size === num) {
            // 최소 구간 갱신
            if(r - l < ans[1] - ans[0]) ans = [l + 1, r + 1];
            
            // 왼쪽 보석 제거
            map.set(gems[l], map.get(gems[l]) - 1);
            if(map.get(gems[l]) === 0) map.delete(gems[l]);
        
            l++;
        }
        
        r++;
    }
    
    return ans;
}
