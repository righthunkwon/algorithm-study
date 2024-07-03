function solution (n, edge) {
    // 노드 연결 정보가 담긴 이차원 배열 생성
    const connects = new Array(n).fill().map(_ => []);
    for(const e of edge) {
      connects[e[0]-1].push(e[1]-1);
      connects[e[1]-1].push(e[0]-1);
    }

    // 노드 간 거리 저장
    const visited = [1];
    // 실제 큐는 아니고 배열 삽입 삭제 매커니즘이 큐랑 같아서, 시작 노드 체크
    const queue = [0];
    while(queue.length) {
      // 현재 노드 뽑기
      const cur = queue.shift();
      // 노드 순회
      for(const next of connects[cur]) {
        if(!visited[next]) {
          // 방문한 노드 1 증가
          visited[next] = visited[cur] + 1;
          // 다음 노드 꺼내기
          queue.push(next);
        }
      }
    }
    // 최대값 뽑기
    const max = Math.max(...visited);
    // 최대값이 동일한 노드 개수 반환
    return visited.filter(el => el === max).length;
  }