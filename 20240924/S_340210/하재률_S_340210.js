function solution(expressions) {
    var answer = [];
    // 진법 후보 배열
    const base = Array.from(Array(10), () => true);
    
    const jungsang = []; // 정상 수식
    const unknown = []; // 모르는 수식
    
    // 진법 후보 찾기
    const findMaxNum = () => {
        let max = 2;
        expressions.forEach(e => {
            [...e].forEach(c => {
                if(c >= '0' && c <= '9') max = Math.max(max, parseInt(c, 10));
            })
        })
        
        for(let i = 2; i <= max; i++) base[i] = false;
    }
    
    // 정상과 unknown으로 분리
    const splitSusik = () => {
        expressions.forEach(e => {
            if(e.includes('X')) unknown.push(e);
            else jungsang.push(e);
        })
    }
    
    // 정상 수식 검증
    const validateSusik = () => {
        jungsang.forEach(e => {
            const [a, operator, b, _, c] = e.split(" ");
            for(let i = 2; i <= 9; i++) {
                if(base[i]) {
                    const aa = parseInt(a, i);
                    const bb = parseInt(b, i);
                    const cc = parseInt(c, i);
                    
                    if(operator === '+' && aa + bb !== cc) base[i] = false;
                    if(operator === '-' && aa - bb !== cc) base[i] = false;
                }
            }
        })
    }
    
    // 모르는 수식 계산
    const sol = () => {
        const ans = [];
        
        unknown.forEach(e => {
            const [a, operator, b] = e.split(" ");
            const possibleRes = new Set();
            
            for(let i = 2; i <= 9; i++) {
                if(base[i]) {
                    const aa = parseInt(a, i);
                    const bb = parseInt(b, i);
                    let res;
                    
                    // console.log(i+'진법', aa+operator+bb)
                    if(operator === '+') res = aa + bb;
                    else if(operator === '-') res = aa - bb;
                    
                    possibleRes.add(res.toString(i));
                }
            }
            
            // console.log(possibleRes)
            
            if(possibleRes.size > 1) ans.push(`${a} ${operator} ${b} = ?`);
            else {
                const finalRes = [...possibleRes][0];
                ans.push(`${a} ${operator} ${b} = ${finalRes}`);
            }
        })
        
        return ans;
    }
    
    findMaxNum();
    splitSusik();
    validateSusik();
    
    return sol();
}
