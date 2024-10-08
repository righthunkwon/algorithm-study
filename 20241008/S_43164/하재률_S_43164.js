function solution(tickets) {
    var answer = [];
    const chk = Array.from(Array(tickets.length), () => false);
    tickets.sort((a, b) => a[0] === b[0] ? a[1].localeCompare(b[1]) : a[0].localeCompare(b[0]));
    
    const dfs = (cur, path) => {
        // 모든 티켓 사용하면 경로 저장
        if(path.length === tickets.length + 1) {
            answer = path;
            return true;
        }
        
        for(let i = 0; i < tickets.length; i++) {
            if(!chk[i] && tickets[i][0] === cur) {
                chk[i] = true;
                if(dfs(tickets[i][1], [...path, tickets[i][1]])) return true;
                chk[i] = false
            }
        }
        return false;
    }
    
    dfs('ICN', ['ICN']);
    
    return answer;
}
