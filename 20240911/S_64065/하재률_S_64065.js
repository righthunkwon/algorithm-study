function solution(s) {
    let answer = [];
    
    s = s.slice(2).slice(0, -2);
    const arr = s.split('},{').map(v => v.split(','));
    arr.sort((a, b) => a.length - b.length)
    // console.log(arr)
    arr.forEach(v => {
        for(let i = 0; i < v.length; i++) {
            if(!answer.includes(Number(v[i]))) {
                answer.push(Number(v[i]));
                break;
            }
        }
    })
    
    return answer;
}
