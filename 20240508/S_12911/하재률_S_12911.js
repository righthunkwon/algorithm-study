function solution(n) {
    
    const func = (x) => {
        const tmp = x.toString(2);
        let cnt = 0;
        for(const a of tmp) if(a === '1') cnt++;
        
        return cnt;
    }
    
    const cnt = func(n);
    let answer = n;
    while(true) if(cnt === func(++answer)) return answer;
}
