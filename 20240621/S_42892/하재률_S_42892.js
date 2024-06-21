function solution(nodeinfo) {
    // 이진트리 : 각 노드 자식이 최대 2개
    // 전위 순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식
    // 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모
    
    const tree = nodeinfo
        // 순서대로 노드 번호 매겨주기 [x, y, idx]
        .map((e, idx) => [...e, idx+1])
        // y값이 같다면 x 오름차순으로... 상위(y가 큰)레벨 노드순으로 정리
        .sort((a, b) => (a[1] === b[1] ? a[0] - b[0] : b[1] - a[1]));
    
    const pre = [];
    const post = [];
    
    // 순회 함수
    const order = (tree, pre, post) => {
        const[x, y, node] = tree[0]; // 루트 노드 데려오기
        const left = [];
        const right = [];
        
        for(let i = 1; i < tree.length; i++) {
            const child = tree[i]; // 자식 하나 데려오기
            // 자식의 x가 루트의 x보다 작으면 왼자, 아니면 오자
            if(child[0] < x) left.push(child);
            else right.push(child);
        }
        
        pre.push(node); // 전위순회는 노드번호 넣고
        // 자식 있으면 다시 order함수에서 부모, 왼자, 오자 찾기
        if(left.length) order(left, pre, post);
        if(right.length) order(right, pre, post);
        // 자식 없으면(단말 노드 도착했으면) 후위순회에 노드번호 넣기
        post.push(node);
        
    }
    
    // console.log(tree);
    
    order(tree, pre, post);
    
    // console.log('전위', pre);
    // console.log('후위', post);
    return [pre, post];
}
