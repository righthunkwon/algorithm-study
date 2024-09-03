function solution(begin, target, words) {
    // 목표 단어가 없으면 0 리턴
    if(!words.includes(target)) return 0;
    
    const q = [begin];
    const chk = { [begin]: 0 };
    
    // 1개만 다르면 true 리턴
    const wordChk = (str1, str2) => {
        let cnt = 0;
        
        for(let i = 0; i < str1.length; i++) {
            if(str1[i] !== str2[i]) cnt++;
            if(cnt > 1) return false;
        }
            
        return cnt === 1;
    }
    
    while(q.length) {
        const cur = q.shift();
        
        if(cur === target) break;
        
        for(const word of words) {
            if(!chk[word] && wordChk(cur, word)) {
                chk[word] = chk[cur] + 1;
                q.push(word);
            }
        }
    }
    
    return chk[target] ? chk[target] : 0;
}
