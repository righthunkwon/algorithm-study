function solution(video_len, pos, op_start, op_end, commands) {
    // 분 -> 초로 바꾸기
    const minToSec = (time) => Number(time.slice(0, 2)) * 60 + Number(time.slice(3));
    
    let pos_sec = minToSec(pos);
    const len_sec = minToSec(video_len);
    
    // "next"
    const next = (cur) => {
        const res = cur + 10;
        if(res >= len_sec) return len_sec;
        return res;
    }
    
    // "prev"
    const prev = (cur) => {
        const res = cur - 10;
        if(res < 0) return 0;
        return res;
    }
    
    // 오프닝 스킵
    const skip = (cur) => {
        return minToSec(op_start) <= cur && cur <= minToSec(op_end);
    }
    
    // pos가 오프닝 구간이면 스킵하고 시작
    pos_sec = skip(pos_sec) ? minToSec(op_end) : pos_sec;
    
    // 커맨드 하나씩 돌리기
    commands.forEach(cmd => {
        if(cmd === 'next') pos_sec = next(pos_sec);
        else pos_sec = prev(pos_sec);
        
        // 오프닝 구간 자동 스킵
        if(skip(pos_sec)) pos_sec = minToSec(op_end);
        
    })
    
    const minute = Math.floor(pos_sec / 60).toString().padStart(2, '0');
    const second = (pos_sec % 60).toString().padStart(2, '0');
    
    return `${minute}:${second}`;
}
