// 효율성 테스트 2번에서 터짐 => 다시 돌리니까 성공
function solution(n, stations, W) {
    let result = 0;
    let coverage = 2 * W + 1;
    let start = 1;

    // forEach
    stations.forEach(station => {
        let leftEdge = station - W;
        if (start < leftEdge) {
            let uncovered = leftEdge - start;
            result += Math.ceil(uncovered / coverage);
        }
        start = station + W + 1;
    });

    if (start <= n) {
        let uncovered = n - start + 1;
        result += Math.ceil(uncovered / coverage);
    }

    return result;
}