function solution(numbers) {
    
    const chk = (tree, st, end) => {
        if(!tree.length) return true;
        
        const mid = parseInt((st + end) / 2);
        if(tree[mid] === '0' && tree.indexOf('1') !== -1) return false;
       
        
        return chk(tree.slice(st, mid), st, mid) &&
            chk(tree.slice(mid+1), mid+1, end);
    }
    
    // 높이가 h인 포화이진트리 노드개수 : 2^h - 1
    // n개 노드를 가진 이진 트리 높이 h : log2(n+1)
    const answer = numbers.map(e => {
        const bin = e.toString(2);
        const h = Math.ceil(Math.log2(bin.length + 1));
        
        const tree = '0'.repeat(2 ** h - 1 - bin.length) + bin;
        
        return chk(tree, 0, tree.length) ? 1 : 0;
    })
    
    return answer;
}
