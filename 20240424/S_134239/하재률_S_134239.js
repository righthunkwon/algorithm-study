function solution(k, ranges) {
    const list = [0];
    
    // while(k>1) {
    //     // 누적합 구하기
    //     if(k%2){
    //         list.push(k + 3*k + 1) / 2+ list[list.length-1];
    //         k = 3*k + 1;
    //     } else {
    //         list.push((k+k/2)/2 + list[list.length-1]);
    //         k/=2;
    //     }
    // }
    
    // 코드 아름답게 만들기
    let tmp = k;
    while(tmp > 1) {
        const nextTmp = tmp % 2 ? 3*tmp+1 : tmp/2;
        list.push(list.at(-1) + (tmp+nextTmp)/2);
        tmp = nextTmp;
    }
    console.log(list);
    
    // .at(idx) 메서드는 idx 번째 반환 파이썬처럼 음수는 뒤에서부터 인덱스를 반환
    let res = ranges.map(([s,e])=>{
        if(list.length -1 + e < s) return -1;
        return list.at(e-1) - list[s];
    })
    console.log(res);
    
    return res;
}
