function solution(citations) {
    var answer = 0;
    citations = citations.sort((a, b) => b - a);
    // console.log(citations)
    for(let i = 0; i < citations.length; i++) {
        if(citations[i] >= i + 1) answer = i + 1;
    }
    return answer;
}
