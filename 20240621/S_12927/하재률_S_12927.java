function solution(n, works) {
    var answer = 0;
    works.sort((a, b) => b - a);
    
    let idx = 0;
    while(n > 0) {
        if(works[idx] < works[idx + 1]) idx++;
        if(idx > 0 && works[idx] === works[idx - 1]) idx = 0;
        if(works[idx] > 0) works[idx]--;
        n--;
    }
    
    // console.log(works);
    
    return works.reduce((acc, cur) => acc + cur ** 2, 0);
}
