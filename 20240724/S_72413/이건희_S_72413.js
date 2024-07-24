// 모든 지점->지점 사이의 최단거리를 다 알아야 해서 플로이드-워셜을 사용한다. 테케 28 60ms
// 다익스트라도 가능할 듯=>다 풀고 보니
// 다익스트라(빡 구현) O(노드2+간선)
// 다익스트라(우선순위큐) O((노드+간선)log노드)
// 플로이드 워셜 O(노드3)
// 양방형 간선 최대값 노드(노드-1) ~ 노드2
// 그냥 왠만하면 다익스트라 우선순위큐 써서 푸는게 가장 빠르다
// 정답 풀이 간선 고려해서 최댓값 설정 => 그냥 지원하는 숫자 max값 넣는게 맞는듯, 이동 못한다는 의미로 큰 수를 넣는 개념이라
function solution(n, s, a, b, fares) {
    // 각 지점 간의 최대 가능 비용보다 큰 값으로 초기화
    const MAX = 100000 * (n - 1) + 1;
    //이거 아니면 그냥
    // const MAX = Infinity;
    const dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(MAX));
    // 자기 자신으로의 거리는 0으로 초기화
    for (let i = 1; i <= n; i++) {
        dist[i][i] = 0;
    }
    // 요금 정보를 이용하여 거리 행렬 초기화
    fares.forEach(([c, d, f]) => {
        dist[c][d] = f;
        dist[d][c] = f;
    });
    // 플로이드-워셜 알고리즘을 이용해 모든 지점 쌍의 최단 거리 계산
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    let answer = MAX;
    // 같이 가는 지점을 t라고 지정
    // 모든 가능한 합승 지점 t를 순회하면서 최소 요금 계산
    for (let t = 1; t <= n; t++) {
        answer = Math.min(answer, dist[s][t] + dist[t][a] + dist[t][b]);
    }
    return answer;
}
// 플로이드-워셜 => 최댓값 잘못 설정해서 틀림
function solution(n, s, a, b, fares) {
    const dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(100_000 + 1));
    // 자기->자기 거리 0
    for (let i = 1; i <= n; i++) {
        dist[i][i] = 0;
    }
    // fares 입력에 따라 비용 체크
    fares.forEach(([c, d, f]) => {
        dist[c][d] = f;
        dist[d][c] = f;
    });
    // 플로이드-워셜 알고리즘을 이용해 모든 지점 쌍의 최단 거리 계산
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    // 같이 가는 지점을 t라고 지정
    // 모든 가능한 합승 지점 t를 순회하면서 최소 요금 계산
    let answer = 100_000 + 1 ;
    for (let t = 1; t <= n; t++) {
        let currentCost = dist[s][t] + dist[t][a] + dist[t][b];
        if (currentCost < answer) {
            answer = currentCost;
        }
    }
    return answer;
}
// 다익스트라로 푸는 법, 이건 보면서 했슴다
// 다익스트라로로 가능 한 지점과 다른 모든 지점간의 최단경로를 구하는 거니까
// S->t, A->t, B->t 이렇게 다익스트라 3번 돌리고
// t까지 최단경로 합을 구하면 된다.
function solution(n, s, a, b, fares) {
    const dist = Array.from({ length: n + 1 }, () => []);
    fares.forEach(([c, d, f]) => {
        dist[c].push([d, f]);
        dist[d].push([c, f]);
    });
    // 여기까지는 똑같고
    const distFromS = dijkstra(n, s, dist);
    const distFromA = dijkstra(n, a, dist);
    const distFromB = dijkstra(n, b, dist);

    let answer = Infinity;
    for (let t = 1; t <= n; t++) {
        answer = Math.min(answer, distFromS[t] + distFromA[t] + distFromB[t]);
    }

    return answer;
}
// 다익스트라 함수 우선순위 큐 쓰면 더 빠름
function dijkstra(n, start, graph) {
    const distances = Array(n + 1).fill(Infinity);
    const visited = Array(n + 1).fill(false);
    distances[start] = 0;

    for (let i = 0; i < n; i++) {
        let u = -1;
        // 최소 거리 노드 찾기
        for (let v = 1; v <= n; v++) {
            if (!visited[v] && (u === -1 || distances[v] < distances[u])) {
                u = v;
            }
        }
        visited[u] = true; // 노드 방문 처리
        // 인접 노드 거리 갱신
        for (const [v, cost] of graph[u]) {
            if (distances[u] + cost < distances[v]) {
                distances[v] = distances[u] + cost;
            }
        }
    }
    return distances;
}