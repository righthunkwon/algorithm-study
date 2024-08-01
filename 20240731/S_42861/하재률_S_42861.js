function solution(n, costs) {
    let answer = 0;
    // 부모 배열 초기화
    const parent = Array.from(Array(n), (_, i) => i);
    
    // 부모찾기
    const find = (parent, a) => {
        if(parent[a] === a) return a;
        else return parent[a] = find(parent, parent[a]);
    }
    
    // 합치기
    const union = (parent, a, b) => {
        a = find(parent, a);
        b = find(parent, b);
        if(a !== b) parent[b] = a;
    }
    
    // cost로 정렬
    costs.sort((a, b) => a[2] - b[2]);
    
    for(const e of costs) {
        if(find(parent, e[0]) !== find(parent, e[1])) {
            answer += e[2];
            union(parent, e[0], e[1]);
        }
    };
    
    return answer;
}
