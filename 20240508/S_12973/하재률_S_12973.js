function solution(s)
{
    var answer = -1;

    let st = [];
    for(let i=0; i<s.length; i++){
        const tmp = s[i];
        if(st.length > 0 && st[st.length -1] == tmp) st.pop();
        else st.push(tmp);
    }
    
    answer = st.length === 0 ? 1 : 0;

    return answer;
}
