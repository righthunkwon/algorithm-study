// 효율성 테스트 2번에서 터짐 => 다시 돌리니까 성공
function solution(n, stations, W) {
    let result = 0;
    // 하나의 기지국이 커버 가능한 범위
    let coverage = 2 * W + 1;
    // 첫번째 아파트 지정
    let start = 1;

    // forEach
    stations.forEach(station => {
        // 왼쪽 시작점 체크
        let leftEdge = station - W;
        // 왼쪽 시작점 밖에 시작지점이 있으면 => 커버가 안되어 있으면
        if (start < leftEdge) {
            // 커버되지 않은 영역 길이 체크
            let uncovered = leftEdge - start;
            // 사용 할 기지국 갯수 체크 => 커버에 필요한 기지국 갯수
            result += Math.ceil(uncovered / coverage);
        }
        // 체크 끝났으면 시작지점 이동
        start = station + W + 1;
    });
    // 한바퀴 돌리고도 커버되지 않은 영역이 있으면 추가로 필요한 기지국 체크
    if (start <= n) {
        let uncovered = n - start + 1;
        result += Math.ceil(uncovered / coverage);
    }

    return result;
}