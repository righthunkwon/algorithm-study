// Java 코드 기반으로 재작성
// 같은 로직으로 풀었지만 조금 더 자바스크립트 스러운 방식으로 푼 코드
// => https://medium.com/@songforthemute/programmers-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-lv-3-%EB%AF%B8%EB%A1%9C-%ED%83%88%EC%B6%9C-%EB%AA%85%EB%A0%B9%EC%96%B4-c1525241a469
class Path {
    constructor(x, y, path, remainingDistance) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.remainingDistance = remainingDistance;
    }
}

function solution(n, m, x, y, r, c, k) {
    const dx = [-1, 0, 0, 1]; // 상, 우, 좌, 하
    const dy = [0, 1, -1, 0];
    const dirChars = ['u', 'r', 'l', 'd']; // 해당 방향을 문자로 매핑

    if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 !== 0) {
        return "impossible";
    }

    // const stack = [{ x, y, path: "", remaining: k }];
    // 객체 리터럴 없이 그냥 선언해도 되지만 노드를 쓰는게 더 효율적이니까
    const stack = [new Path(x, y, "", k)]; // 스택처럼 사용 할 배열 선언

    while (stack.length > 0) {
        const current = stack.pop(); // 배열의 맨 끝 == 스택 맨 위를 꺼내온다.

        if (current.remainingDistance === 0) {
            if (current.x === r && current.y === c) {
                return current.path;
            }
            continue;
        }
        for (let i = 0; i < 4; i++) {
            const nx = current.x + dx[i];
            const ny = current.y + dy[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                const newPath = current.path + dirChars[i];
                const newRemaining = current.remainingDistance - 1; // 남은 이동 가능 거리 줄여주고
                const manhattan = Math.abs(r - nx) + Math.abs(c - ny);
                if (manhattan <= newRemaining && (newRemaining - manhattan) % 2 === 0) {
                    stack.push(new Path(nx, ny, newPath, newRemaining)); // 배열의 맨 끝에 추가 해준다 == 스택에 추가 해준다.
                }
            }
        }
    }
    return "impossible";
}