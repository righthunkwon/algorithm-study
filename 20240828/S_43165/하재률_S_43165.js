function solution(numbers, target) {
    var answer = 0;
    
    const dfs = (idx, cur) => {
        if(idx === numbers.length) {
            if(cur === target) {
                answer++;
                return;
            } else return;
        }
        
        dfs(idx+1, cur + numbers[idx]);
        dfs(idx+1, cur - numbers[idx]);
    }
    
    dfs(0, 0);
    
    return answer;
}
