function solution(rc, operations) {
    var answer = [[]];
    // shift는 queue
    // rotate 는 윗줄 아랫줄 왼가운데 오가운데
    operations.forEach((e) => {
        if(e === 'Rotate') {
            let a = rc[0];
            let b = rc[rc.length-1];
            let c = [], d = [];
            for(let i = 1; i < rc.length-1; i++) {
                c.push(rc[i][0]);
                d.push(rc[i][rc[0].length-1]);
            }
            
            a.unshift(c.shift());
            d.unshift(a.pop());
            b.push(d.pop());
            c.push(b.shift());
            
            rc[0] = a;
            rc[rc.length-1] = b;
            for(let i = 1; i < rc.length-1; i++) {
                rc[i][0] = c.shift();
                rc[i][rc[0].length-1] = d.shift();
            }
            
        } else rc.unshift(rc.pop());
    });
    console.log(rc)
    return rc;
}
