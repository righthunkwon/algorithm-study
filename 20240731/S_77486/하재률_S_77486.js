function solution(enroll, referral, seller, amount) {
    var answer = [];
    const map = new Map();
    map.set('minho', { ref: null, money: 0 });
    enroll.map((e, i) =>
        map.set(e, { ref: referral[i] === '-' ? 'minho' : referral[i], money: 0}))
    
    const pyramid = (n, x) => {
        const div = Math.floor(n / 10);
        const profit = n - div;
        map.get(x).money += profit;
        
        if(div >= 1 && map.get(x).ref) pyramid(div, map.get(x).ref);
        return;
    }
    
    amount.map((e, i) => {
        pyramid(e*100, seller[i]);
    })
    
    // console.log(map)
    map.forEach((e, k) => {
        if(k !== 'minho') answer.push(e.money)
    })
    
    return answer;
}
