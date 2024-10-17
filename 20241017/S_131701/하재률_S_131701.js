function solution(elements) {
    // 중복 제거를 위해 Set
    const set = new Set();
    // 원형 수열을 위해서 길게 붙여버리기
    const arr = [...elements, ...elements];
    
    // 1개, 2개, ... elements 길이개 까지
    for(let i = 1; i <= elements.length; i++) {
        for(let j = 0; j < elements.length; j++) {
            const sum = arr.slice(j, j + i).reduce((a, b) => a + b, 0);
            set.add(sum);
        }
    }
    // console.log(set)
    return set.size;
}
