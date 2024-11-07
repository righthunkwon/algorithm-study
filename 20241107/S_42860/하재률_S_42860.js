function solution(name) {
    var answer = 0;
    // JavaScript 아스키코드 변환 : 'A'.charCodeAt() => 65
    
    // 위아래 조작 횟수
    [...name].forEach(v => {
        answer += Math.min(v.charCodeAt() - 'A'.charCodeAt(), 'Z'.charCodeAt() - v.charCodeAt() + 1);
    })
    
    // 커서 이동 최적화
    let min = name.length - 1;
    
    for(let i = 0; i < name.length; i++) {
        let next = i + 1;
        // 연속된 A 찾기
        while(next < name.length && name[next] === 'A') next++;
        
        // 앞으로 가다가 돌아가는 경우, 뒤로 갔다가 앞으로 가는 경우
        const move = i + name.length - next + Math.min(i, name.length - next);
        min = Math.min(min, move);
    }
    
    return answer + min;
}
