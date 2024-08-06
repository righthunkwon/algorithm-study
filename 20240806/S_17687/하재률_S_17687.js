function solution(n, t, m, p) {
    let ans = '';
    let arr = '';
    for(let i = 0; i < m*t; i++) arr += (i.toString(n).toUpperCase());
    // console.log(arr)
    
    for(let i = p-1; i < m*t; i+=m) ans += arr[i];
    
    
    return ans;
}
