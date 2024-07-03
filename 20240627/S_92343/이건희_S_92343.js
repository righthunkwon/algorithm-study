// 문제에서 대놓고 BFS하라고 정해준 문제
// 중간에 정지 시킬 조건 도 주어졌다.
function solution(info, edges) {
    // 각 노드의 자식 노드를 저장할 그래프 초기화
    const graph = Array.from({length: info.length}, () => []);
    // 각 노드의 연결 관계를 그래프에 저장
    edges.forEach(([parent, child]) => {
        graph[parent].push(child);
    });
    // 최대 양의 수를 저장할 변수, 늑대는 bfs에서 따로 저장할거라서 패스
    let maxSheep = 0;

    // DFS 함수 정의
    function dfs(current, sheep, wolf, available) {
        // 현재 노드가 양이면 양의 수 증가, 늑대면 늑대의 수 증가
        if (info[current] === 0) sheep++;
        else wolf++;
        // 문제에서 주어진 백트래킹 조건 => 늑대 수가 양 수 이상이면 종료
        if (wolf >= sheep) return;
        // 최대 양의 수 업데이트
        if (sheep > maxSheep) maxSheep = sheep;
        // maxSheep = Math.max(maxSheep, sheep);
        // 다음 방문 가능한 노드들 업데이트
        let nextAvailable = new Set(available);
        nextAvailable.delete(current);
        graph[current].forEach(child => nextAvailable.add(child));
        
        // 다음 방문 가능한 노드들에 대해 DFS 수행
        for (let next of nextAvailable) {
            dfs(next, sheep, wolf, nextAvailable);
        }
    }
    // DFS 시작 (루트 노드에서 시작, 초기 가능한 방문 노드는 루트 노드 자식들)
    let initialAvailable = new Set(graph[0]);
    initialAvailable.add(0); // 루트 노드도 포함
    dfs(0, 0, 0, initialAvailable);
    // 최대 양의 수 반환
    return maxSheep;
}