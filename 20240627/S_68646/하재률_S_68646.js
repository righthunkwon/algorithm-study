function solution(a) {
    // 마지막까지 남을 수 있는 녀석들 모아줄 배열
    let left = [];
    let right = [];
    
    // 양쪽에서 시작
    let leftMin = a[0];
    let rightMin = a[a.length-1];
    
    for(let i = 1; i < a.length-1; i++) {
        // 정방향 순회
        if(leftMin > a[i]) {
            // 더 작은값이 나오면 그 값 기준 왼쪽 모두는 해당 값으로 터트리기 가능(마지막까지 생존 가능)
            leftMin = a[i];
            left.push(a[i]);
        }
        // 역방향 순회
        if(rightMin > a[a.length - 1 - i]) {
            rightMin = a[a.length - 1 - i];
            right.push(a[a.length - 1 - i]);
        }
    }
    // console.log(left);
    // console.log(right);
    
    // 중복 제거하고 양쪽끝 + 2
    return [...new Set([...left, ...right])].length + 2;
}
