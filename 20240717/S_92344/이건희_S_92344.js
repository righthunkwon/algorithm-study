// 파괴되어도 내구도가 계속 감소하는 조건이라 간단
// 그냥 풀면 효율성에서 막히더라
function solution(board, skill) {
    const N = board.length;
    const M = board[0].length;
    // 스킬 적용
    skill.forEach(([type, r1, c1, r2, c2, degree]) => {
        if (type === 1) degree = -degree;  // 공격일 경우 내구도 감소
        // 각 스킬을 직사각형 범위에 적용
        for (let r = r1; r <= r2; r++) {
            for (let c = c1; c <= c2; c++) {
                board[r][c] += degree;
            }
        }
    });
    // 파괴되지 않은 건물 세기
    let unbrokenCount = 0;
    for (let r = 0; r < N; r++) {
        for (let c = 0; c < M; c++) {
            if (board[r][c] > 0) {
                unbrokenCount++;
            }
        }
    }
    return unbrokenCount;
}
// 누적합 사용해서 다시 풀면
function solution(board, skill) {
    const N = board.length;
    const M = board[0].length;
    let changes = Array.from({length: N + 1}, () => new Array(M + 1).fill(0)); //한칸씩 추가
    
    // 데미지 들어온 것만 따로 관리 => 파괴되어도 내구도가 계속 감소하는 조건
    // 얘를 누적합해서 나중에 원본 배열에 합쳐주기
    skill.forEach(([type, r1, c1, r2, c2, degree]) => {
        if (type === 1) degree = -degree;  // 공격일 경우 내구도 감소
        changes[r1][c1] += degree;
        if (c2 + 1 < M) changes[r1][c2 + 1] -= degree;
        if (r2 + 1 < N) changes[r2 + 1][c1] -= degree;
        if (r2 + 1 < N && c2 + 1 < M) changes[r2 + 1][c2 + 1] += degree;
    });
    // 누적합을 이용하여 행 방향으로 누적
    for (let x = 0; x < N; x++) {
        for (let y = 1; y < M; y++) {
            changes[x][y] += changes[x][y - 1];
        }
    }
    // 누적합을 이용하여 열 방향으로 누적
    for (let y = 0; y < M; y++) {
        for (let x = 1; x < N; x++) {
            changes[x][y] += changes[x - 1][y];
        }
    }
    // 최종적으로 board에 changes 적용하면서 파괴되지 않은 건물 세기
    // 차분배열을 기존 배열에 동일 길이 만큼만 병합~~
    let answer = 0;
    for (let x = 0; x < N; x++) {
        for (let y = 0; y < M; y++) {
            board[x][y] += changes[x][y];
            if (board[x][y] > 0) {
                answer++;
            }
        }
    }
    return answer;
}
// [10, 10, 10, 10, 10]
// 인덱스 1부터 3까지 +5를 적용
// [0, 0, 0, 0, 0, 0]
// [0, +5, 0, 0, -5, 0]
// 누적합 진행 [0, 5, 5, 5, 0, 0]
// 원배열과 병합 [10, 15, 15, 15, 10, 10]
// 기존 길이만큼만 남기기 [10, 15, 15, 15, 10]