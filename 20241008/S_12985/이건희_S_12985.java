class Solution
{
    public int solution(int n, int a, int b)
    {   
        int answer = 0;
        while(a != b){
            a = (a+1)/2;// 4 => 2 => 1 => 1
            b = (b+1)/2;// 5 => 3 => 2 => 1
            answer++;
        }
        return answer;
    }
}
// 4 7 => 2 4 => 1 2 
// 4 6 => 2 3 => 1 2
// 4 5 => 2 3 => 1 2