function solution(n) {
    var answer = [];
    
    const hanoi = (n, 출발, 경유, 도착) => {
        if(n === 0) return;
        
        hanoi(n - 1, 출발, 도착, 경유);
        answer.push([출발, 도착]);
        hanoi(n - 1, 경유, 출발, 도착);
    }
    
    hanoi(n, 1, 2, 3);
    
    return answer;
}
