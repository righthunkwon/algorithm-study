function solution(s) {
    var answer = '';
    // 모두 소문자로 바꾸기
    s = s.toLowerCase();
    // 단어 잘라서 list에 넣기
    let list = s.split(' ');
    console.log(list);
    // 첫 글자만 대문자 + 나머지 그대로
    for(let i = 0; i < list.length; i++){
        list[i] = list[i].charAt(0).toUpperCase() + list[i].slice(1);
        
        answer += list[i];
        // 마지막 단어는 끝에 빈칸X
        if(i<list.length-1) answer += ' ';
    }
    console.log(answer);
    return answer;
}
