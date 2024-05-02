function solution(s) {
    var answer = [0, 0];
    
    while(s !== '1'){
        let tmp = '';
        for(let i = 0; i < s.length; i++){
            if(s[i] === '0') answer[1]++;
            else tmp += s[i];
        }
        s = tmp.length.toString(2);
        
        answer[0]++;
    }
    console.log(answer);
    
    return answer;
}
