function solution(n) {
    const arr = Array(n+1).fill(true);
    arr[0] = arr[1] = false;
    
    for(let i = 2; i <= Math.sqrt(n); i++) {
        if(arr[i]) {
            for(let j = i*i; j <= n; j += i) arr[j] = false;
        }
    }
    
    return arr.reduce((acc, cur) => acc + (cur ? 1 : 0), 0);
}
