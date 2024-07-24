// 최댓값 비교하면서 DP 채워넣는 문제
// 두 방향 다 가능한데
// 아래에서 위로 올라오는게 처리하는게 덜해서 좀 더 빠르다
// 위에서 아래로 5초
function solution(triangle) {
    // 삼각형의 크기에 맞는 동일한 구조의 DP 배열 초기화
    let dp = Array.from({length: triangle.length}, (_, i) => Array(triangle[i].length).fill(0));
    // 맨 위의 값으로 초기화
    dp[0][0] = triangle[0][0];

    // 삼각형의 두 번째 줄부터 시작하여 아래로 내려가면서 계산
    for (let row = 1; row < triangle.length; row++) {
        for (let col = 0; col <= row; col++) {
            // 맨 왼쪽일 경우
            if (col === 0) {
                dp[row][col] = dp[row - 1][col] + triangle[row][col];
            } else if (col === row) {
                // 맨 오른쪽일 경우
                dp[row][col] = dp[row - 1][col - 1] + triangle[row][col];
            } else {
                // 중간에 위치할 경우
                dp[row][col] = Math.max(dp[row - 1][col - 1], dp[row - 1][col]) + triangle[row][col];
            }
        }
    }

    // 마지막 줄에서 가장 큰 값을 찾음
    return Math.max(...dp[triangle.length - 1]);
}
// 아래에서 위로 3초
function solution(triangle) {
    // 삼각형의 바닥부터 시작하여 위로 올라가면서 최대 합 계산
    for (let row = triangle.length - 2; row >= 0; row--) {
        for (let col = 0; col <= row; col++) {
            // 현재 위치에서 내려갈 수 있는 두 경로 중, 더 큰 값과 현재 위치의 값을 더해서 업데이트
            triangle[row][col] += Math.max(triangle[row + 1][col], triangle[row + 1][col + 1]);
        }
    }

    // 맨 위층에 도달했을 때의 값이 최대 합
    return triangle[0][0];
}
// Java 코드
