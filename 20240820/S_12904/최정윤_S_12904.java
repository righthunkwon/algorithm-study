class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        //팰린드롬 길이 2500이하
        for(int i=s.length();i>=1;i--){
            //팰린드롬의 시작시점
            h: for(int j=0;j<=s.length()-i;j++){
                int st_idx=j;
                int ed_idx=j+i-1;
                // System.out.println(j+"ss"+i+"SS"+s.length());
                //펠린드롬인지 판별
                while(st_idx<ed_idx){                   
                    if(s.charAt(st_idx)==s.charAt(ed_idx)){
                        st_idx++;
                        ed_idx--;
                    }else{
                        continue h;
                    }
                }
                return i;
            }
        } 
        return answer;
    }
}
