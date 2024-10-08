function solution(str1, str2) {
    // 두개씩 잘라서 개수 정리
    const sol = (str) => {
        return [...str]
        .map((v, idx) => (v + str[idx +1]).toLowerCase()) // 두개씩 잘라서 소문자로
        .slice(0, -1) // undefined 붙여진 마지막 요소 제거
        .filter(v => !v.match(/[^a-z]/g)) // 특수문자 포함된것 제거
        // 개수 카운팅
        .reduce((acc, v) => {
            if(acc[v]) acc[v]++;
            else acc[v] = 1;
            return acc;
        }, {});
    }
    
    const A = sol(str1);
    const B = sol(str2);
    // console.log(A, B)
    
    const keys = new Set([...Object.keys(A), ...Object.keys(B)]);
    
    let gyo = 0;
    let hap = 0;
    
    for(const key of keys) {
        if(A[key] && B[key]) {
            gyo += Math.min(A[key], B[key]);
            hap += Math.max(A[key], B[key]);
        } else if(A[key]) hap += A[key];
        else if(B[key]) hap += B[key];
    }
    
    return !gyo && !hap ? 65536 : Math.floor((gyo / hap) * 65536);
}
