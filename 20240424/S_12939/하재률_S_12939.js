function solution(s) {
    var answer = "";
    let arr = s.split(" ");
    answer += (Math.min(...arr)) + " ";
    answer += (Math.max(...arr));
    
    return answer;
}
