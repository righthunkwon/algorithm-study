function solution(numbers) {
    var answer = Array.from({length: numbers.length}, ()=> -1);
    let st = [];
    for(let i = 0; i < numbers.length; i++){
        while(st.length && numbers[st[st.length-1]] < numbers[i]){
            answer[st.pop()] = numbers[i];
        }
        st.push(i);
        // console.log(i, st);
    }
    // console.log(answer);
    return answer;
}
