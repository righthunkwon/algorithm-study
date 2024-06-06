function solution(number, k) {
    let stack = [];
    for(let i=0;i<number.length;i++) {
        // k를 다 소모하지 않았을때 더 큰 숫자로 바꿔주기
        while(k>0 && stack[stack.length-1]<number[i]) {
            stack.pop();
            k--;
        }
        stack.push(number[i]);
        // console.log(stack);
    }
    stack.splice(stack.length-k,k);   
    return stack.join('');
}
