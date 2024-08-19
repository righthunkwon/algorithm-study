class Solution
{
    public int solution(String s)
    {
        int answer = 1; //정답 최소 1
        
        if(s.length()==1)return 1;
        
        for(int i=1;i<s.length()-1;i++){  
            //현재 문자 앞뒤가 같은 경우 해당 문자 중심으로 하는 최대 펠린드롬 길이 계산
            if(s.charAt(i-1)==s.charAt(i+1)){
                int l = i-1;
                int r = i+1;
                int len = 3;
                while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                    len = r-l+1;
                    l--;
                    r++;
                }
                answer = Math.max(answer,len);
            }
            
            //현재 문자가 이전 문자와 같은 경우 짝수 펠린드롬 최대 길이 계산
            if(s.charAt(i)==s.charAt(i-1)){
                int l = i-1;
                int r = i;
                int len = 2;
                while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                    len = r-l+1;
                    l--;
                    r++;
                }
                answer = Math.max(answer,len);
            }
        
        }
        
        //범위 때문에 못한 반례 (맨뒤 두글자만 같은 경우..테케 22,24에서 틀림)
        if(s.length()>=2&&s.charAt(s.length()-1)==s.charAt(s.length()-2)){
            answer=Math.max(answer,2);
        }

        return answer;
    }
}
