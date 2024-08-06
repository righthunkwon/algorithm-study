function solution(n) {
    const arr = Array.from(Array(n), (_, i)=> Array.from(Array(i++), () => 0));
    let a = -1, b = 0, num = 1;
    for(let i = 0; i < n; i++) {
        for(let j = n-i; j > 0; j--) {
            if(i%3 === 0) a++;
            else if(i%3 === 1) b++;
            else {
                a--;
                b--;
            }
            arr[a][b] = num++;
        }        
    }
    
    return arr.flat();
}
