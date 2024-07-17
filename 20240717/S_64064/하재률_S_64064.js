function solution(user_id, banned_id) {
    const chk = Array.from(Array(user_id.length), () => false);
    const set = new Set();
    
    const isMatch = (user, banned) => {
        if(user.length !== banned.length) return false;
        for(let i = 0; i < user.length; i++)
            if(banned[i] !== '*' && user[i] !== banned[i]) return false;
        
        return true;
    }
    
    const dfs = (idx, str, cnt) => {
        if(cnt === banned_id.length) {
            let arr = str.split(' ');
            arr.shift();
            arr.sort();
            set.add(arr.join(''));
        }
        if(idx >= user_id.length) return;
        
        for(let i = idx; i < banned_id.length; i++) {
            for(let j = 0; j < user_id.length; j++) {
                if(chk[j] || !isMatch(user_id[j], banned_id[idx])) continue;
                chk[j] = true;
                dfs(i+1, str+ ' ' + user_id[j], cnt+1);
                chk[j] = false;
            }
        }
    }
    
    dfs(0, '', 0);
    
    return set.size;
}
