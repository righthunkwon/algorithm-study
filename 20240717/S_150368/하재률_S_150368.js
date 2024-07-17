function solution(users, emoticons) {
    // 각 이모티콘 할인율 10 20 30 40 ... 4^이모티콘개수
    
    const discount = [10, 20, 30, 40];
    let answer = [-Infinity, -Infinity];
    
    const dfs = (idx, curDC) => {
        if(idx === emoticons.length) {
            const res = calc(users, emoticons, curDC);
            if(res[0] > answer[0] ||
                (res[0] === answer[0] && res[1] > answer[1])){
                    answer = res;
            }
        return;    
        }
        
        for(d of discount) {
            curDC.push(d);
            dfs(idx + 1, curDC);
            curDC.pop();
        }
    };
    
    const calc = (users, emoticons, dc) => {
        let res1 = 0, res2 = 0;
        
        for(let user of users) {
            let cost = 0;
            for(let i = 0; i < emoticons.length; i++) {
                if(dc[i] >= user[0]) cost += emoticons[i] * (1 - dc[i] / 100);
            }
            if(cost >= user[1]) res1++;
            else res2 += cost;
        }
        return [res1, res2];
        
    };
    
    dfs(0, []);
    
    return answer;
}
