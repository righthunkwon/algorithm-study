// 문제에서 대놓고 DFS하라고 정해준 문제
// 중간에 정지 시킬 조건 도 주어졌다.
// 정지 조건 늑대가 양보다 같거나 많아지면 해당 케이스는 폐기
// [ver1] DFS 테케 17 5.95ms
function solution(info, edges) {
    // 각 노드의 자식 노드를 저장할 그래프 초기화
    const graph = Array.from({length: info.length}, () => []);
    // 각 노드의 연결 관계를 이차원 그래프에 저장, 햇갈리니까 명확하게 변수 지정
    //입력 배열에서 앞이 부모, 뒤가 자식 노드 번호
    edges.forEach(([parent, child]) => {
        graph[parent].push(child); 
    });
    // 여기가지 2차원 배열 만드는 코드
    // ex) edges가 [[0,1], [0,2], [1,3]]
    // graph = [
    //     [1, 2], 
    //     [3],
    //     [],
    //     []
    // ];
    // 최대 양의 수를 저장할 변수, 늑대는 bfs에서 따로 저장할거라서 패스
    let maxSheep = 0; // 
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
        // DFS 정지 조건, 추가로 방문 할 노드가 없으면 nextAvailable의 길이가 0이라 dfs가 추가 실행이 안된다.
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
// [ver2] BFS 객체 테케 17, 18.60ms
function solution(info, edges) {
    // 노드 연결 관계를 그래프로 구성
    const graph = createGraph(info.length, edges);
    // BFS를 사용하여 최대 양의 수 계산
    return bfs(graph, info);
}
// 그래프 생성 함수
function createGraph(nodeCount, edges) {
    const graph = Array.from({length: nodeCount}, () => []);
    edges.forEach(([parent, child]) => {
        graph[parent].push(child);
    });
    return graph;
}
// BFS 실행 함수
function bfs(graph, info) {
    let maxSheep = 0;
    const queue = [{ node: 0, sheep: 0, wolf: 0, available: new Set(graph[0]) }];

    while (queue.length > 0) {
        const { node, sheep, wolf, available } = queue.shift();
        const newSheep = sheep + (info[node] === 0 ? 1 : 0);
        const newWolf = wolf + (info[node] === 1 ? 1 : 0);

        if (newWolf >= newSheep) continue;
        maxSheep = Math.max(maxSheep, newSheep);

        let nextAvailable = new Set(available);
        nextAvailable.delete(node);
        graph[node].forEach(child => nextAvailable.add(child));

        nextAvailable.forEach(next => {
            queue.push({
                node: next,
                sheep: newSheep,
                wolf: newWolf,
                available: new Set(nextAvailable)
            });
        });
    }

    return maxSheep;
}
