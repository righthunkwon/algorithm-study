function solution(book_time) {
    let answer = 0;
    
    // 시간:분 => 분
    const time = (tt) => {
        const t = tt.split(':');
        return parseInt(t[0]) * 60 + parseInt(t[1]);
    }
    // { start : 시작시간, end : 퇴실시간 }
    const book = book_time.map(v => {
        return {
            start : time(v[0]),
            end : time(v[1])
        }
    })
    
    book.sort((a, b) => a.start - b.start || a.end - b.end);
    
    const room = [];
    // console.log(book)
    book.forEach(v => {
        let flag = false;
        for(let i = 0; i < room.length; i++) {
            if(room[i]+10 <= v.start) {
                // 방 비면 종료시간 갱신
                room[i] = v.end;
                flag = true;
                break;
            }
        }
        // 빈 방 없으면 새로운 방
        if(!flag) {
            room.push(v.end);
            answer++;
        }
    })
    
    return answer;
}
