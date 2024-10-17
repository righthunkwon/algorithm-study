function solution(words) {
    var answer = 0;
    
    class Node {
        constructor() {
            this.children = {};
            this.cnt = 0; // 글자가 몇 번 나오는지 기록
        }
    }
    
    class Trie {
        constructor() {
            this.root = new Node();
        }
        
        insert(word) {
            let cur = this.root;
            for(let char of word) {
                if(!cur.children[char]) cur.children[char] = new Node();
                
                cur = cur.children[char];
                cur.cnt++;
            }
        }
        
        // cnt가 1인 글자까지 확인하면 다른 단어랑 구분 가능
        sol(word) {
            let cur = this.root;
            let count = 0;
            for(let char of word) {
                count++;
                cur = cur.children[char];
                if(cur.cnt === 1) return count;
            }
            return count;
        }
    }
    
    const trie = new Trie();
    words.forEach(v => trie.insert(v));
    
    words.forEach(v => {
        answer += trie.sol(v);
    })
    
    return answer;
}
