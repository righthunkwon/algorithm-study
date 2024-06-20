// 1차 풀이 => 단순 배열 순회
// 테스트 케이스 통과 O
// 효율성 테스트 통과 X
// function solution(n, works) {
//     while (n > 0) {
//         works.sort((a, b) => b - a);
//         if (works[0] === 0) break;
//         works[0]--;
//         n--;
//     }
//     return works.reduce((acc, work) => acc + work * work, 0);
// }
// 문제점 : 매번 정렬을 다시 한다. 이거 좀 빡쌔다 js 내장 정렴 함수의 시간복잡도는 nlogn 이걸 n번 반복하면 n2logn


// 2차 풀이 => 가장 큰 수를 정해 놓고 그 수에 맞춰서 일정한 크기로 맞추기
// 테스트 케이스 통과 O
// 효율성 테스트 통과 O
function solution(n, works) {
    // works 배열을 내림차순으로 정렬
    works.sort((a, b) => b - a); // 배열 굳이 재할당 해줄 필요 없음
    // 엣지케이스)works 원소의 전체 합이 n보다 작으면 결과는 0
    const totalWork = works.reduce((acc, work) => acc + work, 0);
    if (totalWork <= n) return 0;
    // max 변수는 최대 작업량을 나타냄
    let max = works[0];
    while (n > 0) {
        for (let i = 0; i < works.length; i++) {
            if (works[i] >= max && n > 0) {
                works[i]--;
                n--;
            } else {
                break;
            }
        }
        // 최댓값 다시 갱신 해주기
        max = works[0];
    }
    // 남은 작업량의 제곱의 합 계산
    return works.reduce((acc, work) => acc + work * work, 0);
}
// 추가 합산 후 나누기 해서 균등하게 하는게 안되는 이유 배열의 값이 증가하는 경우가 있음