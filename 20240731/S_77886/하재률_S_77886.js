function solution(s) {
    var answer = [];
    // 110 다 빼서 마지막 0 뒤에 끼워넣기
    
    s.forEach(e => {
        const s = [];
        let str = '';
        [...e].forEach((v, i) => {
            if(i > 1) {
                const prev = s.pop();
                const pprev = s.pop();
                if(pprev === '1' && prev === '1' && v === '0') {
                    str += '110';
                } else s.push(pprev, prev, v);
            } else {
                s.push(v);
            }
        })
        
        let tmp = s.join('');
        let idx = tmp.lastIndexOf('0');
        const ans = idx === -1 ? str + tmp : tmp.slice(0, idx+1) + str + tmp.slice(idx+1);
        answer.push(ans);
    })
    
    
    return answer;
}
