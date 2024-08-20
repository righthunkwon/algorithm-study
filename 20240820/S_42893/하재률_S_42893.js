function solution(word, pages) {
    // 검색어는 모두 소문자로 체크
    word = word.toLowerCase();
    
    const map = new Map();
    
    // .+ -> 줄바꿈 문자(\n)를 제외한 모든 문자가 1번 이상 반복되는
    // /g -> 일치하는 모든 결과를 반환
    
    // url 가져오기 -> <meta property="og:url" ....> 에서 "https://....를 찾아서 반환"
    const getUrl = (page) => {
        return page.match(/<meta property="og:url" .+>/g)[0].match(/"https:\/\/.+"/g)[0];
    }
    
    // 외부링크 가져오기 -> <a href=...>가 존재한다면 https://... 을 배열로 반환
    // page.match(/<a href=.+>/gi) 하면 4, 6, 8, 10, 17 실패뜸 ㅡㅡ
    // \S는 띄어쓰기, 탭, 줄 바꿈 문자 등의 공백 문자가 아닌 문자를 검색.. 
    // 공백 포함한 비정상 url이 a태그에 존재하는 테케가 있나보다
    const getLink = (page) => {
        const aTag = page.match(/<a href=\S+>/gi);
        return aTag ? aTag.map((link) => link.match(/"https:\/\/.+"/g)[0]) : [];
    }
    
    // 기본 점수 -> 소문자 영단어들만 찾아 word와 일치?
    const getBasicScore = (page) => {
        page = page.toLowerCase();
        return page.match(/[a-z]+/g).filter((e) => e === word).length;
    }
    
    // url => {idx : 0, basicScore : 0, link: [ ... ], matchScore: 0} 으로 정리
    pages.forEach((page, idx) => {
        const url = getUrl(page);
        const links = getLink(page);
        const basicScore = getBasicScore(page);
        
        map.set(url, {idx, basicScore, links, matchScore: basicScore});
    })
    
    map.forEach((info, url) => {
        info.links.forEach(link => {
            if(map.has(link)) map.get(link).matchScore += info.basicScore / info.links.length;
        })
    })
    
    // console.log(map)
    let max = -1;
    let ans = -1;
    
    // matchScore 가장 큰 거.. 같다면 idx 가장 작은거 반환
    map.forEach((info) => {
        if(info.matchScore > max || (info.matchScore === max && info.idx < ans)) {
            max = info.matchScore;
            ans = info.idx;
        }
    })
    
    return ans;
}
