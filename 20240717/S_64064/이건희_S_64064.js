// 테스트 케이스 5번이 (2638.17ms, 77.6MB) 이렇게 나오는 것 봐서는 잘 못 푼 듯?
// 과정은 필터링 하고 조합 구하고 Set에 넣어서 필터링 하고 Set 길이 반환
function solution(userIds, bannedIds) {
    const bannedMappings = bannedIds.map(bannedId =>
        userIds.filter(userId => isValid(userId, bannedId))
    ); // 조건에 맞는 유저 아이디만 남기기
    // userIds: ["frodo", "fradi", "crodo", "abc123", "frodoc"]
	// bannedIds: ["fr*d*", "*rodo", "******", "******"]
    // ["fradi", "frodo"]  => fr*d*
    // ["frodo", "crodo"]  => *rodo
    // ["frodo", "fradi", "crodo", "abc123", "frodoc"]  => ******
    // ["frodo", "fradi", "crodo", "abc123", "frodoc"]  => ******

    const queue = [[]];// 일단 가능한 조합 다 모으기, 구조는 [제한할 유저 아이디, 
    let index = 0;

    while (index < bannedIds.length) {
        const length = queue.length;
        for (let i = 0; i < length; i++) {
            const current = queue.shift(); // 앞에꺼 꺼내서

            for (const userId of bannedMappings[index]) {
                if (!current.includes(userId)) {
                    const newCombination = [...current, userId];
                    queue.push(newCombination); // 큐에 넣기
                }
            }
        }
        index++;
    }

    // Set으로 가능한 조합 필터링
    const uniqueCombinations = new Set(
        queue.map(combination => combination.sort().join(','))
    );

    return uniqueCombinations.size;
}

function isValid(userId, bannedId) {
    if (userId.length !== bannedId.length) return false; // 글자수 안 맞으면 패스
    for (let i = 0; i < userId.length; i++) {
        if (bannedId[i] !== '*' && userId[i] !== bannedId[i]) { // *표 와일드 카드
            return false;
        }
    }
    return true; // 모든 조건을 만족하면 true
}

// 재귀
// function 조합생성(입력조합, index) {
//     if (index === bannedMappings.length) {
//         const 정렬조합 = 입력조합.정렬.조인;
//         combinations.add(정렬조합);
//         return;
//     }

//     // 현재 단계에서 가능한 모든 유저 아이디를 순회
//     for (const userId of bannedMappings[index]) {
//         if (입력조합.includes(userId)에 없을시 !) {
//             조합생성([...입력조합, userId], index + 1);
//         }
//     }
// }