// 노드 링크드 리스트, 효율성 테케1 통과 (604.56ms, 140MB)
// 2번 테케가 전부 삭제 문제라서 해당 부분 주의
class Node {
    constructor(index) {
        this.index = index;
        this.prev = null;
        this.next = null;
    }
}

function solution(n, k, cmd) {
    // 초기 노드 생성
    let start = new Node(0);
    let currentNode = start;
    // 링크드리스트 생성
    for (let i = 1; i < n; i++) {
        let newNode = new Node(i);
        currentNode.next = newNode;// 앞
        newNode.prev = currentNode;// 뒤로 값 넣어주고
        currentNode = newNode;// 다음 노드로 이동
    }
    // k 노드로 세팅
    let now = start;
    for (let i = 0; i < k; i++) {
        now = now.next;
    }
    const del = [];  // 삭제된 노드들을 저장할 스택
    // 명령어 스위치 케이스로 처리
    for (let i = 0; i < cmd.length; i++) {
        const [command, X] = cmd[i].split(" ");
        let move;
        switch (command) {
            case "U":
                move = parseInt(X, 10);// 숫자로 변환
                for (let j = 0; j < move; j++) now = now.prev;
                break;
            case "D":
                move = parseInt(X, 10);// 숫자로 변환
                for (let j = 0; j < move; j++) now = now.next;
                break;
            case "C":
                del.push(now);
                if (now.prev) now.prev.next = now.next;
                if (now.next) now.next.prev = now.prev;
                if (now === start) {
                    start = now.next; // 첫 번째 노드 삭제 시, 새로운 시작점 설정
                }
                now = now.next ? now.next : now.prev;// 다음 노드 있으면 이동 없으면 앞에 노드로 이동
                break;
            case "Z":
                const recovered = del.pop();
                if (recovered.prev) recovered.prev.next = recovered;
                if (recovered.next) recovered.next.prev = recovered;
                if (recovered.prev === null) {
                    start = recovered; // 복구된 노드가 새로운 시작점이 될 수 있음
                }
                break;
        }
    }

    // 결과 문자열 생성
    const answer = Array(n).fill("X");
    currentNode = start;
    while (currentNode) {
        answer[currentNode.index] = 'O';
        currentNode = currentNode.next;
    }

    return answer.join('');
}



// 이건 그냥 배열로 한건데, 오래 걸리고 C Z 로직 처리가 복잡해서 그냥 링크드로 구현하는게 맞는듯
function solution(n, k, cmd) {
    // 1. n 만큼 tmp배열 생성, 해당 배열 전부 true로 채우기
    // 2. 가장 최근에 삭제된 인덱스 저장 할 del 배열
    // 3. now 변수 선언, 해당 변수 초기값 k
    // 4. cmd 들어온 것 반복문으로 순회 하면서 switch 케이스로 돌리기
    // 5-a. U X는 now = Math.min(now+X, n);
    // 5-b. D X는 now = Math.max(now-X, 0);
    // 5-c. C는 tmp[now] = false 처리하고 del = now, if(now != 0){now--}else{now++}
    // false 처리되어 있는 배열 고려해서 빡빡하게 처리
    // 5-d. Z는 del 참고 해서 해당 배열 tmp 다시 true로 변환 del.pop()
    // 6. 최종적으로 tmp 배열을 true는 O false는 X로 처리해서 하나의 문자열로 반환
    const tmp = new Array(n).fill(true);  // 행의 삭제 상태를 추적하는 배열
    let now = k;                         // 현재 선택된 행의 인덱스
    const del = [];                      // 가장 최근에 삭제된 행의 인덱스를 저장하는 배열

    for (let instruction of cmd) {
        const [type, X] = instruction.split(" ");
        let move;
        switch (type) {
            case "U":
                move = parseInt(X, 10);
                while (move > 0) { 
                    now--;
                    if (tmp[now]) move--;
                }
                break;
            case "D":
                move = parseInt(X, 10);
                while (move > 0) {       
                    now++;
                    if (tmp[now]) move--;
                }
                break;
            case "C":
                tmp[now] = false;
                del.push(now);
                if (now === n - 1 || !tmp[now + 1]) {
                    while (now > 0 && !tmp[now]) {
                        now--;
                    }
                } else {
                    while (now < n - 1 && !tmp[now]) {
                        now++;
                    }
                }
                break;
            case "Z":
                if (del.length > 0) {
                    const recovered = del.pop();
                    tmp[recovered] = true;
                }
                break;
        }
    }
    let answer = '';
    for (let state of tmp) {
        answer += state ? 'O' : 'X';
    }
    return answer;
}