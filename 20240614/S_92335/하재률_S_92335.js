// 에라토스 뭐시기의 체
const isPrime = (num) => {
    if(num <= 1) return false;
    for(let i = 2; i <= Math.sqrt(num); i++){
        if(num % i === 0) return false;
    }
    return true;
}

function solution(n, k) {
    var answer = 0;
    
    let num = n.toString(k); // 진수 변환
    let arr = [];
    
    // 0 떼고 하나씩 담기
    num.split('0').forEach((v)=> {
        if(v !== '') arr.push(v);
    });
    
    // console.log(arr);
    
    // 소수인지 판별
    arr.forEach((v)=> {
        if(isPrime(Number(v))) answer++;
    })
    
    return answer;
}
