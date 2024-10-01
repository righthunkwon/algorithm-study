function solution(numbers) {
    // 소수인지 판별하는 함수
    const isPrime = (num) => {
        if(num < 2) return false;
        for(let i = 2; i <= Math.sqrt(num); i++) {
            if(num % i === 0) return false;
        }
        return true;
    }
    
    // 숫자 하나씩 쪼개기
    const number = numbers.split('');
    // 중복 체크를 위한 Set
    const set = new Set();
    
    // 한자리 수, 두자리 수.. 다 만들어서 확인
    const dfs = (arr, cur) => {
        if(cur.length > 0) {
            const n = parseInt(cur.join(''), 10);
            if(isPrime(n)) set.add(n);
        }
        
        for(let i = 0; i < arr.length; i++) {
            const newArr = [...arr.slice(0, i), ...arr.slice(i + 1)];
            dfs(newArr, [...cur, arr[i]]);
        }
    }
    
    dfs(number, []);
    
    // console.log(set)
    
    
    return set.size;
}
