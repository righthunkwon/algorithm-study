function solution(n,a,b)
{
    let answer = 0;

    while(a !== b) {
        a = a % 2 === 0 ? a : a + 1;
        b = b % 2 === 0 ? b : b + 1;
        a = Math.floor(a/2);
        b = Math.floor(b/2);
        // console.log(a, b)
        answer++;
    }

    return answer;
}
