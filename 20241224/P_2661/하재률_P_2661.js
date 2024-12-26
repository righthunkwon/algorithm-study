const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_2661/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

const N = +input;

// 뒤에서부터 1개씩, 2개씩, ... 비교
const isGood = (arr) => {
    const len = arr.length;

    for(let i = 1; i <= Math.floor(len / 2); i++) {
    // console.log(arr, arr.slice(len - i * 2, len - i),'이랑',arr.slice(len - i))

        if(arr.slice(len - i * 2, len - i) === arr.slice(len - i)) return false;
    }
    return true;
}

const dfs = (arr) => {
    // 좋은 수열 출력하고 종료
    if(arr.length === N) {
        console.log(arr);
        process.exit();
    }

    // 1~3 1부터 붙여서 arr만들기
    for(let i = 1; i <= 3; i++) {
        const nextArr = arr + i;
        if(isGood(nextArr)) dfs(nextArr);
    }
}

dfs('');
