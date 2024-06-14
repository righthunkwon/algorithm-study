const reverse = (str) => {
    return str.slice(1, str.length - 1).split('').map((c) => (c === '(' ? ')' : '(')).join('');
}

function solution(p) {
    var answer = '';
    
    if(p.length < 1) return '';
    
    let cnt = 0;
    let tmp = 0;
    
    do { cnt += p[tmp++] === '(' ? 1 : -1 } 
    while(cnt !== 0);
    
    const u = p.slice(0, tmp);
    const v = solution(p.slice(tmp, p.length));
    
    if(u[0] === '(' && u[u.length - 1] == ')') return u + v;
    else return '(' + v + ')' + reverse(u);
}
