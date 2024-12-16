const fs = require('fs');
const filePath = process.platform === 'linux' ? 'dev/stdin' : '백준_js/BOJ_1283/input.txt';
const input = fs.readFileSync(filePath).toString().replace(/\r/g, '').trim().split('\n');

// console.log(input);

// 단축키는 Set으로 관리 (중복되면 안되니까)
// 단어 첫 글자 -> 전체 문자열

const f = new Set();
const ans = [];

for(let option of input.slice(1)) {
    // 단어로 분리
    const str = option.split(' ');
    // 단축키 설정되면 true
    let flag = false;

    // 단어 첫 글자 단축키 설정
    for(let i = 0; i < str.length; i++) {
        const key = str[i][0].toLowerCase(); // 소문자로 변환
        if(!f.has(key)) {
            f.add(key); // 단축키로 추가
            str[i] = `[${str[i][0]}]` + str[i].slice(1);
            flag = true;
            break;
        }
    }

    // 전체 문자열
    if(!flag) {
        for(let i = 0; i < option.length; i++) {
            const key = option[i].toLowerCase();
            if(key !== ' ' && !f.has(key)) { // 공백이 아니고, 단축키 설정 안되있으면
                f.add(key); // 단축키로 추가
                option = option.slice(0, i) + `[${option[i]}]` + option.slice(i + 1);
                flag = true;
                break;
            }
        }
    }

    // 저장
    if(!flag) ans.push(option);
    else {
        if(option.includes('[')) ans.push(option);
        else ans.push(str.join(' '));
    }

}

console.log(ans.join('\n'));
