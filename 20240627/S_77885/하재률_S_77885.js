function solution(numbers) {
    var answer = [];
    
    numbers.map(v => {
        let two = v.toString(2);
        // 2진법 마지막값이 0이면 1로 바꿔주는게 최소값
        if(two.at(-1) === '0') two = two.substring(0, two.length-1) + '1';
        // 아니면 01찾아서 10으로 바꿔주기
        else {
            const idx = two.lastIndexOf('01');
            two = two.substring(0, idx) + '10' + two.substring(idx+2, two.length);
        }
        answer.push(parseInt(two, 2));
    })
    
    return answer;
}
