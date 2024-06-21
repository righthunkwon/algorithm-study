// dfs로 풀기

function solution(expression) {
    // 1단계 숫자와 연산자 배열로 분리 => match 함수를 쓰는 법도 있다.
    const nums = expression.split(/[*+-]/).filter(v => /\d/.test(v)).map(Number);
    const ops = expression.split(/\d+/).filter(v => /\D/.test(v));
    return dfs(nums, ops);
}

function calculate(a, b, operator) {
    // 2단계 연산자 어떻게 작동할지 설정, eval은 쓰면 안되서
    switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
    }
}

function dfs(nums, ops) {
    if (ops.length === 0) {
        return Math.abs(nums[0]);
    }
    let max = 0;

    const uniqueOps = Array.from(new Set(ops));
    for (let i = 0; i < uniqueOps.length; i++) {
        const operator = uniqueOps[i];
        const newNums = [];
        const newOps = [];
        let tempNums = [...nums];
        let tempOps = [...ops];

        for (let j = 0; j < tempOps.length; j++) {
            if (tempOps[j] === operator) {
                tempNums[j + 1] = calculate(tempNums[j], tempNums[j + 1], operator);
                // 수도에서는 전위로 했는데 반복문 구조 상 후위로
                tempNums[j] = null;
            } else {
                newOps.push(tempOps[j]);
            }
        }
        for (let num of tempNums) {
            if (num !== null) {
                newNums.push(num);
            }
        }
        const result = dfs(newNums, newOps);
        if (result > max) {
            max = result;
        }
    }
    return max;
}