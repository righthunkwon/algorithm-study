function solution(info, edges) {
    let answer = 1; // 0번 노드는 항상 양
    // 단방향 그래프 그려주기
    let graph = Array.from(Array(info.length), ()=> []);
    edges.forEach(v => graph[v[0]].push(v[1]));
    // console.log(graph);
    
    const dfs = (now, sheep, wolf, q) => {
        // 양이 늑대보다 같거나 적어지면 return
        if(sheep <= wolf) return;
        
        // 현재 노드에서 갈 수 있는 노드들 업데이트(길을 뚫어놓으면 언제든 갈 수 있음)
        let list = [...q, ...(graph[now] || [])];
        // 현재 노드 list에서 삭제
        list = list.filter(n => n !== now);
        // console.log(list);
        // console.log(sheep, wolf);
        for(let x of list) {
            if(info[x] === 0) dfs(x, sheep + 1, wolf, list);
            else dfs(x, sheep, wolf + 1, list);
        }
        
        answer = Math.max(answer, sheep);
        return answer;
    }
    
    // (현재노드, 양(0번노드는 양이니까 1), 늑대, q(0번노드 시작))
    dfs(0, 1, 0, [0]);
    
    return answer;
}
