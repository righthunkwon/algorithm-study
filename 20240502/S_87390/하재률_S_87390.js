function solution(n, left, right) {
    var answer = [];
    // 1 2 3 / 2 2 3 / 3 3 3
    // 1 2 3 4 / 2 2 3 4 / 3 3 3 4 / 4 4 4 4
    // 1 2 3 4 5 / 2 2 3 4 5 / 3 3 3 4 5 / 4 4 4 4 5 / 5 5 5 5 5
    // i = 0 => i/5=0 i%5=0 : 1
    // i = 4 => i/5=0 i%5=4 : 5
    // i = 6 => i/5=1 i%5=1 : 2
    // i = 7 => i/5=1 i%5=2 : 3
    // i = 9 => i/5=1 i%5=4 : 5
    // i = 18 => i/5=3 i%5=3 : 4
    // i = 20 => i/5=4 i%5=0 : 5
    for(let i = left; i <= right; i++){
        answer.push(Math.max(Math.floor(i/n), i%n) + 1);
    }
    console.log(answer)
    return answer;
}
