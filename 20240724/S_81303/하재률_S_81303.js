class Memo {
    constructor(idx) {
        this.idx = idx;
        this.next;
        this.prev;
    }
}

function solution(n, k, cmd) {
    const ans = [];
    const remove = [];
    
    let cur;
    let tmp;
    
    for(let i = 0; i < n; i++) {
        ans[i] = 'O';
        const memo = new Memo(i);
        
        if(i === k) cur = memo;
        
        if(!tmp) {
            tmp = memo;
            continue;
        }
        
        tmp.next = memo;
        memo.prev = tmp;
        tmp = tmp.next;
    }
    
    // console.log(cur)
    
    cmd.forEach(e => {
        const [com, cnt] = e.split(' ');
        let num = +cnt;
        switch(com) {
            case 'U':
                while(num--) {
                    if(cur.prev) cur = cur.prev;
                }
                break;
            case 'D':
                while(num--) {
                    if(cur.next) cur = cur.next;
                }
                break;
            case 'C':
                remove.push(cur);
                ans[cur.idx] = 'X';
                if(cur.prev) cur.prev.next = cur.next;
                if(cur.next) cur.next.prev = cur.prev;
                cur = cur.next ? cur.next : cur.prev;
                break;
            case 'Z':
                const revive = remove.pop();
                ans[revive.idx] = 'O'
                if(revive.prev) revive.prev.next = revive;
                if(revive.next) revive.next.prev = revive;
                break;
        }
    })
    
    // console.log(ans)
    
    return ans.join('');
}
