function solution(arrayA, arrayB) {
    const sol = (a, b) => {
        while(b !== 0) {
            const tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    // A배열과 B배열의 최대공약수를 구한다
    const a = arrayA.reduce((acc, cur) => sol(acc, cur));
    const b = arrayB.reduce((acc, cur) => sol(acc, cur));
    
    // B배열의 수들이 a로 나눠지는지? A배열 수들이 b로 나눠지는지?
    const isDivisible = (arr, div) => arr.every(n => n % div !== 0);
    
    const resA = isDivisible(arrayB, a) ? a : 0;
    const resB = isDivisible(arrayA, b) ? b : 0;
    
    return Math.max(resA, resB);
}
